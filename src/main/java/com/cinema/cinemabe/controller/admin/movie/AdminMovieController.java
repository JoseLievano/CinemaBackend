package com.cinema.cinemabe.controller.admin.movie;

import com.cinema.cinemabe.controller.DefaultController;
import com.cinema.cinemabe.models.dto.admin.movie.AdminMovieDTO;
import com.cinema.cinemabe.models.dto.admin.movie.AdminMovieMiniDTO;
import com.cinema.cinemabe.models.form.admin.movie.AdminMovieForm;
import com.cinema.cinemabe.models.formUpdate.admin.movie.AdminMovieUpdateForm;
import com.cinema.cinemabe.services.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class AdminMovieController extends DefaultController<AdminMovieDTO, AdminMovieMiniDTO, AdminMovieForm, AdminMovieUpdateForm, Integer> {

    protected AdminMovieController(DefaultService<AdminMovieDTO, AdminMovieMiniDTO, AdminMovieForm, AdminMovieUpdateForm, Integer> service){
        super(service);
    }

}
