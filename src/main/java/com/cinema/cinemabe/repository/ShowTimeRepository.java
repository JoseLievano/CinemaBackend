package com.cinema.cinemabe.repository;

import com.cinema.cinemabe.models.entity.movie.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowTimeRepository extends JpaRepository<ShowTime, Integer> {
}