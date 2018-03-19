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

import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.AllTeamMemberService;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.util.ConverterUtil;

/**
 * 
 * @ClassName: AllTeamMemberController
 * @Description:队伍所有成员信息表示层
 * @author: while_box
 * @date: 2017年9月24日 下午2:58:48
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
@Controller
public class AllTeamMemberController {

	@Resource(name="allTeamMemberService")
	private AllTeamMemberService atms;
	
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
			 allTeamMember = atms.allTeamMember(team_id);
			 
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
}
