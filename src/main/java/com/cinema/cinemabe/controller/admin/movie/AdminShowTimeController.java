package com.cinema.cinemabe.controller.admin.movie;

import com.cinema.cinemabe.controller.DefaultController;
import com.cinema.cinemabe.models.dto.admin.movie.AdminShowTimeDTO;
import com.cinema.cinemabe.models.dto.admin.movie.AdminShowTimeMiniDTO;
import com.cinema.cinemabe.models.form.admin.movie.AdminShowTimeForm;
import com.cinema.cinemabe.models.formUpdate.admin.movie.AdminShowTimeUpdateForm;
import com.cinema.cinemabe.services.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/showtime")
public class AdminShowTimeController extends DefaultController <AdminShowTimeDTO, AdminShowTimeMiniDTO, AdminShowTimeForm, AdminShowTimeUpdateForm, Integer> {

    protected AdminShowTimeController(DefaultService<AdminShowTimeDTO, AdminShowTimeMiniDTO, AdminShowTimeForm, AdminShowTimeUpdateForm, Integer> service){
        super(service);
    }
}
