package com.cinema.cinemabe.models.form.admin.theater;

import com.cinema.cinemabe.models.dto.admin.movie.AdminShowTimeMiniDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterMiniDTO;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Data
public class AdminZoneForm {

    private String name;

    private Boolean isASeat;

    private List<Integer> showTimes;

    private AdminTheaterMiniDTO theater;

}
