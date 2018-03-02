package com.csii.test3;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月22日 下午5:29:05 
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
 *         <li>2017年1月22日-下午5:29:05</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class DaJiang {

	public static void dajiang() {

		Random random = new Random();

		List<String> list = new ArrayList<>();

		for (int i = 0; i < 1000000; i++) {

			list.add("" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10));
		}

		int conut = 0;
		int result = 0;

		for (int i = 0; i < list.size(); i++) {

			for (int j = i + 1; j < list.size(); j++) {

				if (list.get(i).equals(list.get(j))) {
					conut++;
					list.remove(j);
				}
			}

			if (result < conut) {

				result = conut;
				System.out.println(" 出现最多的码:" + list.get(i) + " relust:" + result);
				conut = 0;
			}
		}
	}

	public static void main(String[] args) {

		int[] u = new int[]{1,2,3,4,5,7};
		
		u = Arrays.copyOf(u, 3);
		
		for (int i = 0; i < u.length; i++) {
			System.out.println(u[i]);
		}

	}
}
