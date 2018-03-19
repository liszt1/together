package cn.zjyc.together.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.zjyc.together.constant.EnumStateAll;
import cn.zjyc.together.dao.ThumbDAO;
import cn.zjyc.together.dao.UserDAO;
import cn.zjyc.together.entity.Thumb;
import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.ThumbService;

@Service("thumbService")
public class ThumbServiceImpl implements ThumbService {

	@Resource(name = "userDAO")
	private UserDAO userDAO;

	@Resource(name = "thumbDAO")
	private ThumbDAO thumbDAO;

	public void thumb(Integer team_id, Integer user_id) {
		/*
		 * 1.根据队伍id和用户id来查找用户所在队伍中除了用户自己的成员信息 2.修改这些成员信息(将点赞数加1)
		 * 3.修改点赞信息(将点赞信息中的状态改为已赞)
		 */

		Thumb thumb = thumbDAO.findThumbByUserTeam(team_id, user_id);
		// 如果状态为已点赞则抛出异常
		if (EnumStateAll.thumbyes.getName().equals(thumb.getTh_state())) {
			throw new AppException("已经赞过这只队伍啦");
		}
		
		List<User> allUser = userDAO.findAllByTeamId(team_id);
		for (User user : allUser) {
			if (user.getId() != user_id) {
				userDAO.thumbUser(user.getId());
			}
		}
		// 否则修改点赞状态为已点赞
		thumb.setTh_state(EnumStateAll.thumbyes.getName());
		thumbDAO.update(thumb);
	}

}
