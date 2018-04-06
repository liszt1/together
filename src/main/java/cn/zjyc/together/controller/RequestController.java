package cn.zjyc.together.controller;

import java.io.Serializable;
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
import cn.zjyc.together.service.RequestService;
import cn.zjyc.together.util.ConverterUtil;

@Controller
public class RequestController {
	
	final private String utf = "text/json;charset=utf-8";
	
	@Resource(name = "requestSevice")
	private RequestService requestSevice;

	@RequestMapping("/allowJoinTeam.do")
	@ResponseBody
	public Map<String, Object> allowJoinTeam(HttpServletRequest request, HttpServletResponse response){
		//从请求中获取队伍id和申请者id
		Integer team_id = ConverterUtil.toInteger(request.getParameter("team_id"));
		Integer user_id = ConverterUtil.toInteger(request.getParameter("user_id"));
		
		response.setContentType(utf);
		Map<String, Object> state = new HashMap<String, Object>();
		try {
			requestSevice.allowJoinTeam(team_id, user_id);
		} catch (Exception e) {
			if(e instanceof AppException){
				//应用异常，
				//明确提示用户采取正确的操作
				System.out.println(e.getMessage());
				state.put("code", 1);
				state.put("msg", e.getMessage());
				return state;
			}else {
				//系统异常
				//提示用户稍后重试
				System.out.println("系统异常，提示用户稍后再试");
				state.put("code", 1);
				state.put("msg", "请稍后再试");
				return state;
			}
		}
		state.put("code", 0);
		state.put("msg", "success");
		state.put("data", "{}");
		return state;
	}
	
	
	@RequestMapping("/joinTeam.do")
	@ResponseBody
	public Map<String, Object> joinTeam(HttpServletRequest request, HttpServletResponse response){
		//从请求中获取队伍id和申请者id
		Integer team_id = ConverterUtil.toInteger(request.getParameter("team_id"));
		Integer user_id = ConverterUtil.toInteger(request.getParameter("user_id"));
		
		response.setContentType(utf);
		Map<String, Object> state = new HashMap<String, Object>();
		try {
			requestSevice.joinTeam(team_id, user_id);
		} catch (Exception e) {
			if(e instanceof AppException){
				//应用异常，
				//明确提示用户采取正确的操作
				System.out.println(e.getMessage());
				state.put("code", 1);
				state.put("msg", e.getMessage());
				return state;
			}else {
				//系统异常
				//提示用户稍后重试
				System.out.println("系统异常，提示用户稍后再试");
				state.put("code", 1);
				state.put("msg", "请稍后再试");
				return state;
			}
		}
		state.put("code", 0);
		state.put("msg", "success");
		state.put("data", "{}");
		return state;
	}
	
	@RequestMapping("/refusedJoinTeam.do")
	@ResponseBody
	public Map<String, Object> refusedJoinTeam(HttpServletRequest request, HttpServletResponse response){
		//从请求中获取队伍id和申请者id
		Integer team_id = ConverterUtil.toInteger(request.getParameter("team_id"));
		Integer user_id = ConverterUtil.toInteger(request.getParameter("user_id"));
		
		response.setContentType(utf);
		Map<String, Object> state = new HashMap<String, Object>();
		try {
			requestSevice.refusedJoinTeam(team_id, user_id);
		} catch (Exception e) {
			if(e instanceof AppException){
				//应用异常，
				//明确提示用户采取正确的操作
				System.out.println(e.getMessage());
				state.put("code", 1);
				state.put("msg", e.getMessage());
				return state;
			}else {
				//系统异常
				//提示用户稍后重试
				System.out.println("系统异常，提示用户稍后再试");
				state.put("code", 1);
				state.put("msg", "请稍后再试");
				return state;
			}
		}
		state.put("code", 0);
		state.put("msg", "success");
		state.put("data", "{}");
		return state;
	}
	

	@RequestMapping("/requestFeedback.do")
	@ResponseBody
	public Map<String, Object> requestFeedback(HttpServletRequest request, HttpServletResponse response) {
		Integer user_id = ConverterUtil.toInteger(request.getParameter("user_id"));
		// 返回所有队伍
		response.setContentType(utf);
		response.setCharacterEncoding("utf-8");
		Map<Team, String> requestFeedback = new HashMap<Team, String>();
		Map<String, Object> state = new HashMap<String, Object>();
		List<RequestFeedback> list = new ArrayList<RequestController.RequestFeedback>();
		try {

			/*
			 * 1.根据用户id查找用户申请的状态和队伍信息
			 * 2.进行封装,封装到队伍动态表现层内部类中
			 * 3.保存在list中
			 */
			
			// 1 根据用户id查找用户申请的状态和队伍信息
			requestFeedback = requestSevice.requestFeedback(user_id);

			//2 3 
			for(Map.Entry<Team, String> entry : requestFeedback.entrySet()){
				RequestFeedback qf = new RequestFeedback();
				qf.setTeam(entry.getKey());
				qf.setRe_state(entry.getValue());
				list.add(qf);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
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
		state.put("data", list);
		return state;
	}
	
	
	/**
	 * 
	 * @ClassName: RequestFeedback
	 * @Description:队伍动态表现层内部类,包含了队伍信息和用户的申请状态
	 * @author: while_box
	 * @date: 2017年9月26日 下午5:47:30
	 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
	 */
	class RequestFeedback implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Team team;
		String re_state;
		
		public Team getTeam() {
			return team;
		}
		public void setTeam(Team team) {
			this.team = team;
		}
		public String getRe_state() {
			return re_state;
		}
		public void setRe_state(String re_state) {
			this.re_state = re_state;
		}
	}
	
	@RequestMapping("/teamDynamics.do")
	@ResponseBody
	public Map<String, Object> teamDynamics(HttpServletRequest request, HttpServletResponse response) {
		// 用户申请队伍的申请状态
		response.setContentType(utf);
		response.setCharacterEncoding("utf-8");
		Map<String, Object> state = new HashMap<String, Object>();
		Map<Team, String> allRequest = new HashMap<Team, String>();
		Integer user_id = ConverterUtil.toInteger(request.getParameter("user_id"));
		try {
			
			allRequest = requestSevice.requestFeedback(user_id);
			 
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
		state.put("data", allRequest);
		return state;
	}
	


		@RequestMapping("/viewApplicant.do")
		@ResponseBody
		public Map<String, Object> viewApplicant(HttpServletRequest request, HttpServletResponse response) {
			// 从请求中获取队伍id和申请者id
			Integer team_id = ConverterUtil.toInteger(request.getParameter("team_id"));

			response.setContentType("text/json;charset=utf-8");
			Map<String, Object> state = new HashMap<String, Object>();
			List<User> list = null;
			try {
				list = requestSevice.viewApplicant(team_id);
			} catch (Exception e) {
				if(e instanceof AppException){
					//应用异常，
					//明确提示用户采取正确的操作
					System.out.println(e.getMessage());
					state.put("code", 1);
					state.put("msg", e.getMessage());
					return state;
				}else {
					//系统异常
					//提示用户稍后重试
					System.out.println("系统异常，提示用户稍后再试");
					state.put("code", 1);
					state.put("msg", "请稍后再试");
					return state;
				}
			}
			state.put("code", 0);
			state.put("msg", "success");
			state.put("data", list);
			return state;
		}
	
}
