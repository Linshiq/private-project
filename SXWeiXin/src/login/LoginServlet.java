package login;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.base.User;
import menu_center.huiyi_dengji.HuiYiDJRead;
import menu_center.huiyi_dengji.base.HuiYi;
import menu_right.qiandao.QianDaoRead;
import menu_right.qiandao.base.QianDao;

/**
 * @author LinShiqin:
 * @date 创建时间：2016年4月20日 下午2:20:09
 * @return
 */
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/static/jsp/login.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<User> usersList = LoginRead.loginRead();
		//List<User> usersList = ConnectionJDBCTest.query();
		String type = request.getParameter("select");
		String name = request.getParameter("username");
		String psd = request.getParameter("password");

		boolean flag = false;

		if ((null != name && name.length() > 0) && (null != psd && psd.length() > 0)) {
			for (User u : usersList) {
				System.out.println(u.getUserName() +"|"+u.getUserPsd());
				if (u.getUserName().equals(name) && u.getUserPsd().equals(psd)) {
					flag = true;
					break;
				}
			}
		}

		// 生成一个Session对象
		HttpSession session = request.getSession(true);

		if (flag) {
			
			if ("电脑报修管理".equals(type)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/static/jsp/bbjbaoxiuList.jsp?Login=Login");
				dispatcher.forward(request, response);
			} else if ("签到管理".equals(type)) {
				List<QianDao> qiandaoList = QianDaoRead.qurey("", "");
				int i = 0;
				for (QianDao q : qiandaoList) {
					StringBuffer sb = new StringBuffer();
					sb.append(q.getName()).append("斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝");
					sb.append(q.getId()).append("斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝");
					sb.append(q.getMobile()).append("斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝");
					sb.append(q.getBeizhu()).append("斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝");
					sb.append(q.getHuodong()).append("斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝斝");
					sb.append(q.getDate());
					request.setAttribute("No." + i, sb.toString());
					request.setAttribute("Custno." + i, q.getCustno());
					i++;
				}
			
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/static/jsp/studentqiandaoList.jsp?Login=Login");
				dispatcher.forward(request, response);
			} else if ("会议记录管理".equals(type)) {
				List<HuiYi> huiyiList = HuiYiDJRead.query();
				int i = 0;
				for(HuiYi h:huiyiList){
					StringBuffer sb = new StringBuffer(); 
					sb.append("{"+"'columnInfo':"+"[{");
					sb.append("'advice':"+"'"+h.getAdvice()+"'"+","
							  +"'content':"+"'"+h.getContent()+"'"+","
							  +"'custno':"+"'"+h.getCustno()+"'"+","
							  +"'date':"+"'"+h.getDate()+"'"+","
							  +"'department':"+"'"+h.getDepartment()+"'"+","
							  +"'headpeople':"+"'"+h.getHeadPeople()+"'"+","
							  +"'list':"+"'"+h.getList()+"'"+","
							  +"'people':"+"'"+h.getPeople()+"'"+","
							  +"'place':"+"'"+h.getPlace()+"'"+","
							  +"'title':"+"'"+h.getTitle()+"'"+","
							  +"'realpeople':"+"'"+h.getRealPeople()+"'"+","
							);
					 sb.append("}]");
					 sb.append("}"); //json字符串到此完成   
					 request.setAttribute("huiyidengji"+i, sb.toString());
					 System.out.println("i="+i+"|"+sb.toString());
					 i++;
					
				}  
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/static/jsp/huiyidengjiList.jsp?Login=Login");
				dispatcher.forward(request, response);
			} else if ("用户统计".equals(type)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/static/jsp/userFZ.jsp?Login=Login");
				dispatcher.forward(request, response);
			}
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/static/jsp/login.jsp?error=账号或者密码错误");
			dispatcher.forward(request, response);
		}
	}

}
