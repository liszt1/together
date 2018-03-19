package mybatis.test;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zjyc.together.dao.RequestDAO;
import cn.zjyc.together.entity.Request;
import cn.zjyc.together.entity.User;


/*
 * Spring单元测试
 * @ContextConfiguration指定Spring配置文件的位置
 * 直接autowried
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-mybatis.xml"})
public class RequestDaoTest{
	@Autowired
	RequestDAO requestdao;
		
@Test
public void save() {
	requestdao.save(2, 8);
	
}
@Test
public void update() {
	Request request = new Request();
	request.setUser_id(8);
	request.setTeam_id(1);
	request.setRe_state("已加入");
	request.setPosition("队长");
	requestdao.update(request);
}
@Test	
public void findProposer() {
	List<User> user = requestdao.findProposer(5);
	for(User user2 : user) {
		System.out.println(user2);
	}
}
@Test
public void isApplicant() {
	Boolean aa= requestdao.isApplicant(5, 8);
	System.out.println(aa);
	if(aa!=null) {
		System.out.println("成功");
	}
	else
		System.out.println("失败");
}

@Test
public void isJoinTeam() {
	Boolean aa= requestdao.isJoinTeam(5, 8);
	System.out.println(aa);
	if(aa!=null) {
		System.out.println("成功");
	}
	else
		System.out.println("失败");
}

@Test
public void findByTeamAndUser() {
	System.out.println(requestdao.findByTeamAndUser(5, 8));
	
}

}