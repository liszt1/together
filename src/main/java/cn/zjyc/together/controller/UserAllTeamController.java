package cn.zjyc.together.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zjyc.together.entity.Team;
import cn.zjyc.together.service.AllTeamService;
import cn.zjyc.together.service.AppException;

/**
 * 
 * @ClassName: UserAllTeamController
 * @Description:用户所在队伍列表表现层
 * @author: while_box
 * @date: 2017年9月23日 下午4:13:11 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
@Controller
public class UserAllTeamController {

	@Resource(name = "allTeamService")
	private AllTeamService as;

	@RequestMapping("/userAllTeam.do")
	@ResponseBody
	public Map<String, Object> userAllTeam(HttpServletRequest request, HttpServletResponse response) {
		// 返回所有队伍
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		List<Team> allTeam = new ArrayList<Team>();
		Map<String, Object> state = new HashMap<String, Object>();
		String num = request.getParameter("num");
		try {
			// 获取所有状态为可加入的队伍的信息
			allTeam = as.findUserAllTeam(num);
		} catch (Exception e) {
			if (e instanceof AppException) {
				// 应用异常，
				// 明确提示用户采取正确的操作
				System.out.println(e.getMessage());
				state.put("code", 1);
				state.put("msg", e.getMessage());
				return state;
			} else {
				// 系统异常
				// 提示用户稍后重试
				System.out.println("系统异常，提示用户稍后再试");
				state.put("code", 1);
				state.put("msg", "请稍后再试");
				return state;
			}
		} finally {
		}
		// 查询成功,返回所有可加入的队伍
		state.put("code", 0);
		state.put("msg", "success");
		state.put("data", allTeam);
		return state;
	}
}
