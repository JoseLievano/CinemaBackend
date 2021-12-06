package com.cinema.cinemabe.mapper.users;

import com.cinema.cinemabe.mapper.DefaultMapper;
import com.cinema.cinemabe.models.dto.users.UserDTO;
import com.cinema.cinemabe.models.dto.users.UserMiniDTO;
import com.cinema.cinemabe.models.entity.users.User;
import com.cinema.cinemabe.models.form.users.UserForm;
import com.cinema.cinemabe.models.formUpdate.users.UserUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class UserMapper implements DefaultMapper<UserDTO, UserMiniDTO, UserForm, UserUpdateForm, User> {

    @Lazy
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public UserDTO toDTO(User entity) {
        if (entity == null)
            return null;

        return UserDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .role(roleMapper.toSmallDTO(entity.getRole()))
                .build();
    }

    @Override
    public UserMiniDTO toSmallDTO(User entity) {
        if (entity == null)
            return null;

        return UserMiniDTO.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .build();
    }

    @Override
    public User toEntity(UserForm form) {
        if (form == null)
            return null;

        return User.builder()
                .username(form.getUsername())
                .password(form.getPassword())
                .build();
    }
}
