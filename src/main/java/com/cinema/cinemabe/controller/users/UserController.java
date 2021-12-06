package com.cinema.cinemabe.controller.users;

import com.cinema.cinemabe.controller.DefaultController;
import com.cinema.cinemabe.models.dto.users.UserDTO;
import com.cinema.cinemabe.models.dto.users.UserMiniDTO;
import com.cinema.cinemabe.models.form.users.UserForm;
import com.cinema.cinemabe.models.formUpdate.users.UserUpdateForm;
import com.cinema.cinemabe.services.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends DefaultController <UserDTO, UserMiniDTO, UserForm, UserUpdateForm, Integer>{

    protected UserController(DefaultService <UserDTO, UserMiniDTO, UserForm, UserUpdateForm, Integer> service){
        super(service);
    }

}
