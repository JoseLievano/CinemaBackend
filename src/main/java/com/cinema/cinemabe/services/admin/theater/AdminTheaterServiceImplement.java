package com.cinema.cinemabe.services.admin.theater;

import com.cinema.cinemabe.exeptions.ElementNotFoundExeption;
import com.cinema.cinemabe.mapper.admin.theater.TheaterMapper;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterMiniDTO;
import com.cinema.cinemabe.models.entity.theater.Theater;
import com.cinema.cinemabe.models.entity.theater.TheaterType;
import com.cinema.cinemabe.models.form.admin.theater.AdminTheaterForm;
import com.cinema.cinemabe.models.formUpdate.admin.theater.AdminTheaterUpdateForm;
import com.cinema.cinemabe.repository.TheaterRepository;
import com.cinema.cinemabe.repository.TheaterTypeRepository;
import com.cinema.cinemabe.services.defaultService.DefaultServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminTheaterServiceImplement extends DefaultServiceImplement <AdminTheaterDTO, AdminTheaterMiniDTO, AdminTheaterForm, AdminTheaterUpdateForm, Theater, Integer> {

    @Autowired
    private TheaterTypeRepository theaterTypeRepository;

    protected AdminTheaterServiceImplement(TheaterRepository repository, TheaterMapper mapper){
        super(repository,mapper);
    }

    @Override
    public AdminTheaterMiniDTO insert(AdminTheaterForm form) {

        Theater toInsert = mapper.toEntity(form);

        if (form.getTheaterType() != null){
            toInsert.setTheaterType(theaterTypeRepository.getById(form.getTheaterType()));
        }

        repository.save(toInsert);

        return mapper.toSmallDTO(toInsert);

    }

    @Override
    public AdminTheaterDTO update(Integer id, AdminTheaterUpdateForm uform) throws ElementNotFoundExeption {

        Theater toUpdate = repository.findById(id).orElseThrow(ElementNotFoundExeption::new);

        if (uform.getName() != null){
            toUpdate.setName(uform.getName());
        }

        if (uform.getTheaterType() != null){
            TheaterType theaterType = theaterTypeRepository.getById(uform.getTheaterType());
            toUpdate.setTheaterType(theaterType);
        }

        repository.save(toUpdate);

        return mapper.toDTO(toUpdate);

    }
}
