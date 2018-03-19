package cn.zjyc.together.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zjyc.together.entity.Team;
import cn.zjyc.together.service.AddTeamService;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.util.ConverterUtil;

/**
 * 
 * @ClassName: AddTeamController
 * @Description:创建队伍表示层
 * @author: while_box
 * @date: 2017年9月19日 上午9:22:07
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
@Controller
public class AddTeamController {

	@Resource(name = "addTeamService")
	private AddTeamService ats;

	@RequestMapping("/addTeam.do")
	@ResponseBody
	public Map<String, Object> addTeam(HttpServletRequest request, HttpServletResponse response) {

		// 从请求中获取队伍信息
		String team_name = request.getParameter("team_name");
		Integer type_id = ConverterUtil.toInteger(request.getParameter("type_id"));
		String city = request.getParameter("city");
		// String concentrated = request.getParameter("concentrated");
		String introduction = request.getParameter("introduction");
		Timestamp startTime = ConverterUtil.toTimestamp(request.getParameter("startTime"));
		Timestamp endTime = ConverterUtil.toTimestamp(request.getParameter("endTime"));
		Integer user_id = ConverterUtil.toInteger(request.getParameter("user_id"));
		Integer limit_num = ConverterUtil.toInteger(request.getParameter("limit_num"));
		
		
		// 将请求中获取到的队伍信息保存在实体对象中
		Team team = new Team();
		team.setTeam_name(team_name);
		team.setType_id(type_id);
		team.setCity(city);
		team.setIntroduction(introduction);
		team.setStartTime(startTime);
		team.setEndTime(endTime);
		team.setLimit_num(limit_num);
		
//		System.out.println(team);
		
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Map<String, Object> state = new HashMap<String, Object>();

		try {
			// 请求提交给业务层处理,若成功则返回一个Team实体对象
			team = ats.addTeam(team, user_id);
			
			// 返回创建队伍成功
		} catch (Exception e) {
			e.printStackTrace();
			// 创建队伍失败
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
		}
		// 创建队伍成功,返回队伍信息
		state.put("code", 0);
		state.put("msg", "success");
		state.put("data", team);
		return state;
	}

}
