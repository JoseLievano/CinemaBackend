package com.cinema.cinemabe.services.defaultService;

import com.cinema.cinemabe.exeptions.ElementNotFoundExeption;

import java.util.List;

public interface DefaultService < DTO, MINIDTO, FORM, UFORM, ID >{

    DTO getOne(ID id) throws ElementNotFoundExeption;

    List<DTO> getAll();

    MINIDTO insert(FORM form);

    DTO update(ID id, UFORM form) throws ElementNotFoundExeption;

    DTO delete (ID id) throws ElementNotFoundExeption;

}
