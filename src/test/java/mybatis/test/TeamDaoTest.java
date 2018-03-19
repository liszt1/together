package mybatis.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zjyc.together.dao.TeamDAO;
import cn.zjyc.together.entity.Team;
import cn.zjyc.together.util.MapSwap;


/*
 * Spring单元测试
 * @ContextConfiguration指定Spring配置文件的位置
 * 直接autowried
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-mybatis.xml"})
public class TeamDaoTest{
	@Autowired
	TeamDAO teamdao;
	
	@Test
	public void save() {
		Team team = new Team();
		team.setId(null);
		team.setTeam_name("12队");
		team.setCity("越");
		team.setIntroduction("呵呵");
		teamdao.save(team);
		
		Integer id = team.getId();
		System.out.println(id);
		
		teamdao.saveRequest(id, 10);
	}
	
	@Test
	public void findMayJoinTeam() {
		List<Team> team = teamdao.findMayJoinTeam();
		for(Team team2 : team) {
		System.out.println(team2);
		System.out.println(team2.getClass().getTypeName());
		}
		}
	@Test
	public void findByUserNum() {
		List<Team> team = teamdao.findByUserNum("222");
		for(Team team2 : team) {
		System.out.println(team2);
		}
		
		}
	

	
	@Test
public void findThumbByUserId() {
		Map<String, Object> maps = teamdao.findThumbByUserId(8);		
		for (Map.Entry<String, Object> entry : maps.entrySet()){
//	            Map<Object,Object> maps2= (Map<Object, Object>) entry.getValue();
	            System.out.println(entry.getKey()+":"+entry.getValue());
//	            for(Entry entry1:maps2.entrySet()){
//		            System.out.println(entry1.getKey()+":"+entry1.getValue());
//	            System.out.println(entry1.getValue().getClass().getTypeName());
	        }
	            Map<Team, String> map = MapSwap.SwapFindThumbByUserId(teamdao.findThumbByUserId(8));
	            for (Map.Entry<Team, String> entry2 : map.entrySet()){
	            	System.out.println(entry2.getKey()+":"+entry2.getValue());
//	            	System.out.println(entry2.getKey().getClass().getTypeName());
//	            	System.out.println(entry2.getValue().getClass().getTypeName());
	            }
	}
		 
	}

	