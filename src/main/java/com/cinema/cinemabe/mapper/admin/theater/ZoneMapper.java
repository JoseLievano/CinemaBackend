package com.cinema.cinemabe.mapper.admin.theater;

import com.cinema.cinemabe.mapper.DefaultMapper;
import com.cinema.cinemabe.mapper.admin.movie.ShowTimeMapper;
import com.cinema.cinemabe.models.dto.admin.theater.AdminZoneDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminZoneMiniDTO;
import com.cinema.cinemabe.models.entity.theater.Zone;
import com.cinema.cinemabe.models.form.admin.theater.AdminZoneForm;
import com.cinema.cinemabe.models.formUpdate.admin.theater.AdminZoneUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ZoneMapper implements DefaultMapper <AdminZoneDTO, AdminZoneMiniDTO, AdminZoneForm, AdminZoneUpdateForm, Zone> {

    @Lazy
    @Autowired
    private ShowTimeMapper showTimeMapper;

    @Lazy
    @Autowired
    private TheaterMapper theaterMapper;

    @Override
    public AdminZoneDTO toDTO(Zone entity) {

        if (entity == null)
            return null;

        return AdminZoneDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .isASeat(entity.getIsASeat())
                .showTimes(entity.getShowTimes()
                        .stream()
                        .map(showTimeMapper::toSmallDTO)
                        .collect(Collectors.toList())
                )
                .theater(theaterMapper.toSmallDTO(entity.getTheater()))
                .build();

    }

    @Override
    public AdminZoneMiniDTO toSmallDTO(Zone entity) {

        if (entity == null)
            return null;

        return AdminZoneMiniDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .isASeat(entity.getIsASeat())
                .build();

    }

    @Override
    public Zone toEntity(AdminZoneForm form) {

        if (form == null)
            return null;

        return Zone.builder()
                .name(form.getName())
                .isASeat(form.getIsASeat())
                .build();
    }
}
