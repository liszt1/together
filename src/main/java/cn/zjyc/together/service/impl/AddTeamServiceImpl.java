package cn.zjyc.together.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.TeamDAO;
import cn.zjyc.together.dao.ThumbDAO;
import cn.zjyc.together.entity.Team;
import cn.zjyc.together.entity.Thumb;
import cn.zjyc.together.service.AddTeamService;


@Service("addTeamService")
public class AddTeamServiceImpl implements AddTeamService{

	@Resource(name="teamDAO")
	private TeamDAO dao;
	
	@Resource(name="thumbDAO")
	private ThumbDAO thumbDAO;
	
	public Team addTeam(Team team, Integer user_id) {
		Integer team_id = dao.save(team);
		dao.saveRequest(team_id, user_id);
		Thumb thumb = new Thumb();
		thumb.setTeam_id(team_id);
		thumb.setUser_id(user_id);
		thumbDAO.save(thumb);
		return dao.findById(team_id);
		
	}

}
