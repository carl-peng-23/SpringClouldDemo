package com.atecut.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.atecut.springcloud.bean.Movie;
import com.atecut.springcloud.service.exption.MovieServiceFeignExceptionHandler;

//指定调用哪一个服务，服务名称要与远程服务名称一致
@FeignClient(value = "CLOUD-PROVIDER-MOVIE", fallback = MovieServiceFeignExceptionHandler.class)
public interface MovieServiceFeign {
	
	@GetMapping("/movie")
	public Movie getNewMovie();
	
}
