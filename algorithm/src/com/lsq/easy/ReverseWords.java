package com.lsq.easy;

/** 
* @author  Linshiq: 
* @date 创建时间：2018年1月24日 下午4:07:36 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明：
 * 
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2018年1月24日-下午4:07:36</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class ReverseWords {

	/**
	 * @Author linshiqin
	 *         <p>
	 *         <li>2018年1月24日-下午4:07:40</li>
	 *         <li>功能说明：使用list的循环</li>
	 *         </p>
	 */
	public static String reverseWords(String s) {
		// TODO Auto-generated method stub

		if (s == null || s.length() <= 0) {

			return s;
		}

		String[] strArr = s.split(" ");

		StringBuffer sb = new StringBuffer();

		for (int i = strArr.length - 1; i >= 0; i--) {

			String m = strArr[i];

			if (!m.equals(" ")) {
				sb.append(m.trim()).append(" ");
			}

		}

		return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";

	}

	public static void main(String[] args) {

		System.out.println(reverseWords(" "));
	}
}
