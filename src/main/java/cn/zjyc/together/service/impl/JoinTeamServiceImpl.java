package cn.zjyc.together.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.RequestDAO;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.JoinTeamService;

@Service("joinTeamService")
public class JoinTeamServiceImpl implements JoinTeamService {

	@Resource(name = "requestDAO")
	private RequestDAO dao;


	public void joinTeam(Integer team_id, Integer user_id) {
		if(dao.isApplicant(team_id, user_id)!=null){
			throw new AppException("已经申请过了");
		} else if(dao.isJoinTeam(team_id, user_id)!=null) {
			throw new AppException("已经在队伍中了");
		}
		//成功申请,保存申请记录
		dao.save(team_id, user_id);
	}

}
