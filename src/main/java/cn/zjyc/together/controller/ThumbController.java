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
import cn.zjyc.together.service.ThumbService;
import cn.zjyc.together.util.ConverterUtil;

/**
 * 
 * @ClassName: ThumbController
 * @Description:点赞表示层
 * @author: while_box
 * @date: 2017年9月28日 下午4:08:21
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
@Controller
public class ThumbController {

	@Resource(name="thumbService")
	private ThumbService ts;
	
	@RequestMapping("thumb.do")
	@ResponseBody
	public Map<String, Object> thumb(HttpServletRequest request, HttpServletResponse response){
		//从请求中获取队伍id和申请者id
		Integer team_id = ConverterUtil.toInteger(request.getParameter("team_id"));
		Integer user_id = ConverterUtil.toInteger(request.getParameter("user_id"));
		
		response.setContentType("text/json;charset=utf-8");
		Map<String, Object> state = new HashMap<String, Object>();
		try {
//			System.out.println("thumb-begin");
			ts.thumb(team_id, user_id);
//			System.out.println("thumb-end");
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
