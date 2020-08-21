package com.atecut.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atecut.springcloud.bean.Movie;
import com.atecut.springcloud.dao.MovieDao;

@Service
public class MovieService {
	@Autowired
	MovieDao movieDao;

	public Movie getNewMovie() {
		return movieDao.getNewMovie();
	}
}
