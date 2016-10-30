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
import org.apache.commons.fileupload.FileItem;

import com.job.bean.User;
import com.job.daoImpl.UserDaoImpl;
import com.job.service.UploadService;

/**
 * Servlet implementation class ModifyPersonServlet
 */
@WebServlet("/ModifyPersonServlet")
public class ModifyPersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UploadService ups=new UploadService();
	private UserDaoImpl usdpl=new UserDaoImpl();
	private int userId;
    public ModifyPersonServlet() {
        super();
     
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sex = request.getParameter("sex");
		System.out.println(sex);
		// 创建文件上传对象
		DiskFileUpload disk = new DiskFileUpload();
		// 读取请求对象中的输入流获取提交对象集合
		try {
			@SuppressWarnings("unchecked")
			List<FileItem> fileList = disk.parseRequest(request);
				HttpSession session = request.getSession();
				String absoluatepath = getServletContext().getRealPath("/");
				User user = (User) session.getAttribute("user");
				if (user != null) {
					userId = user.getUserId();
				}
				if (ups.upLoad(fileList, disk, absoluatepath, userId)) {
					/// 上传成功
					if (ups.updateSexByUserId(sex, userId)) {
						User user2 = usdpl.getUser(userId);
						session.setAttribute("user", user2);
						request.getRequestDispatcher("PersonInforServlet.do").forward(request, response);
					}
				}else {
				request.setAttribute("error", "修改信息失败！");
				request.getRequestDispatcher("PersonInforServlet.do").forward(request, response);
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
