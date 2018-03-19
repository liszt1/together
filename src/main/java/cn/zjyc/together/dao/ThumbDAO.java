package cn.zjyc.together.dao;

import org.apache.ibatis.annotations.Param;

import cn.zjyc.together.entity.Thumb;

/**
 * 
 * @ClassName: ThumbDAO
 * @Description:点赞信息数据访问层接口
 * @author: while_box
 * @date: 2017年9月28日 下午2:15:05 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface ThumbDAO {

	/**
	 * 增加点赞信息 初始id递增,th_state为未点赞
	 * 
	 * @param thumb
	 *            点赞信息
	 */
	public void save(@Param("Thumb")Thumb thumb);

	/**
	 * 更新运动点赞信息
	 * 
	 * @param thumb
	 *            点赞信息
	 */
	public void update(@Param("Thumb")Thumb thumb);

	/**
	 * 根据队伍id和用户id查询点赞信息,并返回
	 * 
	 * @param team_id
	 *            队伍id
	 * @param user_id
	 *            用户id
	 * @return 点赞信息
	 */
	public Thumb findThumbByUserTeam(@Param("team_id")Integer team_id, @Param("user_id")Integer user_id);
	
	

}
