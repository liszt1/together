package mybatis.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.zjyc.together.dao.TypeDAO;
import cn.zjyc.together.entity.Type;


/*
 * Spring单元测试
 * @ContextConfiguration指定Spring配置文件的位置
 * 直接autowried
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring-mybatis.xml"})
public class TypeDaoTest{
	@Autowired
	TypeDAO typedao;

	@Test
	public void save(){
		Type type = new Type();
		type.setType("篮球");
		type.setId(1);
		
		typedao.save(type);
	}
	@Test
	public void update() {
		Type type = new Type();
		type.setType("乒乓球");
		type.setId(2);
		
		typedao.update(type);
	}
	@Test
	public void find() {
		
		List<Type> type2= typedao.findAllType();
		for(Type type22:type2) {
		System.out.println(type22);
		}
	}
	
	

}