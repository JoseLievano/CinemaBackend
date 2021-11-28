package com.cinema.cinemabe.controller.admin.theater;

import com.cinema.cinemabe.controller.DefaultController;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterMiniDTO;
import com.cinema.cinemabe.models.form.admin.theater.AdminTheaterForm;
import com.cinema.cinemabe.models.formUpdate.admin.theater.AdminTheaterUpdateForm;
import com.cinema.cinemabe.services.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theater")
public class AdminTheaterController extends DefaultController <AdminTheaterDTO, AdminTheaterMiniDTO, AdminTheaterForm, AdminTheaterUpdateForm, Integer>{

    protected AdminTheaterController (DefaultService<AdminTheaterDTO, AdminTheaterMiniDTO, AdminTheaterForm, AdminTheaterUpdateForm, Integer> service){
        super(service);
    }

}
