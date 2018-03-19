package cn.zjyc.together.service;

import cn.zjyc.together.entity.User;

/**
 * 
 * @ClassName: RegisterService
 * @Description:注册业务层接口
 * @author: while_box
 * @date: 2017年9月19日 上午9:26:06 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface RegisterService {
	/**
	 * 注册用户
	 * 
	 * @param user
	 *            注册的用户信息
	 * @return 注册成功后用户信息
	 * @throws AppException
	 *             该账号已经被注册
	 */
	public User register(User user);
}
