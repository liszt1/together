package cn.zjyc.together.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.UserDAO;
import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.AllTeamMemberService;
import cn.zjyc.together.service.AppException;

@Service("allTeamMemberService")
public class AllTeamMemberServiceImpl implements AllTeamMemberService {

	@Resource(name="userDAO")
	private UserDAO dao;
	
	
	public List<User> allTeamMember(Integer team_id) {
		if(team_id == null){
			throw new AppException("请输入队伍id");
		}
		return dao.findAllByTeamId(team_id);
	}

}
