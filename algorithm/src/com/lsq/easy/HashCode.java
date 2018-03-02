package com.lsq.easy;

import java.math.BigDecimal;

/** 
* @author  Linshiq: 
* @date 创建时间：2018年1月24日 下午4:35:26 
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
 *         <li>2018年1月24日-下午4:35:26</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class HashCode {

	/*
	 * @param key: A string you should hash
	 * 
	 * @param HASH_SIZE: An integer
	 * 
	 * @return: An integer
	 */
	public static int hashCode(char[] key, int HASH_SIZE) {

		/*
		 * 在数据结构中，哈希函数是用来将一个字符串（或任何其他类型）转化为小于哈希表大小且大于等于零的整数。一个好的哈希函数可以尽可能少地产生冲突。
		 * 一种广泛使用的哈希函数算法是使用数值33，假设任何字符串都是基于33的一个大整数，比如：
		 * 
		 * hashcode("abcd") = (ascii(a) * 33^3 + ascii(b) * 33^2 + ascii(c) *33
		 * + ascii(d)) % HASH_SIZE
		 * 
		 * = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE
		 * 
		 * = 3595978 % HASH_SIZE
		 * 
		 * 其中HASH_SIZE表示哈希表的大小(可以假设一个哈希表就是一个索引0 ~ HASH_SIZE-1的数组)。
		 * 
		 * 给出一个字符串作为key和一个哈希表的大小，返回这个字符串的哈希值。
		 */

		if (key == null || key.length <= 0) {
			return 0;
		}

		int hash = 33;

		BigDecimal sum = BigDecimal.ZERO;
		
		int len = key.length - 1;
		
		for (int i = 0; i < key.length; i++) {

			sum = sum.add(BigDecimal.valueOf((int)key[i]).multiply(getPom(hash, len--)));
		}
		System.out.println(sum);
		return Integer.parseInt(sum.divideAndRemainder(BigDecimal.valueOf(HASH_SIZE))[1].toString());
	}

	private static BigDecimal getPom(int i, int n) {

		if (n == 0) {
			return BigDecimal.ONE;
		}
		
		BigDecimal hashSum = BigDecimal.ONE;
		
		for (int j = 0; j < n; j++) {

			hashSum = hashSum.multiply(BigDecimal.valueOf(i));
		}
		System.out.println(hashSum);
		return hashSum;
	}

	public static void main(String[] args) {

		System.out.println(hashCode("abcdefghijklmnopqrstuvwxyz".toCharArray(), 2607));
	}
}
