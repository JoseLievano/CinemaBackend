package com.cinema.cinemabe.mapper.users;

import com.cinema.cinemabe.mapper.DefaultMapper;
import com.cinema.cinemabe.models.dto.users.RoleDTO;
import com.cinema.cinemabe.models.dto.users.RoleMiniDTO;
import com.cinema.cinemabe.models.entity.users.Role;
import com.cinema.cinemabe.models.form.users.RoleForm;
import com.cinema.cinemabe.models.formUpdate.users.RoleUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class RoleMapper implements DefaultMapper<RoleDTO, RoleMiniDTO, RoleForm, RoleUpdateForm, Role> {

    @Lazy
    @Autowired
    private UserMapper userMapper;

    @Override
    public RoleDTO toDTO(Role entity) {

        if (entity == null){
            return null;
        }

        return RoleDTO.builder()
                .id(entity.getId())
                .authority(entity.getAuthority())
                .users(entity.getUsers().stream()
                        .map(userMapper::toSmallDTO)
                        .collect(Collectors.toList()))
                .build();

    }

    @Override
    public RoleMiniDTO toSmallDTO(Role entity) {
        if (entity == null)
            return null;

        return RoleMiniDTO.builder()
                .id(entity.getId())
                .authority(entity.getAuthority())
                .build();
    }

    @Override
    public Role toEntity(RoleForm form) {
        if (form == null)
            return null;

        return Role.builder()
                .authority(form.getAuthority())
                .build();
    }
}
