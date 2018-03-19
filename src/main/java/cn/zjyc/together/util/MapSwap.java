package cn.zjyc.together.util;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import cn.zjyc.together.entity.Team;


public class MapSwap {
	
	static Map<Team,String> swap = new HashMap<>();
	static Map<Object, Object> mapswap = new HashMap<>();
	static String swap1=null;
	
	@SuppressWarnings("unchecked")
	public static Map<Team,String> SwapFindThumbByUserId(Map<String, Object> map) {
	
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			mapswap = (Map<Object, Object>) entry.getValue();
	        swap1 = (String) entry.getKey();	            					            				
	        Team team = new Team();
	        	team.setId(ConverterUtil.toInteger((Object)mapswap.get("id")));
	        	team.setTeam_name((String)mapswap.get("team_name"));
	        	team.setType_id(ConverterUtil.toInteger(mapswap.get("type_id")));
	        	team.setCity((String)mapswap.get("city"));
				team.setCreateTime((Timestamp)mapswap.get("createTime"));
				team.setStartTime((Timestamp)mapswap.get("startTime"));
				team.setEndTime((Timestamp)mapswap.get("endTime"));
				team.setIntroduction((String)mapswap.get("introduction"));
				team.setTeam_state((String)mapswap.get("team_state"));
				team.setCurrent_num(ConverterUtil.toInteger((Object)mapswap.get("current_num")));
				team.setLimit_num(ConverterUtil.toInteger((Object)mapswap.get("limit_num")));			
				swap.put(team, swap1);
	}
		 return swap;
		 
	}


}
