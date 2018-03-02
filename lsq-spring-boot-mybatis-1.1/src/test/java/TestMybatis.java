

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.Application;
import com.lsq.db.dao.UserMapper;
import com.lsq.db.model.User;

@RunWith(SpringJUnit4ClassRunner.class)

////指定我们SpringBoot工程的Application启动类
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestMybatis {
	
	UserMapper usd;

	public UserMapper getLdpaZhhaoyeService() {
		return usd;
	}

	@Autowired
	public void setLdpaZhhaoyeService(UserMapper usd) {
		this.usd = usd;
	}

	@Test
	public void test() {
		// 取出初始数据
		
		User s = usd.selectByPrimaryKey("1");
		
		System.out.println(s.getId()+"sssss");
		
	}
	
	
}
