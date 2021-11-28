package com.cinema.cinemabe.mapper.admin.theater;

import com.cinema.cinemabe.mapper.DefaultMapper;
import com.cinema.cinemabe.models.dto.admin.theater.AdminGridStructureDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminGridStructureMiniDTO;
import com.cinema.cinemabe.models.entity.theater.GridStructure;
import com.cinema.cinemabe.models.form.admin.theater.AdminGridStructureForm;
import com.cinema.cinemabe.models.formUpdate.admin.theater.AdminGridStructureUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class GridStructureMapper implements DefaultMapper<AdminGridStructureDTO, AdminGridStructureMiniDTO, AdminGridStructureForm, AdminGridStructureUpdateForm, GridStructure>{

    @Lazy
    @Autowired
    private TheaterMapper theaterMapper;

    @Override
    public AdminGridStructureDTO toDTO(GridStructure entity) {

        if (entity == null)
            return null;

        return AdminGridStructureDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .rows(entity.getRows())
                .columns(entity.getColumns())
                .bluePrint(entity.getBluePrint())
                .theaters(entity.getTheaters()
                        .stream()
                        .map(theaterMapper::toSmallDTO)
                        .collect(Collectors.toList())
                )
                .build();

    }

    @Override
    public AdminGridStructureMiniDTO toSmallDTO(GridStructure entity) {
        if (entity == null)
            return null;

        return AdminGridStructureMiniDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .rows(entity.getRows())
                .columns(entity.getColumns())
                .bluePrint(entity.getBluePrint())
                .build();
    }

    @Override
    public GridStructure toEntity(AdminGridStructureForm form) {
        if (form == null)
            return null;

        return GridStructure.builder()
                .name(form.getName())
                .rows(form.getRows())
                .columns(form.getColumns())
                .build();

    }
}
