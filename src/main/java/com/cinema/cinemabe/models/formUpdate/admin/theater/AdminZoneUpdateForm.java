package com.cinema.cinemabe.models.formUpdate.admin.theater;

import com.cinema.cinemabe.models.dto.admin.movie.AdminShowTimeMiniDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterMiniDTO;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Data
public class AdminZoneUpdateForm {

    private Boolean isASeat;

    private List<Integer> showTimes;

}
