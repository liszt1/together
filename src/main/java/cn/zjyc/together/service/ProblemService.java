package cn.zjyc.together.service;

public interface ProblemService {

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
