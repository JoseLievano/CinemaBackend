package com.cinema.cinemabe.controller.admin.theater;

import com.cinema.cinemabe.controller.DefaultController;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterTypeDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterTypeMiniDTO;
import com.cinema.cinemabe.models.form.admin.theater.AdminTheaterTypeForm;
import com.cinema.cinemabe.models.formUpdate.admin.theater.AdminTheaterTypeUpdateForm;
import com.cinema.cinemabe.services.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatertype")
public class AdminTheaterTypeController extends DefaultController<AdminTheaterTypeDTO, AdminTheaterTypeMiniDTO, AdminTheaterTypeForm, AdminTheaterTypeUpdateForm, Integer> {

    protected AdminTheaterTypeController(DefaultService<AdminTheaterTypeDTO, AdminTheaterTypeMiniDTO, AdminTheaterTypeForm, AdminTheaterTypeUpdateForm, Integer> service){
        super(service);
    }

}
