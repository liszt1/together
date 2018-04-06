package cn.zjyc.together.service.impl;

import java.util.List;
import java.util.Map;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zjyc.together.constant.EnumStateAll;
import cn.zjyc.together.dao.RequestDAO;
import cn.zjyc.together.dao.TeamDAO;
import cn.zjyc.together.dao.ThumbDAO;
import cn.zjyc.together.entity.Request;
import cn.zjyc.together.entity.Team;
import cn.zjyc.together.entity.Thumb;
import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.RequestService;
import cn.zjyc.together.util.MapSwap;

@Service("requestSevice")
public class RequestServiceImpl implements RequestService{

	@Resource
	private RequestDAO requestDAO;

	@Autowired
	private ThumbDAO thumbDAO;

	@Autowired
	private TeamDAO teamDAO;

	@Override
	public void allowJoinTeam(Integer team_id, Integer user_id) {
			// 根据队伍id和用户id取出唯一对应的申请信息
			Request request = requestDAO.findByTeamAndUser(team_id, user_id);

			Thumb thumb = new Thumb();
			thumb.setTeam_id(team_id);
			thumb.setUser_id(user_id);

			Boolean a = false;
			// 改变申请信息中的申请状态(re_state)为已加入
			if(requestDAO.isJoinTeam(team_id, user_id)!=null)
			{
				a = requestDAO.isJoinTeam(team_id, user_id);
			}else
				a = false;
					
			if (!a) {
				
				//增加队伍人数
				Team team = teamDAO.findById(team_id);
				team.setCurrent_num(team.getCurrent_num()+1);
				teamDAO.update(team);
				
				// 新增点赞信息
				thumbDAO.save(thumb);

				// 修改申请信息中的申请状态
				request.setRe_state(EnumStateAll.add.getName());
				// 更新申请信息
				requestDAO.update(request);
			} else {
				throw new AppException("该用户已经不在申请列表中了");
			}
		}
		

	@Override
	public void refusedJoinTeam(Integer team_id, Integer user_id) {
		//根据队伍id和用户id取出唯一对应的申请信息
		Request request = requestDAO.findByTeamAndUser(team_id, user_id);
		if(requestDAO.isApplicant(team_id, user_id)!=null){
			//修改申请信息中的申请状态
			request.setRe_state(EnumStateAll.reject.getName());
			//更新申请信息
			requestDAO.update(request);
		} else {
			throw new AppException("该用户已经不再申请列表中");
		}
	}

	@Override
	public Map<Team, String> requestFeedback(Integer user_id) {

		Map<Team, String> allRequest = MapSwap.SwapFindThumbByUserId(teamDAO.findRequestByUserId(user_id));

		return allRequest;

	}


	@Override
	public void joinTeam(Integer team_id, Integer user_id) {
		if(requestDAO.isApplicant(team_id, user_id)!=null){
			throw new AppException("已经申请过了");
		} else if(requestDAO.isJoinTeam(team_id, user_id)!=null) {
			throw new AppException("已经在队伍中了");
		}
		//成功申请,保存申请记录
		requestDAO.save(team_id, user_id);
	}
	
	@Override
	public List<User> viewApplicant(Integer team_id) {
		List<User> list = null;
		list = requestDAO.findProposer(team_id);
		return list;
	}


}
