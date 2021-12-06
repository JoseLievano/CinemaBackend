package com.cinema.cinemabe.services.admin.movie;

import com.cinema.cinemabe.mapper.admin.movie.MovieMapper;
import com.cinema.cinemabe.models.dto.admin.movie.AdminMovieDTO;
import com.cinema.cinemabe.models.dto.admin.movie.AdminMovieMiniDTO;
import com.cinema.cinemabe.models.entity.movie.Movie;
import com.cinema.cinemabe.models.form.admin.movie.AdminMovieForm;
import com.cinema.cinemabe.models.formUpdate.admin.movie.AdminMovieUpdateForm;
import com.cinema.cinemabe.repository.MovieRepository;
import com.cinema.cinemabe.services.defaultService.DefaultServiceImplement;
import org.springframework.stereotype.Service;

@Service
public class AdminMovieServiceImplement extends DefaultServiceImplement<AdminMovieDTO, AdminMovieMiniDTO, AdminMovieForm, AdminMovieUpdateForm, Movie, Integer> {

    protected AdminMovieServiceImplement(MovieRepository repository, MovieMapper mapper){
        super(repository, mapper);
    }

}
