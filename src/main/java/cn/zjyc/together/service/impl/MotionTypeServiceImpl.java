package cn.zjyc.together.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.TypeDAO;
import cn.zjyc.together.entity.Type;
import cn.zjyc.together.service.MotionTypeService;

@Service("motionTypeService")
public class MotionTypeServiceImpl implements MotionTypeService {

	@Resource(name="typeDAO")
	private TypeDAO dao;
	
	public List<Type> findAllType() {
		return dao.findAllType();
	}

}
