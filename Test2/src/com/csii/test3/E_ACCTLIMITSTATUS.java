package com.csii.test3;
/** 
* @author  Linshiq: 
* @date 创建时间：2017年1月13日 下午2:26:08 
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
 *         <li>2017年1月13日-下午2:26:08</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public enum E_ACCTLIMITSTATUS {
	 /**
	  * 0 - 未限制
	  *
	  */
	NONE("NONE","0","未限制"),
	 /**
	  * 1 - 不进不出
	  *
	  */
	SEAL("SEAL","1","不进不出"),
	 /**
	  * 2 - 只进不出
	  *
	  */
	IN("IN","2","只进不出"),
	 /**
	  * 3 - 只出不进
	  *
	  */
	OUT("OUT","3","只出不进"),
	 /**
	  * 4 - 部分冻结
	  *
	  */
	PART("PART","4","部分冻结");
	private E_ACCTLIMITSTATUS(String __id__ ,String __value__,String __longName__){
		this.__id__ = __id__;
		this.__value__ = __value__;
		this.__longName__ = __longName__;
	}
	
	private String __id__;
	
	private String __value__;
	
	private String __longName__;
	
	public String getId(){
		return this.__id__;
	}
	
	public String getValue(){
		return this.__value__;
	}
	
	public String getLongName(){
		return this.__longName__;
	}
	
	public String toString(){
		return String.valueOf(this.__value__);
	} 
	
}
