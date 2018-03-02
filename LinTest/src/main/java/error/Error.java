package error;

/** 
* @author  Linshiq: 
* @date 创建时间：2016年10月17日 下午6:54:19 
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
 *         <li>2016年10月17日-下午6:54:19</li>
 *         <li>修改记录</li>
 *         <li>-----------------------------------------------------------</li>
 *         <li>标记：修订内容</li>
 *         <li>linshiqin：创建注释模板</li>
 *         <li>-----------------------------------------------------------</li>
 *         </p>
 */
public class Error extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Error() {

		super();

	}

	public Error(String msg) {

		super(msg);

	}

	public Error(String msg, Throwable cause) {

		super(msg, cause);

	}

	public Error(Throwable cause) {

		super(cause);

	}
}
