package com.cinema.cinemabe.services.admin.theater;

import com.cinema.cinemabe.exeptions.ElementNotFoundExeption;
import com.cinema.cinemabe.mapper.admin.theater.GridStructureMapper;
import com.cinema.cinemabe.models.dto.admin.theater.AdminGridStructureDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminGridStructureMiniDTO;
import com.cinema.cinemabe.models.entity.theater.GridStructure;
import com.cinema.cinemabe.models.form.admin.theater.AdminGridStructureForm;
import com.cinema.cinemabe.models.formUpdate.admin.theater.AdminGridStructureUpdateForm;
import com.cinema.cinemabe.repository.GridStructureRepository;
import com.cinema.cinemabe.services.defaultService.DefaultServiceImplement;
import org.springframework.stereotype.Service;

@Service
public class AdminGridStructureServiceImplement extends DefaultServiceImplement <AdminGridStructureDTO, AdminGridStructureMiniDTO, AdminGridStructureForm, AdminGridStructureUpdateForm, GridStructure, Integer> {

    protected AdminGridStructureServiceImplement (GridStructureRepository repository, GridStructureMapper mapper){
        super(repository, mapper);
    }


    @Override
    public AdminGridStructureMiniDTO insert(AdminGridStructureForm form) throws ElementNotFoundExeption {
        if (form == null){
            return null;
        }

        GridStructure toInsert = mapper.toEntity(form);

        String newBlueprint = "";

        int sizeBluePrint = form.getColumns() * form.getRows();

        for(int i = 0; i < sizeBluePrint; i++){
            newBlueprint = newBlueprint + "0";
        }

        toInsert.setBluePrint(newBlueprint);

        repository.save(toInsert);

        return mapper.toSmallDTO(toInsert);

    }

    @Override
    public AdminGridStructureDTO update(Integer id, AdminGridStructureUpdateForm form) throws ElementNotFoundExeption {

        GridStructure toUpdate = repository.findById(id).orElseThrow(ElementNotFoundExeption::new);

        if (form.getName() != null){
            toUpdate.setName(form.getName());
        }

        if (form.getBluePrint() != null){
            toUpdate.setBluePrint(form.getBluePrint());
        }

        repository.save(toUpdate);

        return mapper.toDTO(toUpdate);

    }
}
