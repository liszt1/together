package cn.zjyc.together.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.dao.TeamDAO;
import cn.zjyc.together.entity.Team;
import cn.zjyc.together.service.HistoryService;
import cn.zjyc.together.util.MapSwap;


@Service("historyService")
public class HistoryServiceImpl implements HistoryService {

	@Resource(name="teamDAO")
	private TeamDAO dao;
	
	


	public Map<Team, String> history(Integer user_id) {
		Map<Team, String> historyTeam = MapSwap.SwapFindThumbByUserId(dao.findThumbByUserId(user_id));
		return historyTeam;
	}

}
