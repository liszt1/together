package cn.zjyc.together.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zjyc.together.entity.Request;
import cn.zjyc.together.entity.User;

/**
 * 
 * @ClassName: RequestDAO
 * @Description: 申请状态数据访问层接口
 * @author: while_box
 * @date: 2017年9月19日 下午3:31:09 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface RequestDAO {

	/**
	 * 增加申请状态信息 id自动递增,team_id为team_id,user_id为user_id re_state为申请中,position为队员
	 * 
	 * @param team_id
	 *            队伍id
	 * @param user_id
	 *            用户id
	 */
	public void save(@Param("team_id")Integer team_id,@Param("user_id")Integer user_id);

	/**
	 * 更新申请状态
	 * 
	 * @param request
	 *            要更新的申请状态
	 */
	public void update(@Param("Request")Request request);

	/**
	 * 根据队伍id查找申请加入人员用户信息列表
	 * 
	 * @param team_id
	 *            队伍id
	 * @return 申请加入人员用户信息列表
	 */
	public List<User> findProposer(Integer team_id);

	/**
	 * 根据队伍id和用户id查询用户是否已经申请 查到返回 true ,否则返回false
	 * 
	 * @param team_id
	 *            队伍id
	 * @param user_id
	 *            用户id
	 * @return 用户信息
	 */
	public Boolean isApplicant(@Param("team_id")Integer team_id,@Param("user_id")Integer user_id);

	/**
	 * 根据队伍id和用户id查询用户是否已经在队伍中 查到返回 true ,否则返回false
	 * 
	 * @param team_id
	 *            队伍id
	 * @param user_id
	 *            用户id
	 * @return 用户信息
	 */
	public Boolean isJoinTeam(@Param("team_id")Integer team_id,@Param("user_id")Integer user_id);

	/**
	 * 根据队伍id和用户id查询申请信息
	 * 
	 * @param team_id
	 *            队伍id
	 * @param user_id
	 *            用户id
	 * @return 申请信息
	 */
	public Request findByTeamAndUser(@Param("team_id")Integer team_id,@Param("user_id")Integer user_id);
}
