package com.cinema.cinemabe.mapper.admin.theater;

import com.cinema.cinemabe.mapper.DefaultMapper;
import com.cinema.cinemabe.mapper.admin.movie.ShowTimeMapper;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterMiniDTO;
import com.cinema.cinemabe.models.entity.theater.Theater;
import com.cinema.cinemabe.models.form.admin.theater.AdminTheaterForm;
import com.cinema.cinemabe.models.formUpdate.admin.theater.AdminTheaterUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class TheaterMapper implements DefaultMapper<AdminTheaterDTO, AdminTheaterMiniDTO, AdminTheaterForm, AdminTheaterUpdateForm, Theater> {

    @Lazy
    @Autowired
    private TheaterTypeMapper theaterTypeMapper;

    @Lazy
    @Autowired
    private GridStructureMapper gridStructureMapper;

    @Lazy
    @Autowired
    private ShowTimeMapper showTimeMapper;

    @Lazy
    @Autowired
    private ZoneMapper zoneMapper;

    @Override
    public AdminTheaterDTO toDTO(Theater entity) {

        if (entity == null)
            return null;

        return AdminTheaterDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .theaterType( theaterTypeMapper.toSmallDTO(entity.getTheaterType()))
                .gridStructure(gridStructureMapper.toSmallDTO(entity.getGridStructure()))
                .showTimes(entity.getShowTimes()
                        .stream()
                        .map(showTimeMapper::toSmallDTO)
                        .collect(Collectors.toList())
                )
                .zones(entity.getZones()
                        .stream()
                        .map(zoneMapper::toSmallDTO)
                        .collect(Collectors.toList())
                )
                .build();
    }

    @Override
    public AdminTheaterMiniDTO toSmallDTO(Theater entity) {

        if (entity == null)
            return null;

        return AdminTheaterMiniDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public Theater toEntity(AdminTheaterForm form) {

        if (form == null)
            return null;

        return Theater.builder()
                .name(form.getName())
                .build();
    }

}
