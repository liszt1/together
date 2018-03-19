package cn.zjyc.together.service;

import java.util.List;

import cn.zjyc.together.entity.User;

/**
 * 
 * @ClassName: AllTeamMemberService
 * @Description:队伍的所有成员
 * @author: while_box
 * @date: 2017年9月23日 下午6:42:10
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface AllTeamMemberService {

	/**
	 * 根据队伍id查询队伍中所有成员(状态为'已加入'的成员)信息列表
	 * @param team_id 队伍id
	 * @return 队伍中所有成员(状态为'已加入'的成员)信息列表
	 */
	public List<User> allTeamMember(Integer team_id); 
}
