package com.atecut.springcloud.controller;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.atecut.springcloud.bean.Movie;
import com.atecut.springcloud.bean.User;
import com.atecut.springcloud.service.MovieServiceFeign;
import com.atecut.springcloud.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MovieServiceFeign movieServiceFeign;

	@GetMapping("/user")
	public User getUserById() {
		return userService.getUserById(1);
	}
	
	@GetMapping("buyMovie")
	public Map<String, Object> buyMovie() throws RestClientException, URISyntaxException {
		Map<String, Object> map = new HashMap<String, Object>();
		
		User user = getUserById();
		map.put("user", user);
		
		//远程调用
		//1、采用RestTemplate
		//2、采用freign进行调用
		Movie movie = movieServiceFeign.getNewMovie();
		map.put("movie", movie);
		
		return map;
	}
	
}
