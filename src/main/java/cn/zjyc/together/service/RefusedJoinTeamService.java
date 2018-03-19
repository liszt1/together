package cn.zjyc.together.service;


/**
 * 
 * @ClassName: RefusedJoinTeamService
 * @Description:拒绝加入队伍业务层接口
 * @author: while_box
 * @date: 2017年9月22日 上午9:46:46
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface RefusedJoinTeamService {

	/**
	 * 拒绝用户加入队伍
	 * 
	 * @param user_id
	 *            用户id
	 * @param team_id
	 *            队伍id
	 */
	public void refusedJoinTeam(Integer team_id, Integer user_id);
}
