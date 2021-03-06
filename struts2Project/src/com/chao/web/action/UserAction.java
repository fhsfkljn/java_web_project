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

	// ----------------------------用户登陆的动作方法-----------------------

	public String login() {
		User dbUser = service.login(user.getLogonName(), user.getLogonPwd());
		// 判断用户是否查到
		if (dbUser == null) {
			addActionError("用户名或密码错误");
			return "input";
		}
		// 登陆成功
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", dbUser);

		return SUCCESS;
	}

	// ----------------------------用户添加的动作方法-----------------------
	// 保存文件的file
	private File upload;
	// 文件名
	private String uploadFileName;

	public String add() {
		// 1.保存文件路径
		String filePath = ServletActionContext.getServletContext().getRealPath("/files");
		String dir = generateChildPath(filePath);
		// 2.生成带有随机性的文件名
		String fileName = TokenHelper.generateGUID() + "_" + uploadFileName;
		// 3.把user模型中缺少的属性填充进去
		user.setPath(dir);
		user.setFilename(fileName);
		// 4.上传文件操作
		upload.renameTo(new File(filePath + File.separator + dir, fileName));
		// 5.保存用户
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

	// ----------------------------查询所有用户-----------------------
	// 用于存放查询出来的用户
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

	// ----------------------------查询用户的详细信息----------------------

	public String findUserById() {
		// 根据userID获取user对象
		user = service.findUserById(user.getUserID());
		// 把user对象压入栈顶
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}

	// ----------------------------下载简历文件----------------------
	private InputStream inputStream;
	private String oldFileName;

	public String download() throws FileNotFoundException {
		// 1.获取用户信息
		User dbUser = service.findUserById(user.getUserID());
		// 2.文件存放路径
		String filePath = ServletActionContext.getServletContext().getRealPath("/files");
		oldFileName = dbUser.getFilename().substring(dbUser.getFilename().indexOf("_") + 1);
		// 3.给字节输入流赋值
		inputStream = new FileInputStream(
				filePath + File.separator + dbUser.getPath() + File.separator + dbUser.getFilename());
		// 4.返回成功
		return SUCCESS;
		// 5.剩下的交给stream类型的结果视图
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

	// ----------------------------删除用户----------------------

	public String delete() {
		int result = service.removeUser(user.getUserID());
		if (result > 0) {
			return SUCCESS;
		}
		return null;

	}

	// ------------显示编辑页面的动作方法--------------------
	public String editUI() throws Exception {
		// 根据userID获取user对象
		user = service.findUserById(user.getUserID());
		// 把user对象压入栈顶
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.push(user);
		return SUCCESS;
	}

	// --------------编辑用户-----------------------
	public String edit() throws Exception {
		// 1.判断用户是否重新选择了文件
		if (upload == null) {
			// 没有选择文件。我们就用原来的
			User dbUser = service.findUserById(user.getUserID());// 根据用户id把用户先查出来
			// 由于没有选择文件，user模型中的filename和path属性都是null，我们需要用查出来的用户里面的值替换
			user.setFilename(dbUser.getFilename());
			user.setPath(dbUser.getPath());
			int res = service.modify(user);
			if (res > 0) {
				return SUCCESS;
			}
		} else {
			// 用户重新选择了文件
			// 1.文件保存的路径
			String filePath = ServletActionContext.getServletContext().getRealPath("/files");
			String dir = generateChildPath(filePath);
			// 2.生成带有随机性的文件名:
			String fileName = TokenHelper.generateGUID() + "_" + uploadFileName;// DSK32JJKSDF2LKDSFSDFJK_uploadFileName;
			// 3.把user模型中缺少的属性，填充进去
			user.setPath(dir);
			user.setFilename(fileName);// 保存的文件名必须是带有GUID的文件名。下载的时候还要用呢
			// 4.上传文件操作
			upload.renameTo(new File(filePath + File.separator + dir, fileName));
			// 5.保存用户
			int res = service.modify(user);
			if (res > 0) {
				return SUCCESS;
			}
		}
		return null;
	}

	// --------------多条件查询--------------------------
	private String isUpload;

	public String findUserByCondition() throws Exception {
		// 根据条件查询用户。特殊的条件是isUpload，因为他有三种情况：第一种：请选择，忽略此条件。
		// 第二种：有简历，只查询带有简历的用户。第三种，无简历，只查询没有简历的用户
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
