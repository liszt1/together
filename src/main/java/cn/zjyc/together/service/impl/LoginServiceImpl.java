package cn.zjyc.together.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.UserDAO;
import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.LoginService;

/**
 * 业务层实现
 * @author BOOKS
 *
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Resource(name="userDAO")
	private UserDAO dao;
	
	public User checkLogin(String num, String user_pw) {
		User user = null;
		user = dao.findByNumber(num);
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
