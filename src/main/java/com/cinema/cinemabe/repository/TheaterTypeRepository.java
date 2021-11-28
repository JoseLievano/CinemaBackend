package com.cinema.cinemabe.repository;

import com.cinema.cinemabe.models.entity.theater.TheaterType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterTypeRepository extends JpaRepository <TheaterType, Integer> {

}