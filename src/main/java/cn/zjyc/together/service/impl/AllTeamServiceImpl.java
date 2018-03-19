package cn.zjyc.together.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.TeamDAO;
import cn.zjyc.together.entity.Team;
import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.AllTeamService;
import cn.zjyc.together.service.AppException;

@Service("allTeamService")
public class AllTeamServiceImpl implements AllTeamService {

	@Resource(name = "teamDAO")
	private TeamDAO dao;

	public List<Team> findAllTeam(User user) {
		List<Team> findAll = dao.findByUserCity(user);
		return findAll;
	}

	public List<Team> findAllTeam(String city) {
		List<Team> findAll = null;
		if (city == null) {
			findAll = dao.findMayJoinTeam();
		} else {
			findAll = dao.findByCity(city);
		}
		return findAll;
	}

	public List<Team> findUserAllTeam(String num) {
		List<Team> userAllTeam = dao.findUserTeam(num);
		if (userAllTeam.size() == 0) {
			throw new AppException("没有队伍状态为可加入或满员的队伍");
		}
		return userAllTeam;
	}

	public List<Team> findMyTeam(Integer user_id) {
		List<Team> myTeam = dao.findMyTeam(user_id);
		
		return myTeam;
	}

}
