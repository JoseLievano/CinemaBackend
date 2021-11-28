package com.cinema.cinemabe.services.admin.theater;

import com.cinema.cinemabe.mapper.admin.theater.ZoneMapper;
import com.cinema.cinemabe.models.dto.admin.theater.AdminZoneDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminZoneMiniDTO;
import com.cinema.cinemabe.models.entity.theater.Theater;
import com.cinema.cinemabe.models.entity.theater.Zone;
import com.cinema.cinemabe.models.form.admin.theater.AdminZoneForm;
import com.cinema.cinemabe.models.formUpdate.admin.theater.AdminZoneUpdateForm;
import com.cinema.cinemabe.repository.ZoneRepository;
import com.cinema.cinemabe.services.defaultService.DefaultServiceImplement;
import org.springframework.stereotype.Service;

@Service
public class AdminZoneServiceImplement extends DefaultServiceImplement <AdminZoneDTO, AdminZoneMiniDTO, AdminZoneForm, AdminZoneUpdateForm, Zone, Integer>{

    protected AdminZoneServiceImplement(ZoneRepository repository, ZoneMapper mapper){
        super(repository, mapper);
    }


}
