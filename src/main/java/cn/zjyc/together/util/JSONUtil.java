package cn.zjyc.together.util;

import java.io.PrintWriter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.zjyc.together.entity.User;

public class JSONUtil {
	
	public static String userToJSON(PrintWriter pw, User user) throws JsonProcessingException{
		ObjectMapper om = new ObjectMapper();
		String message = null;
		message = om.writeValueAsString(user);
		pw.println(message);
		pw.flush();
		return null;
	}
}
