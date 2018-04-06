package cn.zjyc.together.service;

import java.util.List;
import java.util.Map;

import cn.zjyc.together.entity.Team;
import cn.zjyc.together.entity.User;

public interface RequestService {

	/**
	 * 同意用户加入队伍
	 * 
	 * @param user_id
	 *            用户id
	 * @param team_id
	 *            队伍id
	 */
	public void allowJoinTeam(Integer team_id, Integer user_id);
	/**
	 * 拒绝用户加入队伍
	 * 
	 * @param user_id
	 *            用户id
	 * @param team_id
	 *            队伍id
	 */
	public void refusedJoinTeam(Integer team_id, Integer user_id);

	/**
	 * 根据用户id查找用户申请的状态和队伍信息
	 * @param user_id 用户id
	 * @return 用户申请的状态和队伍信息
	 */
	public Map<Team, String> requestFeedback(Integer user_id);
	/**
	 * 将用户id为user_id的用户,添加到队伍team_id中
	 * 
	 * @param team_id
	 *            队伍id
	 * @param user_id
	 *            用户id
	 */
	public void joinTeam(Integer team_id, Integer user_id);
	/**
	 * 根据队伍id查看申请该队伍的用户信息列表
	 * 
	 * @param team_id
	 *            队伍id
	 * @return 用户信息列表
	 */
	public List<User> viewApplicant(Integer team_id);
}
