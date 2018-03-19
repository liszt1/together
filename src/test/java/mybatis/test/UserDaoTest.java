package mybatis.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zjyc.together.dao.UserDAO;
import cn.zjyc.together.entity.User;


/*
 * Spring单元测试
 * @ContextConfiguration指定Spring配置文件的位置
 * 直接autowried
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-mybatis.xml"})
public class UserDaoTest{
	@Autowired
	UserDAO userdao;
	
	
	@Test
	public void findByNumber() {
		userdao.findByNumber("aaa");
	}
	@Test
	public void findAllByTeamId() {
		List<User> user = userdao.findAllByTeamId(5);
		for(User user2 : user) {
		System.out.println(user2);
		}
	}
	@Test
	public void findById() {
		userdao.findById(10);
	}
	@Test
	public void save() {
		User user=new User();
		user.setId(1);
		user.setUser_name("王五");
		user.setNum("bbb");
		user.setUser_pw("123");
		user.setSex("男");
		user.setPlace("北京");
		user.setHeight(100);
		user.setWeight(100);
		
		userdao.save(user);
}
	public void update() {
		User user=new User();
		user.setId(10);
		user.setUser_name("李四");	
		user.setSex("女");
		user.setPlace("北京");
		user.setHeight(100);
		user.setWeight(100);
		userdao.update(user);
		
	}
	public void thumbUser() {
		userdao.thumbUser(10);
}
	

}