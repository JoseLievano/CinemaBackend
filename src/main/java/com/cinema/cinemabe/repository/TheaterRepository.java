package com.cinema.cinemabe.repository;

import com.cinema.cinemabe.models.entity.theater.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {

}