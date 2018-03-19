package cn.zjyc.together.service;

import java.util.List;

import cn.zjyc.together.entity.Team;
import cn.zjyc.together.entity.User;

/**
 * 
 * @ClassName: AllTeamService
 * @Description:查询所有队伍信息业务层接口
 * @author: while_box
 * @date: 2017年9月19日 上午9:24:44 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface AllTeamService {
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
