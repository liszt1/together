package cn.zjyc.together.dao;

import org.apache.ibatis.annotations.Param;

import cn.zjyc.together.entity.Problem;

/**
 * 
 * @ClassName: ProblemDAO
 * @Description:密保信息数据访问层接口
 * @author: while_box
 * @date: 2017年9月22日 上午10:04:09 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface ProblemDAO {

	/**
	 * 增加密保信息,id自动递增
	 * 
	 * @param problem
	 *            密保信息
	 */
	public void save(@Param("Problem")Problem problem);

	/**
	 * 更新密保信息
	 * 
	 * @param problem
	 *            要更新的密保信息
	 */
	public void update(@Param("Problem")Problem problem);

	/**
	 * 根据用户信息查找用户的密保信息
	 * 
	 * @param user_id
	 *            用户id
	 * @return 用户的密保信息
	 */
	public Problem findByUser(Integer user_id);
}
