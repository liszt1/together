package cn.zjyc.together.dao;

import java.util.List;


import org.apache.ibatis.annotations.Param;

import cn.zjyc.together.entity.User;

/**
 * 
 * @ClassName: UserDAO
 * @Description:用户数据访问层接口
 * @author: while_box
 * @date: 2017年9月19日 上午9:23:34 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface UserDAO {
	/**
	 * 根据用户账号查找用户信息
	 * 
	 * @param num
	 *            用户账号
	 * @return 用户信息
	 */
	public User findByNumber(String num);

	/**
	 * 根据用户信息中的用户id,更新用户信息
	 * 
	 * @param user
	 *            用户信息
	 */
	public void update(@Param("User")User user);

	/**
	 * 保存用户
	 * 
	 * @param user
	 *            需要保存的用户
	 */
	public void save(@Param("User")User user);

	/**
	 * 根据队伍id查询用户所在队伍所有'已加入'成员的信息 其中用户信息需要的字段为:
	 * user_name,icon,sex,user_like,blacklist,
	 * height,weight,tel,introduction,place
	 * 
	 * @param id
	 *            队伍id
	 * @return 用户所在队伍所有成员信息
	 */
	public List<User> findAllByTeamId(Integer id);
	
	/**
	 * 根据用户id将用户的点赞数加1
	 * @param user_id 用户id
	 */
	public void thumbUser(Integer user_id);
	
	/**
	 * 根据用户id查找用户信息
	 * @param user_id
	 * @return
	 */
	public User findById(Integer user_id);

}
