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
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.HistoryService;
import cn.zjyc.together.util.ConverterUtil;


/**
 * 
 * @ClassName: HistoryController
 * @Description:历史记录表现层
 * @author: while_box
 * @date: 2017年9月26日 下午6:09:37
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
@Controller
public class HistoryController {

	@Resource(name = "historyService")
	private HistoryService hs;

	@RequestMapping("/history.do")
	@ResponseBody
	public Map<String, Object> history(HttpServletRequest request, HttpServletResponse response) {
		// 从请求中获取用户id
		Integer user_id = ConverterUtil.toInteger(request.getParameter("user_id"));
		// 响应请求
		response.setContentType("text/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		Map<Team, String> historyTeam = new HashMap<Team, String>();
		Map<String, Object> state = new HashMap<String, Object>();
		List<History> list = new ArrayList<HistoryController.History>();
		try {
			
			/*
			 * 1.根据用户id查找用户的点赞情况和历史队伍
			 * 2.进行封装,封装到历史记录表现层内部类中
			 * 3.保存在list中
			 */

			historyTeam = hs.history(user_id);
			
			

			//2 3 
			for(Map.Entry<Team, String> entry : historyTeam.entrySet()){
				History history = new History();
				history.setTeam(entry.getKey());
				history.setTh_state(entry.getValue());
				list.add(history);
			}
			
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
		state.put("data", list);
		return state;
	}
	
	
	class History implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		Team team;
		String th_state;
		public Team getTeam() {
			return team;
		}
		public void setTeam(Team team) {
			this.team = team;
		}
		public String getTh_state() {
			return th_state;
		}
		public void setTh_state(String th_state) {
			this.th_state = th_state;
		}
		
	}
}
