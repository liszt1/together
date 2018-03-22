package cn.zjyc.together.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.UserDAO;
import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userdao;
	
	/**
	 * 注册用户
	 * 
	 * @param user
	 *            注册的用户信息
	 * @return 注册成功后用户信息
	 * @throws AppException
	 *             该账号已经被注册
	 */
		public User UserRegister(User user) {
			if(userdao.findByNumber(user.getNum()) != null){
				//若用户账号已经注册,抛出异常
				throw new AppException("该账号已经被注册");
			}
			//否则,进行注册,并返回注册成功后用户信息
			userdao.save(user);
			return userdao.findByNumber(user.getNum());
		}


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
	public User userCheckLogin(String num, String user_pw) {
		User user = null;
		user = userdao.findByNumber(num);
		if(user == null){
			/*
			 * 帐号不存在,抛出应用异常。
			 * (了解)
			 * 	应用异常指的是因为用户
			 * 不正确的操作引起的异常（比如
			 * 输入了错误的帐号密码）。
			 * 对于应用异常，需要提示用户
			 * 采取正确的操作。
			 */
			throw new AppException("帐号错误");
		}
		if(!user.getUser_pw().equals(user_pw)){
			//密码不正确
			throw new AppException("密码错误");
		}
		//验证通过
		return user;
	}
	
}

