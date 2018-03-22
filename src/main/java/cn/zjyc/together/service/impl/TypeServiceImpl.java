package cn.zjyc.together.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.TypeDAO;
import cn.zjyc.together.entity.Type;
import cn.zjyc.together.service.TypeService;
@Service("typeService")
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeDAO typeDAO;
	@Override
	public List<Type> findAllType() {
			return typeDAO.findAllType();
		}

	}
