package cn.zjyc.together.service;

import java.util.Map;

import cn.zjyc.together.entity.Team;

/**
 * 
 * @ClassName: RequestFeedbackService
 * @Description:队伍动态业务层接口
 * @author: while_box
 * @date: 2017年9月25日 下午4:31:34
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface RequestFeedbackService {


	/**
	 * 根据用户id查找用户申请的状态和队伍信息
	 * @param user_id 用户id
	 * @return 用户申请的状态和队伍信息
	 */
	public Map<Team, String> requestFeedback(Integer user_id);
}
