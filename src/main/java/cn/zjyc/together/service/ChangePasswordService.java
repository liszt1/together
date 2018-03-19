package cn.zjyc.together.service;

/**
 * 
 * @ClassName: ChangePasswordService
 * @Description:修改与重置密码业务层接口
 * @author: while_box
 * @date: 2017年9月19日 上午9:25:15 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface ChangePasswordService {

	/**
	 * 根据用户账号和新密码,进行修改密码操作,若password为null,则设置为默认密码123
	 * 
	 * @param num
	 *            用户账号
	 * @param user_pw
	 *            用户密码
	 * @param newuser_pw
	 *            新用户密码
	 */
	public void changepassword(String num, String user_pw, String newuser_pw);
}
