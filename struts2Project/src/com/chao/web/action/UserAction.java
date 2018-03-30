package com.chao.web.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import com.chao.domain.User;
import com.chao.service.IUserService;
import com.chao.service.impl.UserServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private IUserService service = new UserServiceImpl();
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// ----------------------------�û���½�Ķ�������-----------------------

	public String login() {
		User dbUser = service.login(user.getLogonName(), user.getLogonPwd());
		// �ж��û��Ƿ�鵽
		if (dbUser == null) {
			addActionError("�û������������");
			return "input";
		}
		// ��½�ɹ�
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", dbUser);

		return SUCCESS;
	}

	// ----------------------------�û���ӵĶ�������-----------------------
	// �����ļ���file
	private File upload;
	// �ļ���
	private String uploadFileName;

	public String add() {
		// 1.�����ļ�·��
		String filePath = ServletActionContext.getServletContext().getRealPath("/files");
		String dir = generateChildPath(filePath);
		// 2.���ɴ�������Ե��ļ���
		String fileName = TokenHelper.generateGUID() + "_" + uploadFileName;
		// 3.��userģ����ȱ�ٵ���������ȥ
		user.setPath(dir);
		user.setFilename(fileName);
		// 4.�ϴ��ļ�����
		upload.renameTo(new File(filePath + File.separator + dir, fileName));
		// 5.�����û�
		int result = service.saveUser(user);
		if (result > 0) {
			return SUCCESS;
		}
		return "input";

	}

	private String generateChildPath(String filePath) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dir = format.format(date);
		File file = new File(filePath, dir);
		if (!file.exists()) {
			file.mkdirs();
		}
		return dir;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	// ----------------------------��ѯ�����û�-----------------------
	// ���ڴ�Ų�ѯ�������û�
	private List<User> users;

	public String findAll() throws Exception {
		users = service.findAllUser();
		return SUCCESS;

	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	// ----------------------------��ѯ�û�����ϸ��Ϣ----------------------

	public String findUserById() {
		// ����userID��ȡuser����
		user = service.findUserById(user.getUserID());
		// ��user����ѹ��ջ��
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}

	// ----------------------------���ؼ����ļ�----------------------
	private InputStream inputStream;
	private String oldFileName;

	public String download() throws FileNotFoundException {
		// 1.��ȡ�û���Ϣ
		User dbUser = service.findUserById(user.getUserID());
		// 2.�ļ����·��
		String filePath = ServletActionContext.getServletContext().getRealPath("/files");
		oldFileName = dbUser.getFilename().substring(dbUser.getFilename().indexOf("_") + 1);
		// 3.���ֽ���������ֵ
		inputStream = new FileInputStream(
				filePath + File.separator + dbUser.getPath() + File.separator + dbUser.getFilename());
		// 4.���سɹ�
		return SUCCESS;
		// 5.ʣ�µĽ���stream���͵Ľ����ͼ
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getOldFileName() {
		return oldFileName;
	}

	public void setOldFileName(String oldFileName) {
		this.oldFileName = oldFileName;
	}

	// ----------------------------ɾ���û�----------------------

	public String delete() {
		int result = service.removeUser(user.getUserID());
		if (result > 0) {
			return SUCCESS;
		}
		return null;

	}

	// ------------��ʾ�༭ҳ��Ķ�������--------------------
	public String editUI() throws Exception {
		// ����userID��ȡuser����
		user = service.findUserById(user.getUserID());
		// ��user����ѹ��ջ��
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}

	// --------------�༭�û�-----------------------
	public String edit() throws Exception {
		// 1.�ж��û��Ƿ�����ѡ�����ļ�
		if (upload == null) {
			// û��ѡ���ļ������Ǿ���ԭ����
			User dbUser = service.findUserById(user.getUserID());// �����û�id���û��Ȳ����
			// ����û��ѡ���ļ���userģ���е�filename��path���Զ���null��������Ҫ�ò�������û������ֵ�滻
			user.setFilename(dbUser.getFilename());
			user.setPath(dbUser.getPath());
			int res = service.modify(user);
			if (res > 0) {
				return SUCCESS;
			}
		} else {
			// �û�����ѡ�����ļ�
			// 1.�ļ������·��
			String filePath = ServletActionContext.getServletContext().getRealPath("/files");
			String dir = generateChildPath(filePath);
			// 2.���ɴ�������Ե��ļ���:
			String fileName = TokenHelper.generateGUID() + "_" + uploadFileName;// DSK32JJKSDF2LKDSFSDFJK_uploadFileName;
			// 3.��userģ����ȱ�ٵ����ԣ�����ȥ
			user.setPath(dir);
			user.setFilename(fileName);// ������ļ��������Ǵ���GUID���ļ��������ص�ʱ��Ҫ����
			// 4.�ϴ��ļ�����
			upload.renameTo(new File(filePath + File.separator + dir, fileName));
			// 5.�����û�
			int res = service.modify(user);
			if (res > 0) {
				return SUCCESS;
			}
		}
		return null;
	}

	// --------------��������ѯ--------------------------
	private String isUpload;

	public String findUserByCondition() throws Exception {
		// ����������ѯ�û��������������isUpload����Ϊ���������������һ�֣���ѡ�񣬺��Դ�������
		// �ڶ��֣��м�����ֻ��ѯ���м������û��������֣��޼�����ֻ��ѯû�м������û�
		users = service.findUserByCondition(user.getUserName(), user.getGender(), user.getEducation(), isUpload);
		return SUCCESS;
	}

	public String getIsUpload() {
		return isUpload;
	}

	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}
	
	

}
