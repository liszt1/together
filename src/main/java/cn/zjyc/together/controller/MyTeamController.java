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
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.MyTeamService;
import cn.zjyc.together.util.ConverterUtil;


/**
 * 
 * @ClassName: MyTeamController
 * @Description:我的队伍表示层
 * @author: while_box
 * @date: 2017年9月25日 下午3:19:30
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
@Controller
public class MyTeamController {

	@Resource(name = "myTeamService")
	private MyTeamService mts;

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
			myTeam = mts.findMyTeam(user_id);

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
}
