package cn.zjyc.together.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.zjyc.together.entity.Type;

/**
 * 
 * @ClassName: TypeDAO
 * @Description:运动类型信息数据访问层接口
 * @author: while_box
 * @date: 2017年9月22日 上午10:26:01
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
public interface TypeDAO {
	
	/**
	 * 增加运动类型信息
	 * @param type 运动类型信息
	 */
	public void save(@Param("Type")Type type);

	/**
	 * 更新运动类型信息
	 * @param type 运动类型信息 
	 */
	public void update(@Param("Type")Type type);
	
	/**
	 * 查询所有运动类型,并返回
	 * @return
	 */
	public List<Type> findAllType();
}
