package cn.zjyc.together.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.TeamDAO;
import cn.zjyc.together.entity.Team;
import cn.zjyc.together.service.RequestFeedbackService;
import cn.zjyc.together.util.MapSwap;

@Service("requestFeedbackService")
public class RequestFeedbackServiceImpl implements RequestFeedbackService {

	@Resource(name = "teamDAO")
	private TeamDAO dao;

	public Map<Team, String> requestFeedback(Integer user_id) {

		Map<Team, String> allRequest = MapSwap.SwapFindThumbByUserId(dao.findRequestByUserId(user_id));

		return allRequest;

	}

}
