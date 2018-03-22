package cn.zjyc.together.service;

/**
 * 设置用户头像
 * @ClassName: ChangeUserIcon
 * @Description:修改用户头像业务层接口
 * @author: while_box
 * @date: 2017年10月3日 下午3:24:43
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface ChangeUserIconService {

	/**
	 * 修改用户头像
	 */
	public void changeUserIcon(Integer user_id, String icon);
}
