package cn.zjyc.together.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.RequestDAO;
import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.ViewApplicantService;

/**
 * 
 * @ClassName: ViewApplicantServiceImpl
 * @Description:ViewApplicantService的实现类
 * @author: while_box
 * @date: 2017年9月21日 下午1:56:34
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
@Service("viewApplicantService")
public class ViewApplicantServiceImpl implements ViewApplicantService {

	@Resource(name = "requestDAO")
	private RequestDAO dao;

	
	public List<User> viewApplicant(Integer team_id) {
		List<User> list = null;
		list = dao.findProposer(team_id);
		return list;
	}

}
