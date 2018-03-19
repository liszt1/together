package cn.zjyc.together.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.constant.EnumStateAll;
import cn.zjyc.together.dao.RequestDAO;
import cn.zjyc.together.entity.Request;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.RefusedJoinTeamService;

@Service("refusedJoinTeamService")
public class RefusedJoinTeamServiceImpl implements RefusedJoinTeamService {

	@Resource(name="requestDAO")
	private RequestDAO dao;
	
	public void refusedJoinTeam(Integer team_id, Integer user_id) {
		//根据队伍id和用户id取出唯一对应的申请信息
		Request request = dao.findByTeamAndUser(team_id, user_id);
		if(dao.isApplicant(team_id, user_id)!=null){
			//修改申请信息中的申请状态
			request.setRe_state(EnumStateAll.reject.getName());
			//更新申请信息
			dao.update(request);
		} else {
			throw new AppException("该用户已经不再申请列表中");
		}
	}

}
