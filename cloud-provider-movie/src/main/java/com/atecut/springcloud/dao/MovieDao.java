package com.atecut.springcloud.dao;

import org.springframework.stereotype.Repository;

import com.atecut.springcloud.bean.Movie;

@Repository
public class MovieDao {
	public Movie getNewMovie() {
		Movie movie = new Movie();
		movie.setId(1);
		movie.setMovieName("战狼");
		return movie;
	}
}
