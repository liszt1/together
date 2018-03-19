package cn.zjyc.together.service;

import java.util.List;

import cn.zjyc.together.entity.User;

/**
 * 
 * @ClassName: ViewApplicantService
 * @Description:查看申请信息列表业务层接口
 * @author: while_box
 * @date: 2017年9月21日 下午1:50:37 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface ViewApplicantService {

	/**
	 * 根据队伍id查看申请该队伍的用户信息列表
	 * 
	 * @param team_id
	 *            队伍id
	 * @return 用户信息列表
	 */
	public List<User> viewApplicant(Integer team_id);
}
