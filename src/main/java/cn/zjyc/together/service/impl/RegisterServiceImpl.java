package cn.zjyc.together.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.UserDAO;
import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.RegisterService;

@Service("registerService")
public class RegisterServiceImpl implements RegisterService{

	@Resource(name="userDAO")
	private UserDAO dao;
	
	public User register(User user) {
		if(dao.findByNumber(user.getNum()) != null){
			//若用户账号已经注册,抛出异常
			throw new AppException("该账号已经被注册");
		}
		//否则,进行注册,并返回注册成功后用户信息
		dao.save(user);
		return dao.findByNumber(user.getNum());
	}

}
