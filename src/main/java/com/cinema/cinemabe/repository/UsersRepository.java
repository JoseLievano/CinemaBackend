package com.cinema.cinemabe.repository;

import com.cinema.cinemabe.models.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Integer> {
}
