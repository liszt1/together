package cn.zjyc.together.service;


import cn.zjyc.together.entity.User;

public interface UserService {

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
	public User userCheckLogin(String num, String user_pw);
	
	/**
	 * 注册用户
	 * 
	 * @param user
	 *            注册的用户信息
	 * @return 注册成功后用户信息
	 * @throws AppException
	 *             该账号已经被注册
	 */
	public User UserRegister(User user);
	
	
}

