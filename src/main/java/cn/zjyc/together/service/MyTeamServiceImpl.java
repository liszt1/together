package cn.zjyc.together.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.TeamDAO;
import cn.zjyc.together.entity.Team;


@Service("myTeamService")
public class MyTeamServiceImpl implements MyTeamService {

	@Resource(name="teamDAO")
	private TeamDAO dao;
	
	public List<Team> findMyTeam(Integer user_id) {
		List<Team> myTeam = dao.findMyTeam(user_id);
		return myTeam;
	}

}
