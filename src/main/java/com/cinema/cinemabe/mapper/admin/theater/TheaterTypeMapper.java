package com.cinema.cinemabe.mapper.admin.theater;

import com.cinema.cinemabe.mapper.DefaultMapper;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterTypeDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterTypeMiniDTO;
import com.cinema.cinemabe.models.entity.theater.TheaterType;
import com.cinema.cinemabe.models.form.admin.theater.AdminTheaterTypeForm;
import com.cinema.cinemabe.models.formUpdate.admin.theater.AdminTheaterTypeUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TheaterTypeMapper implements DefaultMapper <AdminTheaterTypeDTO, AdminTheaterTypeMiniDTO, AdminTheaterTypeForm, AdminTheaterTypeUpdateForm, TheaterType> {

    @Lazy
    @Autowired
    private TheaterMapper theaterMapper;

    @Override
    public AdminTheaterTypeDTO toDTO(TheaterType entity) {
        if (entity == null)
            return null;

        return AdminTheaterTypeDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .theaters(entity.getTheaters()
                        .stream()
                        .map(theaterMapper::toSmallDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }

    @Override
    public AdminTheaterTypeMiniDTO toSmallDTO(TheaterType entity) {
        if (entity == null)
            return null;

        return AdminTheaterTypeMiniDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public TheaterType toEntity(AdminTheaterTypeForm form) {
        if (form == null)
            return null;

        return TheaterType.builder()
                .name(form.getName())
                .build();
    }


}
