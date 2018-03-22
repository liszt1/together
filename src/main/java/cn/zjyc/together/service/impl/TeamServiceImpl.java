package cn.zjyc.together.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.TeamDAO;
import cn.zjyc.together.dao.ThumbDAO;
import cn.zjyc.together.dao.UserDAO;
import cn.zjyc.together.entity.Team;
import cn.zjyc.together.entity.Thumb;
import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.TeamService;

@Service("teamService")
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	private TeamDAO teamDAO;
	@Autowired
	private ThumbDAO thumbDAO;
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public Team addTeam(Team team, Integer user_id) {
		
		Integer team_id = teamDAO.save(team);
		teamDAO.saveRequest(team_id, user_id);
		Thumb thumb = new Thumb();
		thumb.setTeam_id(team_id);
		thumb.setUser_id(user_id);
		thumbDAO.save(thumb);
		return teamDAO.findById(team_id);
		
	}

	@Override
	public List<User> allTeamMember(Integer team_id) {
		if(team_id == null){
			throw new AppException("请输入队伍id");
		}
		return userDAO.findAllByTeamId(team_id);
	}

	@Override
	public List<Team> findAllTeam(User user) {
		List<Team> findAll = teamDAO.findByUserCity(user);
		return findAll;
	}

	@Override
	public List<Team> findAllTeam(String city) {
		List<Team> findAll = null;
		if (city == null) {
			findAll = teamDAO.findMayJoinTeam();
		} else {
			findAll = teamDAO.findByCity(city);
		}
		return findAll;
	}

	@Override
	public List<Team> findUserAllTeam(String num) {
		List<Team> userAllTeam = teamDAO.findUserTeam(num);
		if (userAllTeam.size() == 0) {
			throw new AppException("没有队伍状态为可加入或满员的队伍");
		}
		return userAllTeam;
	}

	@Override
	public List<Team> findMyTeam(Integer user_id) {
		List<Team> myTeam = teamDAO.findMyTeam(user_id);
		
		return myTeam;
	}
		
}
