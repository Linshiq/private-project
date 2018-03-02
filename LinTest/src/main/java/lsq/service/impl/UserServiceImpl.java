package lsq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lsq.dao.UserMapper;
import lsq.model.User;
import lsq.service.dao.UserServiceDao;

@Service("userService")
public class UserServiceImpl implements UserServiceDao {

	private UserMapper userMapper;
	
	public UserMapper getUserMapper() {
		return userMapper;
	}
	
    @Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public User getUserById(String id) {
		
		System.out.println("==========lsqUse================");
		
		return userMapper.selectByPrimaryKey(id);
	}

}
