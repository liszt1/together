package cn.zjyc.together.service;

/**
 * 
 * @ClassName: RetrievePasswordService
 * @Description:找回密码业务层接口
 * @author: while_box
 * @date: 2017年9月22日 下午2:38:54 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface RetrievePasswordService {

	/**
	 * 根据用户id和密保问题找回密码
	 * 
	 * @param user_id
	 *            用户id
	 * @param answer
	 *            密保问题答案
	 * @return 用户密码
	 */
	public String retrievePassword(String user_id, String answer);
}
