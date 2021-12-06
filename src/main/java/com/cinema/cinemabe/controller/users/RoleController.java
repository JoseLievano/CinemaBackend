package com.cinema.cinemabe.controller.users;

import com.cinema.cinemabe.controller.DefaultController;
import com.cinema.cinemabe.models.dto.users.RoleDTO;
import com.cinema.cinemabe.models.dto.users.RoleMiniDTO;
import com.cinema.cinemabe.models.form.users.RoleForm;
import com.cinema.cinemabe.models.formUpdate.users.RoleUpdateForm;
import com.cinema.cinemabe.services.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController extends DefaultController<RoleDTO, RoleMiniDTO, RoleForm, RoleUpdateForm, Integer> {

    protected RoleController(DefaultService<RoleDTO, RoleMiniDTO, RoleForm, RoleUpdateForm, Integer> service){
        super(service);
    }

}
