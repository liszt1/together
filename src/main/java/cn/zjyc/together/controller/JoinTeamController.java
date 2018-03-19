package cn.zjyc.together.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.JoinTeamService;
import cn.zjyc.together.util.ConverterUtil;

/**
 * 
 * @ClassName: JoinTeamController
 * @Description:申请加入队伍表示层
 * @author: while_box
 * @date: 2017年9月20日 下午2:40:01
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
@Controller
public class JoinTeamController {
	
	@Resource(name="joinTeamService")
	private JoinTeamService jts;
	
	@RequestMapping("/joinTeam.do")
	@ResponseBody
	public Map<String, Object> joinTeam(HttpServletRequest request, HttpServletResponse response){
		//从请求中获取队伍id和申请者id
		Integer team_id = ConverterUtil.toInteger(request.getParameter("team_id"));
		Integer user_id = ConverterUtil.toInteger(request.getParameter("user_id"));
		
		response.setContentType("text/json;charset=utf-8");
		Map<String, Object> state = new HashMap<String, Object>();
		try {
			jts.joinTeam(team_id, user_id);
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
}
