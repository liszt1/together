package cn.zjyc.together.service;

import cn.zjyc.together.entity.User;

/**
 * 
 * @ClassName: LoginService
 * @Description:登陆业务层接口
 * @author: while_box
 * @date: 2017年9月19日 上午9:25:49
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface LoginService {
	/**
	 * 用户登录验证,根据用户账号以及密码验证是否成功登陆
	 * 
	 * @param num
	 *            用户账号
	 * @param user_pw
	 *            用户密码
	 * @return 成功返回用户信息,失败抛出异常
	 * @throws APPException
	 *             用户登录验证失败
	 */
	public User checkLogin(String num, String user_pw);
}
