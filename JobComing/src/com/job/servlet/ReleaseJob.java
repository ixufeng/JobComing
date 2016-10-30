package com.job.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.job.bean.JobPublish;
import com.job.bean.User;
import com.job.daoImpl.AddressCityDaoImpI;
import com.job.daoImpl.AddressTownDaoImpI;
import com.job.daoImpl.AgreeMentDaoImpl;
import com.job.daoImpl.JobPublishImpI;
import com.job.util.TimeUtils;

/**
 * 发布工作或者删除工作
 * 
 * @author xufeng
 *
 */
@WebServlet("/ReleaseJob.do")
public class ReleaseJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JobPublishImpI jpi = new JobPublishImpI();
	private AgreeMentDaoImpl amdi = new AgreeMentDaoImpl();
	private AddressCityDaoImpI cImpI = new AddressCityDaoImpI();
	private AddressTownDaoImpI tImpI = new AddressTownDaoImpI();

	public ReleaseJob() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		User u = (User) request.getSession().getAttribute("user");
		if ("release".equalsIgnoreCase(action)) {
			// 发布工作
			if (u != null) {
				JobPublish jobPublish = new JobPublish();
				Date beginTime = null;
				Date overTime = null;
				int userId = u.getUserId();
				int kindId = Integer.parseInt(request.getParameter("jobKindId"));
				String location = request.getParameter("address");
				int addressNumber = cImpI.getAddressCityByCityName(location).getCityCode();
				if (addressNumber == 0) {
					addressNumber = tImpI.geAddressTownByTownName(location).getTownCode();
				}
				if (TimeUtils.formatDate(request.getParameter("beginTime")) != null) {
					beginTime = TimeUtils.formatDate(request.getParameter("beginTime"));

					if (TimeUtils.formatDate(request.getParameter("overTime")) != null) {
						overTime = TimeUtils.formatDate(request.getParameter("beginTime"));
						String describe = request.getParameter("describe");
						String detailAddress = request.getParameter("detailaddress");
						jobPublish.setAddressNumber(addressNumber);
						jobPublish.setDetailAddress(detailAddress);
						jobPublish.setIsValidate(1);
						jobPublish.setUserId(userId);
						jobPublish.setJobKindId(kindId);
						jobPublish.setJobPublishTime(new Date());
						jobPublish.setWorkBeginTime(beginTime);
						jobPublish.setWorkOverTime(overTime);
						jobPublish.setWorkDescribe(describe);
						if(jpi.add(jobPublish)==1){
							request.getRequestDispatcher("MainPageServlet").forward(request, response);
						}else{
							request.getRequestDispatcher("JobPublish.jsp").forward(request, response);
						}
					}
				}
			} else {
				request.getRequestDispatcher("JobPublish.jsp").forward(request, response);
			}

		}
		if ("reach".equalsIgnoreCase(action)) {
			if (u != null) {
				int userId = u.getUserId();
				int pCount = (int) jpi.getCountByUserId(userId);
				int cCount = (int) amdi.getCountByUserId(userId);
				request.setAttribute("pCount", pCount);
				request.setAttribute("cCount", cCount);
				request.getRequestDispatcher("JobPublish.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("MainPageServlet").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
