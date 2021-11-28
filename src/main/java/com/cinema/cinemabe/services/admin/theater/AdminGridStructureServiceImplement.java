package com.cinema.cinemabe.services.admin.theater;

import com.cinema.cinemabe.mapper.admin.theater.GridStructureMapper;
import com.cinema.cinemabe.models.dto.admin.theater.AdminGridStructureDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminGridStructureMiniDTO;
import com.cinema.cinemabe.models.entity.theater.GridStructure;
import com.cinema.cinemabe.models.form.admin.theater.AdminGridStructureForm;
import com.cinema.cinemabe.models.formUpdate.admin.theater.AdminGridStructureUpdateForm;
import com.cinema.cinemabe.repository.GridStructureRepository;
import com.cinema.cinemabe.services.defaultService.DefaultServiceImplement;

public class AdminGridStructureServiceImplement extends DefaultServiceImplement <AdminGridStructureDTO, AdminGridStructureMiniDTO, AdminGridStructureForm, AdminGridStructureUpdateForm, GridStructure, Integer> {

    protected AdminGridStructureServiceImplement (GridStructureRepository repository, GridStructureMapper mapper){
        super(repository, mapper);
    }

}
