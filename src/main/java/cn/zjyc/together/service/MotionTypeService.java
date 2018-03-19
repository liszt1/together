package cn.zjyc.together.service;

import java.util.List;

import cn.zjyc.together.entity.Type;

/**
 * 
 * @ClassName: MotionTypeService
 * @Description:查询所有运动类型业务层接口
 * @author: while_box
 * @date: 2017年9月22日 下午1:43:52
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface MotionTypeService {

	/**
	 * 所有运动类型信息列表
	 * @return 所有运动类型信息列表
	 */
	public List<Type> findAllType();
}
