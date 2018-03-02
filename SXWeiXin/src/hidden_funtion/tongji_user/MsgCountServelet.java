package hidden_funtion.tongji_user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tool.StringUtil;

/** 
* @author  LinShiqin: 
* @date 创建时间：2016年4月22日 上午9:44:58 
* @return  
*/
public class MsgCountServelet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/static/jsp/login.jsp");
		dispatcher.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		String resultName ="";
		
		if(StringUtil.strIsNotEmpty(name)){
			resultName = WeiXinUserName.getName(name);
		}else
			resultName = "查询失败";
		
		if(!StringUtil.strIsNotEmpty(resultName)){
			resultName = "查询失败";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/static/jsp/userFZ.jsp?resultName="+resultName);
		dispatcher.forward(request, response);
	}

	
	
}
