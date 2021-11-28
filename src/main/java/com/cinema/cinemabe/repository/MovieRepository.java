package com.cinema.cinemabe.repository;

import com.cinema.cinemabe.models.entity.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}