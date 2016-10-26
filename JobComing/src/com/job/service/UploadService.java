package com.job.service;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.FileItem;

public class UploadService {
	/**
	 * 上传
	 * 
	 * @param rsq
	 */
	public boolean upLoad(HttpServletRequest rsq, HttpServletResponse rsp, String absolutepath) {
		// 建立标识
		boolean isSuccess = true;
		// 创建文件上传对象
		DiskFileUpload disk = new DiskFileUpload();
		// 设定字符集
		disk.setHeaderEncoding("utf-8");
		// 创建临时缓存文件
		File tempDirectory = new File("d:/temp");
		if (!tempDirectory.exists()) {
			tempDirectory.mkdir();
		}
		// 设定缓冲临时文件
		disk.setRepositoryPath("d:/temp");
		// 设定缓冲文件大小 单位字节
		disk.setSizeThreshold(1024 * 10);
		// 设定上传文件大小
		disk.setSizeMax(1024 * 1024 * 10);
		// 读取请求对象中的输入流获取提交对象集合
		try {
			List<FileItem> fileList = disk.parseRequest(rsq);
			// 遍历提交的对象
			for (FileItem item : fileList) {
				// 判断文件是否是上传对象
				if (!item.isFormField()) {
					// 获取上传文件的输入流
					InputStream input = item.getInputStream();
					// 获取上传文件的文件名
					String filename = item.getName().substring(item.getName().lastIndexOf("\\" + 1));
					// 获取文件类型
					int index = item.getContentType().indexOf("/");
					String contentType = item.getContentType().substring(0, index);
					System.out.println(contentType);
					// 判断是否是图片
					if (contentType.equals("image")) {
						// 设置上传路径
						String path = absolutepath + "\\data\\" + filename;
						// 获取输出流
						FileOutputStream output = new FileOutputStream(new File(path));
						int data;

						while ((data = input.read()) != -1) {
							output.write(data);
							// 写入数据库

						}

						output.flush();
						output.close();
						input.close();
					} else {
						isSuccess = false;
					}

				}
			}
		} catch (FileNotFoundException e) {
			isSuccess = false;
			e.printStackTrace();
		} catch (FileUploadException e) {
			isSuccess = false;
			e.printStackTrace();
		} catch (IOException e) {
			isSuccess = false;
			e.printStackTrace();
		}
		return isSuccess;

	}

}
