package cn.zjyc.together.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zjyc.together.entity.Team;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.RequestFeedbackService;
import cn.zjyc.together.util.ConverterUtil;


/**
 * 
 * @ClassName: TeamDynamics
 * @Description:队伍动态表示层
 * @author: while_box
 * @date: 2017年9月26日 上午9:27:57
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
@Controller
public class TeamDynamics {

	@Resource(name="requestFeedbackService")
	private RequestFeedbackService rfs;
	
	@RequestMapping("/teamDynamics.do")
	@ResponseBody
	public Map<String, Object> teamDynamics(HttpServletRequest request, HttpServletResponse response) {
		// 用户申请队伍的申请状态
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Map<String, Object> state = new HashMap<String, Object>();
		Map<Team, String> allRequest = new HashMap<Team, String>();
		Integer user_id = ConverterUtil.toInteger(request.getParameter("user_id"));
		try {
			
			allRequest = rfs.requestFeedback(user_id);
			 
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
	
	
}
