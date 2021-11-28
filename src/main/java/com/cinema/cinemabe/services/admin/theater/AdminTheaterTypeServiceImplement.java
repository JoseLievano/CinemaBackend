package com.cinema.cinemabe.services.admin.theater;

import com.cinema.cinemabe.exeptions.ElementNotFoundExeption;
import com.cinema.cinemabe.mapper.admin.theater.TheaterTypeMapper;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterTypeDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterTypeMiniDTO;
import com.cinema.cinemabe.models.entity.theater.Theater;
import com.cinema.cinemabe.models.entity.theater.TheaterType;
import com.cinema.cinemabe.models.form.admin.theater.AdminTheaterTypeForm;
import com.cinema.cinemabe.models.formUpdate.admin.theater.AdminTheaterTypeUpdateForm;
import com.cinema.cinemabe.repository.TheaterRepository;
import com.cinema.cinemabe.repository.TheaterTypeRepository;
import com.cinema.cinemabe.services.defaultService.DefaultServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminTheaterTypeServiceImplement extends DefaultServiceImplement <AdminTheaterTypeDTO, AdminTheaterTypeMiniDTO, AdminTheaterTypeForm, AdminTheaterTypeUpdateForm, TheaterType, Integer> {

    @Autowired
    private TheaterRepository theaterRepository;

    protected AdminTheaterTypeServiceImplement(TheaterTypeRepository repository, TheaterTypeMapper mapper){
        super(repository, mapper);
    }

    @Override
    public AdminTheaterTypeDTO update(Integer id, AdminTheaterTypeUpdateForm uform) throws ElementNotFoundExeption {

        TheaterType toUpdate = repository.findById(id).orElseThrow(ElementNotFoundExeption::new);

        if (uform.getName() != null){
            toUpdate.setName(uform.getName());
        }

        if (uform.getTheaters().size() > 0){
            List<Theater> theaters = uform.getTheaters()
                    .stream()
                    .map(theater -> theaterRepository.findById(theater).orElseThrow())
                    .collect(Collectors.toList());
            toUpdate.setTheaters(theaters);
        }

        repository.save(toUpdate);

        return mapper.toDTO(toUpdate);
    }
}
