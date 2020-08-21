package com.atecut.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atecut.springcloud.bean.User;
import com.atecut.springcloud.dao.UserDao;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public User getUserById(Integer id) {
		User user = userDao.getUser(id);
		return user;
	}

}
