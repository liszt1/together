package cn.zjyc.together.service;

/**
 * 
 * @ClassName: JoinTeamService
 * @Description:加入队伍业务层接口
 * @author: while_box
 * @date: 2017年9月20日 下午1:55:26 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface JoinTeamService {

	/**
	 * 将用户id为user_id的用户,添加到队伍team_id中
	 * 
	 * @param team_id
	 *            队伍id
	 * @param user_id
	 *            用户id
	 */
	public void joinTeam(Integer team_id, Integer user_id);
}
