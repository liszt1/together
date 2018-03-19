package cn.zjyc.together.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import cn.zjyc.together.entity.Team;
import cn.zjyc.together.entity.User;

/**
 * 
 * @ClassName: TeamDAO
 * @Description:队伍数据访问层接口
 * @author: while_box
 * @date: 2017年9月19日 上午9:23:21 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface TeamDAO {

	/**
	 * 增加队伍信息,并绑定队长账号在申请表 初始队伍状态为可加入,初始队伍人数为1 创建时间为数据库时间,
	 * 
	 * @param team
	 *            要增加的队伍信息
	 * @return 保存队伍的队伍id
	 * @throws Exception
	 */
	public Integer save(@Param("Team")Team team);

	/**
	 * 查询状态为"可加入"的队伍列表
	 * 
	 * @param user_id
	 *            需要绑定的队长id
	 * @param nteger Team_id
	 * 			    需要绑定的队伍id
	 * 绑定save方法
	 * @throws Exception
	 */
	public void saveRequest(@Param("team_id")Integer Team_id,@Param("user_id")Integer user_id);
	/**
	 * 查询状态为"可加入"的队伍列表
	 * 
	 * @return 状态为正在进行中的队伍列表
	 * 
	 * @throws Exception
	 */
	public List<Team> findMayJoinTeam();

	/**
	 * 更新队伍信息
	 * 
	 * @param team
	 *            要更新的队伍
	 * @throws Exception
	 */
	public void update(@Param("Team")Team team);

	/**
	 * 根据用户账号查找用户所在队伍状态为"正在进行中"的队伍列表
	 * 
	 * @param num
	 *            用户账号
	 * @return 状态为"正在进行中"的队伍列表
	 */
	public List<Team> findByUserNum(String num);

	/**
	 * 根据用户账号查找用户所在队伍状态为"可加入"或"满员"的队伍列表,
	 * 
	 * 即用户当前加入的状态不为"正在进行中"和状态不为"以结束"的队伍.
	 * 
	 * @return 用户当前加入的状态不为"正在进行中"和状态不为"以结束"的队伍
	 */
	public List<Team> findUserTeam(String num);

	/**
	 * 根据用户账号查找用户所在队伍状态为"已结束"的队伍列表
	 * 
	 * @param num
	 *            用户账号
	 * @return 状态为"已结束"的队伍列表
	 */
	public List<Team> findByUserNumEnd(String num);

	/**
	 * 根据队伍id查找队伍信息
	 * 
	 * @param id
	 *            队伍id
	 * @return 队伍信息
	 */
	public Team findById(Integer id);

	/**
	 * 根据用户信息中的城市查找用户所在城市的所有状态为"可加入"的队伍信息列表
	 * 
	 * @param user
	 *            用户信息
	 * @return 用户所在城市的所有状态为可加入的队伍信息列表
	 */
	public List<Team> findByUserCity(@Param("User")User user);

	/**
	 * 根据城市查找所有状态为"可加入"的队伍信息列表
	 * 
	 * @param city
	 *            城市
	 * @return 状态为"可加入"的队伍信息列表
	 */
	public List<Team> findByCity(String city);

	/**
	 * 根据用户id查找用户作为队长的队伍信息列表
	 * 
	 * @param user_id
	 *            用户id
	 * @return 用户作为队长的队伍信息列表
	 */
	public List<Team> findMyTeam(Integer user_id);

	/**
	 * 根据用户id查找用户申请的状态和队伍信息
	 * 
	 * @param user_id
	 *            用户id
	 * @return 键为Team,值为申请状态(re_state)
	 */
	public Map<String, Object> findRequestByUserId(Integer user_id);

	/**
	 * 根据用户id查找用户点赞的状态和队伍信息
	 * 
	 * @param user_id
	 *            用户id
	 * @return 键为Team,值为点赞状态(th_state)
	 */
	@MapKey("th_state")
	public Map<String, Object> findThumbByUserId(Integer user_id);

	/**
	 * 查询所有队伍
	 * @return 所有队伍列表
	 */
	public List<Team> findAllTeam();
}
