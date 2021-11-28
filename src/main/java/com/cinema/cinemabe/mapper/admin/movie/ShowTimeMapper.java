package com.cinema.cinemabe.mapper.admin.movie;

import com.cinema.cinemabe.mapper.DefaultMapper;
import com.cinema.cinemabe.mapper.admin.theater.TheaterMapper;
import com.cinema.cinemabe.mapper.admin.theater.ZoneMapper;
import com.cinema.cinemabe.models.dto.admin.movie.AdminShowTimeDTO;
import com.cinema.cinemabe.models.dto.admin.movie.AdminShowTimeMiniDTO;
import com.cinema.cinemabe.models.entity.movie.ShowTime;
import com.cinema.cinemabe.models.form.admin.movie.AdminShowTimeForm;
import com.cinema.cinemabe.models.formUpdate.admin.movie.AdminShowTimeUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ShowTimeMapper implements DefaultMapper<AdminShowTimeDTO, AdminShowTimeMiniDTO, AdminShowTimeForm, AdminShowTimeUpdateForm, ShowTime> {

    @Lazy
    @Autowired
    private ZoneMapper zoneMapper;

    @Lazy
    @Autowired
    private TheaterMapper theaterMapper;

    @Lazy
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public AdminShowTimeDTO toDTO(ShowTime entity) {

        if (entity == null)
            return null;

        return AdminShowTimeDTO.builder()
                .id(entity.getId())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .zones(entity.getZones()
                        .stream()
                        .map(zoneMapper::toSmallDTO)
                        .collect(Collectors.toList())
                )
                .theater(theaterMapper.toSmallDTO(entity.getTheater()))
                .movie(movieMapper.toSmallDTO(entity.getMovie()))
                .build();

    }

    @Override
    public AdminShowTimeMiniDTO toSmallDTO(ShowTime entity) {

        if (entity == null)
            return null;

        return AdminShowTimeMiniDTO.builder()
                .id(entity.getId())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .build();

    }

    @Override
    public ShowTime toEntity(AdminShowTimeForm form) {

        if (form == null)
            return null;

        return ShowTime.builder()
                .startTime(form.getStartTime())
                .endTime(form.getEndTime())
                .build();
    }
}
