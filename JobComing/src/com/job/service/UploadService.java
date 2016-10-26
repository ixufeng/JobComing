package com.job.service;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;


import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.tomcat.util.http.fileupload.FileItem;

import com.job.daoImpl.UserDaoImpl;

public class UploadService {
	/**
	 * 上传
	 * 
	 * @param rsq
	 */
	public boolean upLoad(List<FileItem> fileList,DiskFileUpload disk , String absolutepath,int userid) {
		// 建立标识
		boolean isSuccess = true;
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
		try {
			// 遍历提交的对象
			for (FileItem item : fileList) {
				// 判断文件是否是上传对象
				if (!item.isFormField()) {
					Random random=new  Random();
					//获取上传文件的输入流
					InputStream input=item.getInputStream();
					// 获取上传文件的类型
					String filename = item.getName().substring(item.getName().lastIndexOf("."));
					// 获取文件类型
					int index = item.getContentType().indexOf("/");
					String contentType = item.getContentType().substring(0, index);
					// 判断是否是图片
					if (contentType.equals("image")) {
						//图片在data文件下的路径
						String name="data\\" +random.nextInt()+filename;
						String path=absolutepath+name;
						//获取输出流
						FileOutputStream output=new FileOutputStream(new File(path));
						int data;
						while((data=input.read())!=-1)
						{
							output.write(data);
						}
						//写入数据库
						updatHeadPicture(name, userid);
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
		}catch (IOException e) {
			isSuccess = false;
			e.printStackTrace();
		}
		return isSuccess;

	}
	/**
	 * 修改数据库头像路径
	 * @param path
	 * @param userid
	 * @return
	 */
	public  boolean updatHeadPicture(String path,int userid){
		UserDaoImpl ui=new UserDaoImpl();
		if(ui.update(path,userid)==1){
			return true;
		}
		return false;
	}
}
