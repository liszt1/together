package cn.zjyc.together.service;


import cn.zjyc.together.entity.Team;

/**
 * 
 * @ClassName: AddTeamService
 * @Description:TODO 创建队伍业务层接口
 * @author: while_box
 * @date: 2017年9月20日 下午1:57:07 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface AddTeamService {
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
}
