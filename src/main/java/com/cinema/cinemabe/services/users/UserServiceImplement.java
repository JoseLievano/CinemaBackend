package com.cinema.cinemabe.services.users;

import com.cinema.cinemabe.exeptions.ElementNotFoundExeption;
import com.cinema.cinemabe.mapper.users.UserMapper;
import com.cinema.cinemabe.models.dto.users.UserDTO;
import com.cinema.cinemabe.models.dto.users.UserMiniDTO;
import com.cinema.cinemabe.models.entity.users.Role;
import com.cinema.cinemabe.models.entity.users.User;
import com.cinema.cinemabe.models.form.users.UserForm;
import com.cinema.cinemabe.models.formUpdate.users.UserUpdateForm;
import com.cinema.cinemabe.repository.RoleRepository;
import com.cinema.cinemabe.repository.UsersRepository;
import com.cinema.cinemabe.services.defaultService.DefaultServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement extends DefaultServiceImplement <UserDTO, UserMiniDTO, UserForm, UserUpdateForm, User, Integer> {

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    RoleRepository roleRepository;

    protected UserServiceImplement(UsersRepository repository, UserMapper mapper){
        super(repository, mapper);
    }

    @Override
    public UserMiniDTO insert(UserForm form) throws ElementNotFoundExeption {

        if (form == null)
            return null;

        form.setPassword( encoder.encode(form.getPassword()) );

        User toInsert = mapper.toEntity(form);

        Role role = roleRepository.getById(form.getRole());

        toInsert.setRole(role);

        repository.save(toInsert);

        return mapper.toSmallDTO(toInsert);
    }
}
