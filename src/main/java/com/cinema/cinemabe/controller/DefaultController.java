package com.cinema.cinemabe.controller;

import com.cinema.cinemabe.exeptions.ElementNotFoundExeption;
import com.cinema.cinemabe.services.defaultService.DefaultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class DefaultController <DTO, MINIDTO, FORM, UFORM, ID>{

    protected final DefaultService <DTO, MINIDTO, FORM, UFORM, ID> service;

    protected DefaultController(DefaultService<DTO, MINIDTO, FORM, UFORM, ID> service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> getOne(@PathVariable ID id) throws ElementNotFoundExeption {
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<DTO>> getAll (){
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<MINIDTO> insert (@Valid @RequestBody FORM form) throws ElementNotFoundExeption {
        return ResponseEntity.ok(service.insert(form));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> update (@PathVariable ID id, @Valid @RequestBody UFORM uform) throws ElementNotFoundExeption {
        return ResponseEntity.ok(service.update(id, uform));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DTO> delete (@PathVariable ID id) throws ElementNotFoundExeption {
        return ResponseEntity.ok(service.delete(id));
    }

}
