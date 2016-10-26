package com.job.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.FileItem;

import com.job.service.UploadService;

@WebServlet("/UpLoadServlet")
public class UpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建文件上传对象
		DiskFileUpload disk = new DiskFileUpload();
		// 读取请求对象中的输入流获取提交对象集合
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> fileList = disk.parseRequest(request);
			HttpSession session=request.getSession();
			String absoluatepath=getServletContext().getRealPath("/");
			UploadService ups=new UploadService();
			int userid=(Integer)session.getAttribute("userid");
			if(ups.upLoad(fileList, disk, absoluatepath, userid)){
				///上传成功
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
