package com.cinema.cinemabe.repository;

import com.cinema.cinemabe.models.entity.theater.GridStructure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GridStructureRepository extends JpaRepository<GridStructure, Integer> {
}