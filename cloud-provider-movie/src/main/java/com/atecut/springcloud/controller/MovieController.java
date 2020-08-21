package com.atecut.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atecut.springcloud.bean.Movie;
import com.atecut.springcloud.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	MovieService movieService;

	@Value("${server.port}")
	int port;
	
	/**
	 * 获取最新电影
	 */
	@GetMapping("/movie")
	public Movie getNewMovie() {
		System.out.println("port=" + port);
		return movieService.getNewMovie();
	}

}
