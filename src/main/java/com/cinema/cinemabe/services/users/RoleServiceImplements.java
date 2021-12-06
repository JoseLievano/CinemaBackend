package com.cinema.cinemabe.services.users;

import com.cinema.cinemabe.exeptions.ElementNotFoundExeption;
import com.cinema.cinemabe.mapper.users.RoleMapper;
import com.cinema.cinemabe.models.dto.users.RoleDTO;
import com.cinema.cinemabe.models.dto.users.RoleMiniDTO;
import com.cinema.cinemabe.models.entity.users.Role;
import com.cinema.cinemabe.models.form.users.RoleForm;
import com.cinema.cinemabe.models.formUpdate.users.RoleUpdateForm;
import com.cinema.cinemabe.repository.RoleRepository;
import com.cinema.cinemabe.services.defaultService.DefaultServiceImplement;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplements extends DefaultServiceImplement<RoleDTO, RoleMiniDTO, RoleForm, RoleUpdateForm, Role, Integer> {

    protected RoleServiceImplements(RoleRepository repository, RoleMapper mapper){
        super(repository, mapper);
    }

    @Override
    public RoleMiniDTO insert(RoleForm form) throws ElementNotFoundExeption {
        if (form == null)
            return null;

        Role toInsert = mapper.toEntity(form);

        repository.save(toInsert);

        return mapper.toSmallDTO(toInsert);
    }
}
