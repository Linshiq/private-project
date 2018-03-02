package menu_center.xiaoli;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import menu_center.xiaoli.base.Xiaoli;

public class NJFUSchoolCalendarData {

	public static String getSchoolCalendaData_Xls(String classNumber, HttpServletRequest request) {
		String fileName = "/15-16-2教学进程.xls";
		List<ArrayList<String>> alldata = new ArrayList<ArrayList<String>>();
		ArrayList<String> data = null;
		List<String> listStr = new ArrayList<String>();
		Map<String, List<Xiaoli>> mapXiaoli = new HashMap<String, List<Xiaoli>>();
		try {

			URL url = new URL("http://" + request.getServerName() + request.getContextPath() + fileName);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			
			InputStream in = request.getServletContext().getResourceAsStream("/15-16-2教学进程.xls");
			
			httpUrlConn.setDoOutput(false);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);

			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.connect();

			WorkbookSettings workbookSettings = new WorkbookSettings();
			workbookSettings.setEncoding("ISO-8859-1");
			Workbook book = Workbook.getWorkbook(in, workbookSettings);
			

			Sheet st = book.getSheet(0);
			System.out.println(st.getColumns());
			Cell c1 = st.getCell(2, 12);
			String name = c1.getContents().replaceAll(" ", "");

			int cols = st.getColumns(); // 列
			// 读取每一行对应的列数目
			// 循环读取每一行的全部列数目的内容
			int rows = st.getRows(); // 行
			String str="";
			for (int r = 0; r < rows; r++) {
				data = new ArrayList<String>();

				// 行循环,Excel的行列是从（0，0）开始
				for (int c = 0; c < cols; c++) {
					Cell excelRows = st.getCell(c, r);
					String strRow = excelRows.getContents().replaceAll(" ", "");
					str = str + strRow+",";
				}
				listStr.add(str);
				str="";
			}

		} catch (Exception e) {
		}

		for(String s:listStr){
			System.out.println(s);
		}
		for (int i = 3; i < (listStr.size() - 3); i++) {
			List<Xiaoli> xiaolis = new ArrayList<Xiaoli>();
			String[] strArr = listStr.get(i).split(",");
			for (int j = 1; j < strArr.length; j++) {
				Xiaoli xiaoli = new Xiaoli(strArr[0], j + "", strArr[j]);
				xiaolis.add(xiaoli);
			}
			mapXiaoli.put(strArr[0], xiaolis);
		}
		for (String s :listStr) {
			System.out.println(" "+s);
		}
		if(mapXiaoli.get(classNumber) == null)
			return "查询不到任何数据";
		StringBuffer sb_ = new StringBuffer();
		for (Xiaoli x : mapXiaoli.get(classNumber)) {
			if (!x.getCourse_().equals(""))
				sb_.append(x.getWeek_() + "周 : " + x.getCourse_() + "\n");
		}
		System.out.println("sb_="+sb_);
		return sb_.toString();
	}

	/**
	 * 班级信息.csv
	 */
	public static String getSchoolCalendaData(String classNumber, HttpServletRequest request) {

		String fileName = "/2015-2016-1xiaoli.csv";

		List<String> listStr = new ArrayList<String>();
		/*
		 * String path =
		 * NJFUSchoolCalendarData.class.getClassLoader().getResource(
		 * "../../2015-2016-1xiaoli.csv").getPath(); System.out.println(path);
		 */
		Map<String, List<Xiaoli>> mapXiaoli = new HashMap<String, List<Xiaoli>>();
		// File file = new File(path);
		
		
		BufferedReader bufferedReader = null;
		try {
			URL url = new URL("http://" + request.getServerName() + request.getContextPath() + fileName);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			
			httpUrlConn.setDoOutput(false);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);

			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.connect();

			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader isr = new InputStreamReader(inputStream, "gbk");
			// InputStreamReader isr = new InputStreamReader(new
			// FileInputStream(file),"gbk");
			bufferedReader = new BufferedReader(isr);
			String tempStr = "";
			// int weeken = 1;
			// int tmp = 1;
			while ((tempStr = bufferedReader.readLine()) != null) {
				listStr.add(tempStr);
				// tmp++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(listStr.isEmpty())
			return "查询不到任何数据";
		// System.out.println(listStr.get(43));
		for (int i = 3; i < (listStr.size() - 3); i++) {
			List<Xiaoli> xiaolis = new ArrayList<Xiaoli>();
			String[] strArr = listStr.get(i).split(",");
			for (int j = 1; j < strArr.length; j++) {
				Xiaoli xiaoli = new Xiaoli(strArr[0], j + "", strArr[j]);
				xiaolis.add(xiaoli);
			}
			mapXiaoli.put(strArr[0], xiaolis);
		}
		if(mapXiaoli.get(classNumber) == null)
			return "查询不到任何数据";
		StringBuffer sb_ = new StringBuffer();
		for (Xiaoli x : mapXiaoli.get(classNumber)) {
			if (!x.getCourse_().equals(""))
				sb_.append(x.getWeek_() + "周 : " + x.getCourse_() + "\n");
		}
		return new String(sb_);
		// //"E:"+File.separator+"2015-2016-1校历.csv"
		// File file = new File(PropertiesUtils.getCvsFilePath());
		// BufferedReader bufferedReader = null;
		// StringBuffer sbStr = new StringBuffer();
		// sbStr.append("1");
		// try {
		// InputStreamReader isr = new InputStreamReader(new
		// FileInputStream(file),"gbk");
		// bufferedReader = new BufferedReader(isr);
		// String tempStr = "";
		// int weeken = 1;
		// while((tempStr = bufferedReader.readLine()) != null){
		// if(tempStr.startsWith(classNumber)){
		// StringBuffer sb = new StringBuffer(tempStr);
		// sb.delete(0, classNumber.length());
		// for(int i=0;i<sb.length();i++){
		// if (sb.charAt(i) == ',') {
		// if(sb.charAt(i+1) == ','){
		// weeken++;
		// continue;
		// }else{
		// sbStr.append(weeken+"周"+sb.charAt(i+1));
		// weeken++;
		// }
		// }
		// }
		// //strData = new String(sbStr);
		// break;
		// }
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return new String(sbStr);ge
	}

	// public static String httpRequest(String requestUrl) {
	// StringBuffer buffer = new StringBuffer();
	// try {
	//
	//
	//
	// }catch(Exception e){
	//
	// }
	// return buffer.toString();
	// }
}
