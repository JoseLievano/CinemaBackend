package com.cinema.cinemabe.controller.admin.theater;

import com.cinema.cinemabe.controller.DefaultController;
import com.cinema.cinemabe.models.dto.admin.theater.AdminZoneDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminZoneMiniDTO;
import com.cinema.cinemabe.models.form.admin.theater.AdminZoneForm;
import com.cinema.cinemabe.models.formUpdate.admin.theater.AdminZoneUpdateForm;
import com.cinema.cinemabe.services.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zone")
public class AdminZoneController extends DefaultController <AdminZoneDTO, AdminZoneMiniDTO, AdminZoneForm, AdminZoneUpdateForm, Integer> {

    protected AdminZoneController (DefaultService<AdminZoneDTO, AdminZoneMiniDTO, AdminZoneForm, AdminZoneUpdateForm, Integer> service){
        super(service);
    }

}
