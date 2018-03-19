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
import cn.zjyc.together.service.RegisterService;
import cn.zjyc.together.util.ConverterUtil;


/**
 * 
 * @ClassName: RegisterController
 * @Description:注册表示层
 * @author: while_box
 * @date: 2017年9月19日 上午9:22:51
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
@Controller
public class RegisterController {
	
	@Resource(name="registerService")
	private RegisterService rs;
	
	@RequestMapping("/register.do")
	@ResponseBody
	public Map<String, Object> register(HttpServletRequest request,HttpServletResponse response){
		//从请求中获取用户数据
		String num = request.getParameter("num");
		String user_pw = request.getParameter("user_pw");
		String user_name = request.getParameter("user_name");
		String sex = request.getParameter("sex");
		Integer age = ConverterUtil.toInteger(request.getParameter("age"));
		Integer height = ConverterUtil.toInteger(request.getParameter("height"));
		Integer weight = ConverterUtil.toInteger(request.getParameter("weight"));
		String tel = request.getParameter("tel");
		String introduction = request.getParameter("introduction");
		String place = request.getParameter("place");
		//将获取到的数据保存为新的user
		User user = new User();
		user.setUser_name(user_name);
		user.setNum(num);
		user.setUser_pw(user_pw);
		user.setSex(sex);
		user.setAge(age);
		user.setHeight(height);
		user.setWeight(weight);
		user.setTel(tel);
		user.setIntroduction(introduction);
		user.setPlace(place);
		
		response.setContentType("text/json;charset=utf-8");
		
		Map<String, Object> state = new HashMap<String, Object>();
		//将保存的user交由业务层处理
		try {
			user = rs.register(user);
			
		} catch (Exception e) {
			
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
		
		//注册成功,返回用户的所有信息
		state.put("code", 0);
		state.put("msg", "success");
		state.put("data", user);
		return state;
	}
}
