package com.cinema.cinemabe.services.defaultService;

import com.cinema.cinemabe.exeptions.ElementNotFoundExeption;
import com.cinema.cinemabe.mapper.DefaultMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;


public abstract class DefaultServiceImplement <DTO, MINIDTO, FORM, UFORM, ENTITY, ID> implements DefaultService<DTO, MINIDTO, FORM, UFORM, ID>{

    protected final JpaRepository<ENTITY, ID> repository;
    protected final DefaultMapper<DTO, MINIDTO, FORM, UFORM, ENTITY> mapper;

    public DefaultServiceImplement (JpaRepository<ENTITY, ID> repository, DefaultMapper<DTO, MINIDTO, FORM, UFORM, ENTITY> mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public DTO getOne(ID id) throws ElementNotFoundExeption {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(ElementNotFoundExeption::new);
    }

    @Override
    public List<DTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MINIDTO insert(FORM form) {
        return mapper.toSmallDTO( repository.save(mapper.toEntity( form ) ) );
    }

    @Override
    public DTO update(ID id, UFORM uform) throws ElementNotFoundExeption {
        ENTITY toUpdate = repository.findById(id).orElseThrow(ElementNotFoundExeption::new);

        repository.save(toUpdate);

        return mapper.toDTO(toUpdate);

    }

    @Override
    public DTO delete(ID id) throws ElementNotFoundExeption {

        ENTITY toDelete = repository.findById(id).orElseThrow(ElementNotFoundExeption::new);

        repository.delete(toDelete);

        return mapper.toDTO(toDelete);

    }
}
