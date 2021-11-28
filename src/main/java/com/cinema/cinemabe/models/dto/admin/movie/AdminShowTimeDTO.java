package com.cinema.cinemabe.models.dto.admin.movie;

import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterMiniDTO;
import com.cinema.cinemabe.models.dto.admin.theater.AdminZoneMiniDTO;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AdminShowTimeDTO {

    private Integer id;
    private Date startTime;
    private Date endTime;
    private List<AdminZoneMiniDTO> zones;
    private AdminTheaterMiniDTO theater;
    private AdminMovieMiniDTO movie;

}
