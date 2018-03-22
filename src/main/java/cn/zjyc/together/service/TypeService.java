package cn.zjyc.together.service;

import java.util.List;

import cn.zjyc.together.entity.Type;

public interface TypeService {
	/**
	 * 所有运动类型信息列表
	 * @return 所有运动类型信息列表
	 */
	public List<Type> findAllType();
}
