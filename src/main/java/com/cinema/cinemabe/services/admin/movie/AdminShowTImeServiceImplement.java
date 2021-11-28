package com.cinema.cinemabe.services.admin.movie;

import com.cinema.cinemabe.mapper.admin.movie.ShowTimeMapper;
import com.cinema.cinemabe.models.dto.admin.movie.AdminShowTimeDTO;
import com.cinema.cinemabe.models.dto.admin.movie.AdminShowTimeMiniDTO;
import com.cinema.cinemabe.models.entity.movie.ShowTime;
import com.cinema.cinemabe.models.form.admin.movie.AdminShowTimeForm;
import com.cinema.cinemabe.models.formUpdate.admin.movie.AdminShowTimeUpdateForm;
import com.cinema.cinemabe.repository.ShowTimeRepository;
import com.cinema.cinemabe.services.defaultService.DefaultServiceImplement;

public class AdminShowTImeServiceImplement extends DefaultServiceImplement<AdminShowTimeDTO, AdminShowTimeMiniDTO, AdminShowTimeForm, AdminShowTimeUpdateForm, ShowTime, Integer> {

    protected AdminShowTImeServiceImplement(ShowTimeRepository repository, ShowTimeMapper mapper){
        super(repository, mapper);
    }

}
