package com.atecut.springcloud.service.exption;

import org.springframework.stereotype.Component;

import com.atecut.springcloud.bean.Movie;
import com.atecut.springcloud.service.MovieServiceFeign;

@Component
public class MovieServiceFeignExceptionHandler implements MovieServiceFeign {

	@Override
	public Movie getNewMovie() {
		Movie movie = new Movie();
		movie.setId(-1);
		movie.setMovieName("无电影");
		return movie;
	}
	
}
