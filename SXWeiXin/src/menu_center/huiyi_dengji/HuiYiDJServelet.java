package menu_center.huiyi_dengji;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tool.StringUtil;

import menu_center.huiyi_dengji.base.HuiYi;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/** 
* @author  LinShiqin: 
* @date 创建时间：2016年4月26日 上午9:30:44 
* @return  
*/
public class HuiYiDJServelet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		List<HuiYi> huiyiList = HuiYiDJRead.query();
//		int i = 0;
//		for(HuiYi h:huiyiList){
//			StringBuffer sb = new StringBuffer(); 
//			sb.append("{"+"'columnInfo':"+"[{");
//			sb.append("'advice':"+"'"+h.getAdvice()+"'"+","
//					  +"'content':"+"'"+h.getContent()+"'"+","
//					  +"'custno':"+"'"+h.getCustno()+"'"+","
//					  +"'date':"+"'"+h.getDate()+"'"+","
//					  +"'department':"+"'"+h.getDepartment()+"'"+","
//					  +"'headpeople':"+"'"+h.getHeadPeople()+"'"+","
//					  +"'list':"+"'"+h.getList()+"'"+","
//					  +"'people':"+"'"+h.getPeople()+"'"+","
//					  +"'place':"+"'"+h.getPlace()+"'"+","
//					  +"'title':"+"'"+h.getTitle()+"'"+","
//					  +"'realpeople':"+"'"+h.getRealPeople()+"'"+","
//					);
//			 sb.append("}]");
//			 sb.append("}"); //json字符串到此完成   
//			 request.setAttribute("huiyidengji"+i, sb.toString());
//			 System.out.println("i="+i+"|"+sb.toString());
//			 i++;
//			
//		}  
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/static/jsp/huiyidengjiList.jsp?Login=Login");
//		dispatcher.forward(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/static/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String deleteFlag = request.getParameter("delete");
		
		if(StringUtil.strIsNotEmpty(deleteFlag)){//删除
			
			HuiYiDJWrite.delete(deleteFlag);
			
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
			return;
		}
		
		String  custno = request.getParameter("updateA");
		String  date = request.getParameter("date");
		String  department = request.getParameter("department");
		String  place = request.getParameter("place");
		String  realPeople = request.getParameter("realPeople");
		String  people = request.getParameter("people");
		String  list = request.getParameter("list");
		String  title = request.getParameter("title");
		String  content = request.getParameter("content");
		String  advice = request.getParameter("advice");
		String  headPeople = request.getParameter("headPeople");
		
		System.out.println(custno+"|"+date+"|"+department+"|"+place+"|"+realPeople+"|"+people+"|"+list+"|"+title+"|"+content
				+"|"+advice+"|"+headPeople);
		
		if (StringUtil.strIsNotEmpty(custno)) {
			
			HuiYi huiYi = new HuiYi();
			huiYi.setCustno(custno);
			if (StringUtil.strIsNotEmpty(date)) {
				huiYi.setDate(date);
			}else
				huiYi.setDate("更新时间错啦！");
			if (StringUtil.strIsNotEmpty(department)) {
				huiYi.setDepartment(department);
			}else
				huiYi.setDepartment("没有填相关部门，好可怜");
			if (StringUtil.strIsNotEmpty(place)) {
				huiYi.setPlace(place);
			}else
				huiYi.setPlace("没有填开会地点，好可怜！");
			if (StringUtil.strIsNotEmpty(realPeople)) {
				huiYi.setRealPeople(realPeople);
			}else
				huiYi.setRealPeople("没有人数");
			if (StringUtil.strIsNotEmpty(people)) {
				huiYi.setPeople(people);
			}else
				huiYi.setPeople("一个人都没有");
			if (StringUtil.strIsNotEmpty(list)) {
				huiYi.setList(list);
			}else
				huiYi.setList("无");
			if (StringUtil.strIsNotEmpty(title)) {
				huiYi.setTitle(title);
			}else
				huiYi.setTitle("无");
			if (StringUtil.strIsNotEmpty(content)) {
				huiYi.setContent(content);
			}else
				huiYi.setContent("无");
			if (StringUtil.strIsNotEmpty(advice)) {
				huiYi.setAdvice(advice);
			}else
				huiYi.setAdvice("无");
			if (StringUtil.strIsNotEmpty(headPeople)) {
				huiYi.setHeadPeople(headPeople);
			}else
				huiYi.setHeadPeople("无");
			
			HuiYiDJWrite.update(huiYi);
			
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
			return;
		}
		
		String startTimes = request.getParameter("startTimes");
		String endTimes = request.getParameter("endTimes");
		
		if(StringUtil.strIsNotEmpty(startTimes) && StringUtil.strIsNotEmpty(endTimes)){
			
			List<HuiYi> huiyiList = HuiYiDJRead.queryTime(startTimes, endTimes);
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
			return;
		}
		
		String search = request.getParameter("search");
		String select = request.getParameter("select");
		
		if(StringUtil.strIsNotEmpty(search) && StringUtil.strIsNotEmpty(select)){
			List<HuiYi> huiyiList = HuiYiDJRead.querySS(search, select);
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
			
		}else {
			List<HuiYi> huiyiList = HuiYiDJRead.querySS("", "");
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
			
		}
		
	}

	
}
