package com.atecut.springcloud.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.atecut.springcloud.bean.Movie;
import com.atecut.springcloud.bean.User;
import com.atecut.springcloud.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/user")
	public User getUserById() {
		return userService.getUserById(1);
	}
	
	@HystrixCommand(fallbackMethod="buyMovieHystrix") // 熔断方法
	@GetMapping("buyMovie")
	public Map<String, Object> buyMovie() throws RestClientException, URISyntaxException {
		Map<String, Object> map = new HashMap<String, Object>();
		
		User user = getUserById();
		map.put("user", user);
		
		//远程调用
		//1、采用RestTemplate
		//2、采用
		Movie movie = restTemplate.getForObject(new URI("http://CLOUD-PROVIDER-MOVIE/movie"), Movie.class);
		map.put("movie", movie);
		
		return map;
	}
	
	// 熔断方法
	public Map<String, Object> buyMovieHystrix() throws RestClientException, URISyntaxException {
		Map<String, Object> map = new HashMap<String, Object>();
		
		User user = new User();
		user.setId(-1);
		user.setUserName("无用户");
		map.put("user", user);
		Movie movie = new Movie();
		movie.setId(-1);
		movie.setMovieName("无电影");
		map.put("movie", movie);
		return map;
	}
}
