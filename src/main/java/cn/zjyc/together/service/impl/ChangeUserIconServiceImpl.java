package cn.zjyc.together.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.UserDAO;
import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.ChangeUserIconService;

@Service("changeUserIconService")
public class ChangeUserIconServiceImpl implements ChangeUserIconService {

	@Resource(name = "userDAO")
	private UserDAO dao;

	public void changeUserIcon(Integer user_id, String icon) {
		User user = dao.findById(user_id);
		user.setIcon(icon);
		dao.update(user);
	}

}
