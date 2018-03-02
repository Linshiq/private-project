package com.lsq.medium;

/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月16日 下午3:55:04 
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
 *         <li>2017年1月16日-下午3:55:04</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class dsa {

	public int sdsa(int[] numbers, int target) {

		int sum = 0;

		int sub = 0;

		if (numbers.length < 3)
			return sum;

		int maxDifference = Math.abs(target - numbers[0]);
		int minDifference = Math.abs(target - numbers[1]);
		int intDifference = Math.abs(target - numbers[2]);

		int[] indexArr = new int[] { maxDifference, minDifference, intDifference };

		if (intDifference > maxDifference) {

			if (minDifference > intDifference) {

				sub = intDifference;
				intDifference = minDifference;
				minDifference = sub;

				sub = maxDifference;
				maxDifference = intDifference;
				intDifference = sub;

				indexArr[0] = 2;
				indexArr[1] = 1;
				indexArr[2] = 0;
			} else {

				sub = maxDifference;
				maxDifference = intDifference;
				intDifference = sub;

				indexArr[0] = 0;
				indexArr[1] = 2;
				indexArr[2] = 1;
			}

		} else if (minDifference > maxDifference) {

			sub = intDifference;
			intDifference = minDifference;
			minDifference = sub;

			sub = maxDifference;
			maxDifference = intDifference;
			intDifference = sub;

			indexArr[0] = 2;
			indexArr[1] = 1;
			indexArr[2] = 0;
		}

		for (int i = 3; i < numbers.length; i++) {

			sub = Math.abs(target - numbers[i]);

			if (sub > maxDifference) {

				continue;
			} else {

				if (sub < minDifference || sub == minDifference) {

					maxDifference = intDifference;
					intDifference = minDifference;
					minDifference = sub;

					indexArr[2] = indexArr[1];
					indexArr[1] = indexArr[0];
					indexArr[0] = i;

				} else if (sub < intDifference || sub == intDifference) {

					maxDifference = intDifference;
					intDifference = sub;

					indexArr[2] = indexArr[1];
					indexArr[1] = i;

				} else if (sub < maxDifference) {

					maxDifference = sub;

					indexArr[2] = i;
				}
			}
		}

		sum = numbers[indexArr[0]] + numbers[indexArr[1]] + numbers[indexArr[2]];

		return sum;
	}
}
