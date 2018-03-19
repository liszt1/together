package cn.zjyc.together.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.UserDAO;
import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.ChangePasswordService;

@Service("changePasswordService")
public class ChangePasswordServiceImpl implements ChangePasswordService {

	@Resource(name = "userDAO")
	private UserDAO dao;

	public void changepassword(String num, String user_pw, String newuser_pw) {
		if (newuser_pw == null) {
			newuser_pw = "123";
		}
		// 调用dao的findByNumber方法,取得需要修改密码的user的密码,修改user
		User user = dao.findByNumber(num);
		if (user_pw.equals(user.getUser_pw())) {
			// 若用户密码正确,则修改用户密码为新用户密码
			user.setUser_pw(newuser_pw);
			dao.update(user);
		} else {
			throw new AppException("输入密码不正确");
		}

	}

}
