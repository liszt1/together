package mybatis.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zjyc.together.dao.ProblemDAO;
import cn.zjyc.together.entity.Problem;


/*
 * Spring单元测试
 * @ContextConfiguration指定Spring配置文件的位置
 * 直接autowried
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-mybatis.xml"})
public class ProblemDaoTest{
	@Autowired
	ProblemDAO problemdao;
	
	@Test
	public void save() {
		Problem problem = new Problem();
		problem.setUser_id(8);
		problem.setProblem("哈喽");
		problem.setAnswer("你好");
		problemdao.save(problem);
		
	}
	@Test
	public void update() {
		Problem problem = new Problem();
		problem.setUser_id(8);
		problem.setProblem("嗨");
		problem.setAnswer("你好");
		problemdao.update(problem);
		
	}
	@Test
	public void find() {
		
		System.out.println(problemdao.findByUser(8));
		
	}

}