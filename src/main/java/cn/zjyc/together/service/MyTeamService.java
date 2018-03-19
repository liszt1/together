package cn.zjyc.together.service;

import java.util.List;

import cn.zjyc.together.entity.Team;

/**
 * 
 * @ClassName: MyTeamService
 * @Description:我的队伍业务层接口
 * @author: while_box
 * @date: 2017年9月25日 上午11:21:01
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface MyTeamService {


	/**
	 * 根据用户id查找用户作为队长的队伍信息列表
	 * 
	 * @param user_id
	 *            用户id
	 * @return 用户作为队长的队伍信息列表
	 */
	public List<Team> findMyTeam(Integer user_id);
}
