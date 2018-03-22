package cn.zjyc.together.service;

import java.util.List;

import cn.zjyc.together.entity.Team;
import cn.zjyc.together.entity.User;

public interface TeamService {
	/**
	 * 增加队伍信息,并绑定用户账号上
	 * 
	 * @param team
	 *            队伍信息
	 * @param id
	 *            用户账号
	 * @return 保存的队伍信息
	 * @throws Exception
	 */
	public Team addTeam(Team team, Integer id);
	
	/**
	 * 根据队伍id查询队伍中所有成员(状态为'已加入'的成员)信息列表
	 * @param team_id 队伍id
	 * @return 队伍中所有成员(状态为'已加入'的成员)信息列表
	 */
	public List<User> allTeamMember(Integer team_id); 
	
	/**
	 * 根据用户信息中的城市查找用户所在城市的所有状态为"可加入"的队伍信息列表
	 * 
	 * @return 状态为可加入的队伍的信息列表
	 * @throws Exception
	 */
	public List<Team> findAllTeam(User user);

	/**
	 * 根据城市查找所有状态为"可加入"的队伍信息列表
	 */
	public List<Team> findAllTeam(String city);

	/**
	 * 根据用户账号查找用户所在队伍状态为"可加入"或"满员"的队伍列表
	 * 
	 * @param num
	 *            用户账号
	 * @return 用户所在队伍状态为"可加入"或"满员"的队伍列表
	 */
	public List<Team> findUserAllTeam(String num);

	/**
	 * 根据用户id查找用户作为队长的队伍信息列表
	 * 
	 * @param user_id
	 *            用户id
	 * @return 用户作为队长的队伍信息列表
	 */
	public List<Team> findMyTeam(Integer user_id);
	
}
