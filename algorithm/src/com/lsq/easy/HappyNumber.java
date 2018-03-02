package com.lsq.easy;

import java.util.ArrayList;
import java.util.List;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月6日 上午11:11:51 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/
/**
 * <p>
 * 文件功能说明： 是否快乐数
 * </p>
 * 
 * @Author linshiqin
 *         <p>
 *         <li>2017年1月6日-上午11:11:51</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class HappyNumber {
	/**
	 * @param n
	 *            an integer
	 * @return true if this is a happy number or false
	 */
	public boolean isHappy(int n) {
		// Write your code here
		boolean flag = false;
		boolean whileFlag = true;

		String numberStr = n + "";

		List<Integer> listInt = new ArrayList<Integer>();
		int one = 1;
		int nInt = 0;
		int lenght = numberStr.length();

		for (int i = 0; i < lenght; i++) {
			nInt = nInt + Integer.parseInt(numberStr.charAt(i) + "") * Integer.parseInt(numberStr.charAt(i) + "");
		}

		while (whileFlag) {
			if (nInt == one) {
				flag = true;
				break;
			} else if (listInt.size() > 0) {
				for (int i : listInt) {
					if (i == nInt) {
						whileFlag = false;
						break;
					}
				}
			}
			listInt.add(nInt);
			numberStr = nInt + "";
			nInt = 0;
			lenght = numberStr.length();
			for (int i = 0; i < lenght; i++) {
				nInt = nInt + Integer.parseInt(numberStr.charAt(i) + "") * Integer.parseInt(numberStr.charAt(i) + "");
			}
		}

		return flag;

	}

	public static void main(String[] args) {
		HappyNumber h = new HappyNumber();
		System.out.println(h.isHappy(19));
	}
}
