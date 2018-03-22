package cn.zjyc.together.service;

import java.util.Map;

import cn.zjyc.together.entity.Team;

/**
 * 
 * @ClassName: HistoryService
 * @Description:历史记录业务层接口
 * @author: while_box
 * @date: 2017年9月26日 上午9:33:03
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface HistoryService {

	/**
	 * 根据用户id查找用户的点赞情况和历史队伍
	 * @param num 用户id
	 * @return 用户的历史队伍
	 */
	public Map<Team, String> history(Integer user_id);
}