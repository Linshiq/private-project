package test;
/** 
* @author  LinShiqin: 
* @date 创建时间：2016年4月28日 上午8:01:03 
* @return  
*/
public class SubStrTest {

	public static void  test() {
		StringBuffer sb = new StringBuffer(); 
		sb.append("{"+"'columnInfo':"+"[{");
		sb.append("'advice':"+"'"+"sssssssss\n                "+"'"+","
				  +"'content':"+"'"+"content"+"'"+","
				  +"'custno':"+"'"+"111111111"+"'"+","
				  +"'date':"+"'"+"ssssssssss"+"'"+","
				  +"'department':"+"'"+"ssssssss"+"'"+","
				  +"'headpeople':"+"'"+"22222222222"+"'"+","
				  +"'list':"+"'"+"list"+"'"+","
				  +"'people':"+"'"+"sssssssssss"+"'"+","
				  +"'place':"+"'"+"ssssssssss"+"'"+","
				  +"'title':"+"'"+"ssssssssss"+"'"+","
				  +"'realpeople':"+"'"+"sssssssssss"+"'"+","
				);
		 sb.append("}]");
		 sb.append("}"); //json字符串到此完成  
		 
		 String s = sb.toString();
		 
		 System.out.println(s.substring(s.indexOf("'content'")+11,s.indexOf("'custno'")-2));
		 
	}
	
	public static void main(String[] args) {
		SubStrTest.test();
	}
}
