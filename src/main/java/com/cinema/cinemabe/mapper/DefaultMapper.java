package com.cinema.cinemabe.mapper;

public interface DefaultMapper<DTO, MINIDTO, FORM, UFORM, ENTITY>{

    DTO toDTO(ENTITY entity);
    MINIDTO toSmallDTO (ENTITY entity);
    ENTITY toEntity (FORM form);
    //ENTITY updateEntity (UFORM uform);

}
