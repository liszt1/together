package mybatis.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zjyc.together.dao.ThumbDAO;
import cn.zjyc.together.dao.UserDAO;
import cn.zjyc.together.entity.Thumb;
import cn.zjyc.together.entity.User;


/*
 * Spring单元测试
 * @ContextConfiguration指定Spring配置文件的位置
 * 直接autowried
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-mybatis.xml"})
public class ThumbDaoTest{
	@Autowired
	ThumbDAO thumbdao;
	
	@Test
	public void save() {
	Thumb t = new Thumb();
	t.setTeam_id(5);
	t.setUser_id(8);
	thumbdao.save(t);
	}
	@Test
	public void update() {
		Thumb t = new Thumb();
		t.setTeam_id(5);
		t.setUser_id(8);
		t.setTh_state("已点赞");
		thumbdao.update(t);
	}
	@Test
	public void findThumbByUserTeam() {
		Thumb t = thumbdao.findThumbByUserTeam(5, 8);
		System.out.println(t);
	}

	
	
}