package com.cinema.cinemabe.mapper.admin.movie;

import com.cinema.cinemabe.mapper.DefaultMapper;
import com.cinema.cinemabe.models.dto.admin.movie.AdminMovieDTO;
import com.cinema.cinemabe.models.dto.admin.movie.AdminMovieMiniDTO;
import com.cinema.cinemabe.models.entity.movie.Movie;
import com.cinema.cinemabe.models.form.admin.movie.AdminMovieForm;
import com.cinema.cinemabe.models.formUpdate.admin.movie.AdminMovieUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MovieMapper implements DefaultMapper <AdminMovieDTO, AdminMovieMiniDTO, AdminMovieForm, AdminMovieUpdateForm, Movie> {

    @Lazy
    @Autowired
    private ShowTimeMapper showTimeMapper;

    @Override
    public AdminMovieDTO toDTO(Movie entity) {

        if (entity == null)
            return null;

        return AdminMovieDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .durationSecs(entity.getDurationSecs())
                .showTimes(entity.getShowTimes()
                        .stream()
                        .map(showTimeMapper::toSmallDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }

    @Override
    public AdminMovieMiniDTO toSmallDTO(Movie entity) {

        if (entity == null)
            return null;

        return AdminMovieMiniDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .durationSecs(entity.getDurationSecs())
                .build();
    }

    @Override
    public Movie toEntity(AdminMovieForm form) {

        if (form == null)
            return null;

        return Movie.builder()
                .name(form.getName())
                .durationSecs(form.getDurationSecs())
                .build();

    }
}
