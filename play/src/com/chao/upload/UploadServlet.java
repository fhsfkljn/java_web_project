package com.chao.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class UploadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

		// 要执行文件上传的操作,首先判断表单是否支持文件上传。即：enctype="multipart/form-data"
		boolean multipartContent = ServletFileUpload.isMultipartContent(req);
		if (!multipartContent) {
			out.print("请将表单enctype值改为：enctype=multipart/form-data");
		}

		// 创建一个DiskFileItemfactory工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 指定临时文件的存储目录
		factory.setRepository(new File("F:\\"));
		// 创建一个ServletFileUpload核心对象
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// 解决上传表单项乱码问题
		sfu.setHeaderEncoding("UTF-8");
		// 限制上传文件的大小
		// sfu.setFileSizeMax(1024*1024*3);//表示3M大小
		// sfu.setSizeMax(1024*1024*6);

		try {
			// 解析request对象，并得到一个表单项的集合
			List<FileItem> fileItems = sfu.parseRequest(req);
			// 遍历表单项数据
			for (FileItem fileItem : fileItems) {
				if (fileItem.isFormField()) {
					// 普通表单项
					processFormField(fileItem);
				} else {
					// 上传表单项
					processUploadField(fileItem);
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}

	}

	// 处理上传表单项
	private void processUploadField(FileItem fileItem) {
		try {
			// 得到文件输入流
			InputStream input = fileItem.getInputStream();
			// 创建一个文件存盘的目录
			String directoryRealPath = this.getServletContext().getRealPath("/WEB-INF/upload");
			// 既代表文件又代表目录
			File storeDirectory = new File(directoryRealPath);
			//判断当前目录是否存在
			if(!storeDirectory.exists()){
				storeDirectory.mkdirs(); // 创建文件夹
			}
			
			//得到上传文件名
			String fileName = fileItem.getName();
			// 处理文件名
			if(fileName!=null){
				// filename.substring(filename.lastIndexOf(File.separator)+1);
				fileName = FilenameUtils.getName(fileName);
			}
			// 解决文件同名的问题
			fileName = UUID.randomUUID() + "_" + fileName;
			// 目录打散,防止同一个文件夹内文件过多
			String childDirectory = makeChildDirectory(storeDirectory, fileName);
			// 在storeDirectory下，创建完整目录下的文件
			File file = new File(storeDirectory,childDirectory + File.separator + fileName);
			// 通过文件输出流将上传的文件保存到磁盘
			OutputStream os = new FileOutputStream(file);
			int length = 0;
			byte[] b = new byte[1024];
			while((length = input.read(b))!=-1){
				os.write(b,0,length);
			}
			input.close();
			os.close();
			
			//删除临时文件
			fileItem.delete();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 目录打散
	private String makeChildDirectory(File storeDirectory, String filename) {
		//获得当天的时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		
		int hashcode = filename.hashCode();// 返回字符转换的32位hashcode码
		String code = Integer.toHexString(hashcode); // 把hashcode转换为16进制的字符
		String childDirectory = date + File.separator + code.charAt(0) + File.separator + code.charAt(1);
		//创建指定目录
		File file = new File(storeDirectory, childDirectory);
		if(!file.exists()){
			file.mkdirs();
		}
		return childDirectory;
	}

	// 处理普通表单项
	private void processFormField(FileItem fileItem) {
		try {
			String name = fileItem.getFieldName();// 获得普通表单的name属性
			String value = fileItem.getString("UTF-8"); // 获得普通表单的value值
			System.out.println(name + " = " + value);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
