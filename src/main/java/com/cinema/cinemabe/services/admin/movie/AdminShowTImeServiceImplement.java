package com.cinema.cinemabe.services.admin.movie;

import com.cinema.cinemabe.exeptions.ElementNotFoundExeption;
import com.cinema.cinemabe.mapper.admin.movie.ShowTimeMapper;
import com.cinema.cinemabe.mapper.admin.theater.ZoneMapper;
import com.cinema.cinemabe.models.dto.admin.movie.AdminShowTimeDTO;
import com.cinema.cinemabe.models.dto.admin.movie.AdminShowTimeMiniDTO;
import com.cinema.cinemabe.models.entity.movie.ShowTime;
import com.cinema.cinemabe.models.entity.theater.Zone;
import com.cinema.cinemabe.models.form.admin.movie.AdminShowTimeForm;
import com.cinema.cinemabe.models.formUpdate.admin.movie.AdminShowTimeUpdateForm;
import com.cinema.cinemabe.repository.MovieRepository;
import com.cinema.cinemabe.repository.ShowTimeRepository;
import com.cinema.cinemabe.repository.TheaterRepository;
import com.cinema.cinemabe.repository.ZoneRepository;
import com.cinema.cinemabe.services.defaultService.DefaultServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminShowTImeServiceImplement extends DefaultServiceImplement<AdminShowTimeDTO, AdminShowTimeMiniDTO, AdminShowTimeForm, AdminShowTimeUpdateForm, ShowTime, Integer> {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ZoneMapper zoneMapper;

    @Autowired
    private ZoneRepository zoneRepository;

    protected AdminShowTImeServiceImplement(ShowTimeRepository repository, ShowTimeMapper mapper){
        super(repository, mapper);
    }

    @Override
    public AdminShowTimeMiniDTO insert(AdminShowTimeForm form) throws ElementNotFoundExeption {

        if (form == null)
            return null;

        ShowTime toInsert = mapper.toEntity(form);

        toInsert.setMovie(movieRepository.findById(form.getMovie()).orElseThrow(ElementNotFoundExeption::new));

        toInsert.setTheater(theaterRepository.findById(form.getTheater()).orElseThrow(ElementNotFoundExeption::new));

        repository.save(toInsert);

        return mapper.toSmallDTO(toInsert);

    }

    @Override
    public AdminShowTimeDTO update(Integer id, AdminShowTimeUpdateForm form) throws ElementNotFoundExeption {

        ShowTime toUpdate = repository.findById(id).orElseThrow(ElementNotFoundExeption::new);

        if (form.getStartTime() != null){
            toUpdate.setStartTime(form.getStartTime());
        }

        if (form.getEndTime() != null){
            toUpdate.setEndTime(form.getEndTime());
        }

        if (form.getMovie() != null){
            toUpdate.setMovie(movieRepository.findById(form.getMovie()).orElseThrow(ElementNotFoundExeption::new));
        }

        if (form.getTheater() != null){
            toUpdate.setTheater(theaterRepository.findById(form.getTheater()).orElseThrow(ElementNotFoundExeption::new));
        }

        if (form.getZone().size() > 0){
            List<Zone> newZones = form.getZone()
                    .stream()
                    .map(integer -> {
                        try {
                            return zoneRepository.findById(integer).orElseThrow(ElementNotFoundExeption::new);
                        } catch (ElementNotFoundExeption e) {
                            e.printStackTrace();
                        }
                        return null;
                    })
                    .collect(Collectors.toList());

            toUpdate.addNewZone(newZones);
        }

        repository.save(toUpdate);

        return mapper.toDTO(toUpdate);

    }
}
