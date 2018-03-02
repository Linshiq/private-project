package menu_center.bjb_baoxiu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BJBBaoXiuServelet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

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
		if (null != request.getParameter("custno") && request.getParameter("custno").length() > 0) {
			String[] info = request.getParameter("custno").split("!-!-!-!-!-!-!");

			for (String str : info) {
				if ("updateTBL".equals(str)) {
					BJBBaoXiuWrite.update(info[0]);
				} else if ("deleteTBL".equals(str)) {
					BJBBaoXiuWrite.delete(info[0]);
				}
			}
		}
		HttpSession session = request.getSession(true);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/static/jsp/bbjbaoxiuList.jsp?Login=Login");
		dispatcher.forward(request, response);

	}

}
