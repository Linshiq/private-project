package test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import table.Ldpa_mtxfjlb;
import util.Commit;

public class TestServlet1 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		Ldpa_mtxfjlb ldpa_mtxfjlb = new Ldpa_mtxfjlb();
		ldpa_mtxfjlb.setConsumptionType("电影");
		ldpa_mtxfjlb.setDate("20161001");
		ldpa_mtxfjlb.setExpenditure(38l);
		ldpa_mtxfjlb.setId("A201610101093800");
		ldpa_mtxfjlb.setIncome(0l);
		ldpa_mtxfjlb.setRemark("");
		ldpa_mtxfjlb.setTime("约01:09");
		// 生成一个Session对象
		HttpSession session = request.getSession(true);
		session.setAttribute("Ldpa_mtxfjlb", ldpa_mtxfjlb);
		
		
		List<List<Map<String, Float>>> allMonthList = Commit.valueDateFill(request);
		
		int month = 8; //开始月份
		StringBuffer allInfo = new StringBuffer();//组装所有月份
		allInfo.append("series: [");              //组装报表数据
		for(List<Map<String, Float>> one:allMonthList){
			StringBuffer monthSB = new StringBuffer();//拼接月份数据
			monthSB.append("{");
			monthSB.append("name: '"+ month +"月份'").append(",");
			monthSB.append("data:[");
			for(Map<String, Float> two:one){
				String s = two.values().toString();			
				monthSB.append(s.subSequence(s.indexOf("[")+1, s.indexOf("]"))).append(",");
			}
			monthSB.append("]},");
			allInfo.append(monthSB);
			month++;
		}
		allInfo.append("]");
		StringBuffer xSb = new StringBuffer(); //建立X轴
		xSb.append("categories:[");
		for(int i=1;i<=31;i++)
			xSb.append("'"+i+"'").append(",");
		xSb.append("]");
		StringBuffer ySb = new StringBuffer();
		ySb.append("categories:["); 		//建立Y轴
		for(int i=0;i<=2000;i=i+100)
			ySb.append("'"+i+"'").append(",");
		ySb.append("]");
//		String jine = "series: ["+"{  name: '无用线', data: [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4] }"
//				+ ", { name: '8月份金额曲线', data: [76,35,36.37,42.3,51.8,41.1,39.5,45.5,41.15,36.5,8,734.18,50,-758.5,143.5,98,41,49,97]}"
//				+"]";
//		session.setAttribute("date", jine);
		session.setAttribute("data2", allInfo.toString());
		session.setAttribute("x", xSb.toString());
		session.setAttribute("y", ySb.toString());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/baobiao.jsp");
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


		// 生成一个Session对象
		HttpSession session = request.getSession(true);
		if (info.length < 0) {
			session.setAttribute("userPwd", "userPwd=null");
		} else {
			StringBuffer sBuffer = new StringBuffer();
			for (String msg : info)
				sBuffer.append(msg + "|");
			session.setAttribute("userPwd", "userPwd=" + sBuffer.toString());
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/11.jsp");
		dispatcher.forward(request, response);
	}
}
