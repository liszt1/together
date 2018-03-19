package cn.zjyc.together.service;


/**
 * 
 * @ClassName: AppException
 * @Description:应用异常类
 * @author: while_box
 * @date: 2017年9月19日 上午9:25:01
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public class AppException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 10001L;

	public AppException() {
		
	}
	
	public AppException(String message) {
		super(message);
	}
	
}
