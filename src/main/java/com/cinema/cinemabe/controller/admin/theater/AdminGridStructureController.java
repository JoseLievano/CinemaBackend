package com.cinema.cinemabe.controller.admin.theater;

import com.cinema.cinemabe.controller.DefaultController;
import com.cinema.cinemabe.models.dto.admin.theater.AdminGridStructureDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminGridStructureMiniDTO;
import com.cinema.cinemabe.models.form.admin.theater.AdminGridStructureForm;
import com.cinema.cinemabe.models.formUpdate.admin.theater.AdminGridStructureUpdateForm;
import com.cinema.cinemabe.services.defaultService.DefaultService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grid")
public class AdminGridStructureController extends DefaultController<AdminGridStructureDTO, AdminGridStructureMiniDTO, AdminGridStructureForm, AdminGridStructureUpdateForm, Integer> {

    protected AdminGridStructureController(DefaultService<AdminGridStructureDTO, AdminGridStructureMiniDTO, AdminGridStructureForm, AdminGridStructureUpdateForm, Integer> service){
        super(service);
    }

}
