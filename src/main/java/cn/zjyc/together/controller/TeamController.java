package cn.zjyc.together.controller;

import java.sql.Timestamp;
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
import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.TeamService;
import cn.zjyc.together.util.ConverterUtil;

/**
 * 
 * @Description:队伍表示层
 * @author: while_box
 * @date: 2017年9月19日 上午9:22:07
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
@Controller
public class TeamController {

	@Resource(name = "teamService")
	private TeamService teamService;
	
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
			team = teamService.addTeam(team, user_id);
			
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

	@RequestMapping("/allTeamMember.do")
	@ResponseBody
	public Map<String, Object> allTeamMember(HttpServletRequest request, HttpServletResponse response) {
		// 返回所有队伍
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		List<User> allTeamMember = new ArrayList<User>();
		Map<String, Object> state = new HashMap<String, Object>();
		Integer team_id = ConverterUtil.toInteger(request.getParameter("team_id"));
		try {
			//获取当前队伍所有成员信息
			 allTeamMember = teamService.allTeamMember(team_id);
			 
		} catch (Exception e) {
			e.printStackTrace();
			if(e instanceof AppException){
				//应用异常，
				//明确提示用户采取正确的操作
				System.out.println(e.getMessage());
				state.put("code", 1);
				state.put("msg", e.getMessage());
				return state;
			} else {
				//系统异常
				//提示用户稍后重试
				System.out.println("系统异常，提示用户稍后再试");
				state.put("code", 1);
				state.put("msg", "请稍后再试");
				return state;
			}
		} finally {
		}
		//查询成功,返回所有可加入的队伍
		state.put("code", 0);
		state.put("msg", "success");
		state.put("data", allTeamMember);
		return state;
	}
	
	@RequestMapping("/allTeam.do")
	@ResponseBody
	public Map<String, Object> allTeam(HttpServletRequest request, HttpServletResponse response) {
		// 返回所有队伍
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		List<Team> allTeam = new ArrayList<Team>();
		Map<String, Object> state = new HashMap<String, Object>();
		String city = request.getParameter("city");
		try {
			//获取所有状态为可加入的队伍的信息
			 allTeam = teamService.findAllTeam(city);

		} catch (Exception e) {
			e.printStackTrace();
			if(e instanceof AppException){
				//应用异常，
				//明确提示用户采取正确的操作
				System.out.println(e.getMessage());
				state.put("code", 1);
				state.put("msg", e.getMessage());
				return state;
			} else {
				//系统异常
				//提示用户稍后重试
				System.out.println("系统异常，提示用户稍后再试");
				state.put("code", 1);
				state.put("msg", "请稍后再试");
				return state;
			}
		} finally {
		}
		//查询成功,返回所有可加入的队伍
		state.put("code", 0);
		state.put("msg", "success");
		state.put("data", allTeam);
		return state;
	}
	


	@RequestMapping("/myTeam.do")
	@ResponseBody
	public Map<String, Object> myTeam(HttpServletRequest request, HttpServletResponse response) {
		// 返回所有队伍
		response.setContentType("text/json;charset=utf-8");
		Map<String, Object> state = new HashMap<String, Object>();
		Integer user_id = ConverterUtil.toInteger(request.getParameter("user_id")); 
		List<Team> myTeam = new ArrayList<Team>();
		try {
			//获取用户作为队长的队伍信息列表
			myTeam = teamService.findMyTeam(user_id);

		} catch (Exception e) {
			e.printStackTrace();
			if(e instanceof AppException){
				//应用异常，
				//明确提示用户采取正确的操作
				System.out.println(e.getMessage());
				state.put("code", 1);
				state.put("msg", e.getMessage());
				return state;
			} else {
				//系统异常
				//提示用户稍后重试
				System.out.println("系统异常，提示用户稍后再试");
				state.put("code", 1);
				state.put("msg", "请稍后再试");
				return state;
			}
		} finally {
		}
		//查询成功,返回所有可加入的队伍
		state.put("code", 0);
		state.put("msg", "success");
		state.put("data", myTeam);
		return state;
	}
	
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
			allTeam = teamService.findUserAllTeam(num);
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
