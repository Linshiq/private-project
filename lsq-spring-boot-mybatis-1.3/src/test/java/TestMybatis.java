

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.Application;
import com.lsq.db.dao.PersonalAccountMapper;
import com.lsq.db.dao.UserMapper;
import com.lsq.db.model.User;

@RunWith(SpringJUnit4ClassRunner.class)

////指定我们SpringBoot工程的Application启动类
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestMybatis {
	
	UserMapper usd;
	
	PersonalAccountMapper personalAcct;
	
	public PersonalAccountMapper getLdpaZhhaoyeService() {
		return personalAcct;
	}

	@Autowired
	public void setLdpaZhhaoyeService(UserMapper personalAcct) {
		this.usd = personalAcct;
	}

	@Test
	public void test() {
		// 取出初始数据
		
		System.out.println("---------");
		//System.out.println("result:"+ personalAcct.selectAllInfo());
		
		System.out.println("---------");
		
	}
	
	
}
