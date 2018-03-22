package cn.zjyc.together.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.zjyc.together.dao.UserDAO;
import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.ProblemService;
@Service("problemService")
public class ProblemServiceImpl implements ProblemService{

	@Autowired
	private UserDAO userdao;

	@Override
	public void changepassword(String num, String user_pw, String newuser_pw) {
	
			if (newuser_pw == null) {
				newuser_pw = "123";
			}
			// 调用dao的findByNumber方法,取得需要修改密码的user的密码,修改user
			User user = userdao.findByNumber(num);
			if (user_pw.equals(user.getUser_pw())) {
				// 若用户密码正确,则修改用户密码为新用户密码
				user.setUser_pw(newuser_pw);
				userdao.update(user);
			} else {
				throw new AppException("输入密码不正确");
			}

		}

	@Override
	public String retrievePassword(String user_id, String answer) {
		// TODO Auto-generated method stub
		return null;
	}


}
