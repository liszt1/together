package cn.zjyc.together.service;

/**
 * 
 * @ClassName: ThumbService
 * @Description:用户点赞业务层接口
 * @author: while_box
 * @date: 2017年9月28日 下午3:10:45
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface ThumbService {

	/**
	 * 点赞功能,在点赞表中修改状态,并且将队伍中除了自己之外的成员点赞数加1
	 * @param team_id 队伍id
	 * @param user_id 用户id
	 */
	public void thumb(Integer team_id, Integer user_id);
}
