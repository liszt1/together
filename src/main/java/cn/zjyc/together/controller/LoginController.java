package cn.zjyc.together.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zjyc.together.entity.User;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.LoginService;


/**
 * 
 * @ClassName: LoginController
 * @Description:登入表示层
 * @author: while_box
 * @date: 2017年9月19日 上午9:22:37
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
@Controller
public class LoginController {

	@Resource(name="loginService")
	private LoginService ls;

	@RequestMapping("/login.do")
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) {
		//从请求中获取用户账号和密码
		String num = request.getParameter("num");
		String user_pw = request.getParameter("user_pw");
		User user = null;
		response.setContentType("text/json;charset=utf-8");
		Map<String, Object> state = new HashMap<String, Object>();
		try {
			user = ls.checkLogin(num, user_pw);
		}catch (Exception e) {
			//此处应记录日志
			
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
		}
		//验证正确,返回用户的所有信息
		state.put("code", 0);
		state.put("msg", "success");
		state.put("data", user);
		return state;
	}

}
