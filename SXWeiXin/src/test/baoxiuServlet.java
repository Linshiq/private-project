package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class baoxiuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger looger = Logger.getLogger(baoxiuServlet.class);
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		looger.debug("baoxiuServlet.doGet>>>>>>>>>>>");
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				String[] info = null;
				// 从请求中取出用户名和密码
				
				String ii = request.getParameter("custno");
				
				if (null !=ii  && ii.length() >0) {
					info = ii.split("!-!-!-!-!-!-!");
				}
				

				int i = 0, j = 0;
				if (null !=info  && info.length >0) {
					info = ii.split("!-!-!-!-!-!-!");
				
				for (String str : info) {
					if ("updateTBL".equals(str)) {
						System.out.println("UPDATE" + "CUSTNO:" + info);
						i = ConnectionJDBCTest.update(info[0]);
					} else if ("deleteTBL".equals(str)) {
						System.out.println("DELETE");
						j = ConnectionJDBCTest.delete(info[0]);
					}
				}}
				// 生成一个Session对象
				HttpSession session = request.getSession(true);
				
				   session.setAttribute("userPwd", "userPwd=");
				session.setAttribute("error", "i=" + i + "j=" + j);
				looger.debug("baoxiuServlet.doGet<<<<<<<<<<<");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/static/jsp/baoxiutest.jsp");
		dispatcher.forward(request, response);

	}
   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 从请求中取出用户名和密码
		String[] info = request.getParameter("custno").split("!-!-!-!-!-!-!");

		int i = 0, j = 0;
		for (String str : info) {
			if ("updateTBL".equals(str)) {
				System.out.println("UPDATE" + "CUSTNO:" + info);
				i = ConnectionJDBCTest.update(info[0]);
			} else if ("deleteTBL".equals(str)) {
				System.out.println("DELETE");
				j = ConnectionJDBCTest.delete(info[0]);
			}
		}
		// 生成一个Session对象
		HttpSession session = request.getSession(true);
		if (info.length<0) {
			session.setAttribute("userPwd", "userPwd=null");
		}else{
			StringBuffer sBuffer= new StringBuffer();
			for(String msg:info)
				sBuffer.append(msg+"|");
		    session.setAttribute("userPwd", "userPwd="+ sBuffer.toString());
		}
		session.setAttribute("error", "i=" + i + "j=" + j);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/11.jsp");
		dispatcher.forward(request, response);
	}

}
