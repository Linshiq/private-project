package menu_right.qiandao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tool.StringUtil;

import menu_right.qiandao.base.QianDao;

/**
 * @author LinShiqin:
 * @date 创建时间：2016年4月20日 上午10:25:16
 * @return
 */
public class QianDaoServelet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/11.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String deleteStr = request.getParameter("custno");

		String startTimes = request.getParameter("startTimes");
		String endTimes = request.getParameter("endTimes");

		String search = request.getParameter("search");
		String select = request.getParameter("select");
		List<QianDao> qiandaoList = null;
		int i = 0;
		if (StringUtil.strIsNotEmpty(deleteStr)) {// 删除操作
			QianDaoWrite.delete(deleteStr);

			qiandaoList = QianDaoRead.qurey("", "");
			i = 0;
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
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/WEB-INF/static/jsp/studentqiandaoList.jsp?Login=Login");
			dispatcher.forward(request, response);
			return;
		}

		// 查询操作
		if (StringUtil.strIsNotEmpty(search) && StringUtil.strIsNotEmpty(select)) {
			qiandaoList = QianDaoRead.qurey(search, select);

		}else if(StringUtil.strIsNotEmpty(startTimes) && StringUtil.strIsNotEmpty(endTimes)){
			qiandaoList = QianDaoRead.qureyDate(startTimes, endTimes);
		} else {
			qiandaoList = QianDaoRead.qurey("", "");
		}
		
		i=0;
		
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

	}

}
