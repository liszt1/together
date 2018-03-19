package cn.zjyc.together.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zjyc.together.entity.Type;
import cn.zjyc.together.service.AppException;
import cn.zjyc.together.service.MotionTypeService;

/**
 * 
 * @ClassName: MotionTypeController
 * @Description:显示所有运动类型表示层
 * @author: while_box
 * @date: 2017年9月22日 下午2:07:02
 * 注意 : 本内容仅限于浙江农林大学悦动together项目组内部传阅，禁止外泄
 */
@Controller
public class MotionTypeController {

	@Resource(name = "motionTypeService")
	private MotionTypeService mts;

	@RequestMapping("/motionType.do")
	@ResponseBody
	public Map<String, Object> motionType(HttpServletRequest request, HttpServletResponse response) {

		response.setContentType("text/json;charset=utf-8");
		Map<String, Object> state = new HashMap<String, Object>();
		List<Type> allType = null;
		try {
			allType = mts.findAllType();
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
		}
		state.put("code", 0);
		state.put("msg", "success");
		state.put("data", allType);
		return state;
	}
}
