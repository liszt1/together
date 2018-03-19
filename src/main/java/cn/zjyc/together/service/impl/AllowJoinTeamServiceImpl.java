package cn.zjyc.together.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.constant.EnumStateAll;
import cn.zjyc.together.dao.RequestDAO;
import cn.zjyc.together.dao.TeamDAO;
import cn.zjyc.together.dao.ThumbDAO;
import cn.zjyc.together.entity.Request;
import cn.zjyc.together.entity.Team;
import cn.zjyc.together.entity.Thumb;
import cn.zjyc.together.service.AllowJoinTeamService;
import cn.zjyc.together.service.AppException;

@Service("allowJoinTeamService")
public class AllowJoinTeamServiceImpl implements AllowJoinTeamService {

	@Resource(name = "requestDAO")
	private RequestDAO dao;

	@Resource(name = "thumbDAO")
	private ThumbDAO thumbDAO;

	@Resource(name = "teamDAO")
	private TeamDAO teamDAO;

	public void allowJoinTeam(Integer team_id, Integer user_id) {
		// 根据队伍id和用户id取出唯一对应的申请信息
		Request request = dao.findByTeamAndUser(team_id, user_id);

		Thumb thumb = new Thumb();
		thumb.setTeam_id(team_id);
		thumb.setUser_id(user_id);

		Boolean a = false;
		// 改变申请信息中的申请状态(re_state)为已加入
		if(dao.isJoinTeam(team_id, user_id)!=null)
		{
			a = dao.isJoinTeam(team_id, user_id);
		}else
			a = false;
				
		if (!a) {
			
			//增加队伍人数
			Team team = teamDAO.findById(team_id);
			team.setCurrent_num(team.getCurrent_num()+1);
			teamDAO.update(team);
			
			// 新增点赞信息
			thumbDAO.save(thumb);

			// 修改申请信息中的申请状态
			request.setRe_state(EnumStateAll.add.getName());
			// 更新申请信息
			dao.update(request);
		} else {
			throw new AppException("该用户已经不在申请列表中了");
		}
	}

}
