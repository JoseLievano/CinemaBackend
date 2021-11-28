package com.cinema.cinemabe.models.dto.admin.theater;

import com.cinema.cinemabe.models.dto.admin.movie.AdminShowTimeMiniDTO;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AdminZoneDTO {

    private Integer id;

    private String name;

    private Boolean isASeat;

    private List<AdminShowTimeMiniDTO> showTimes;

    private AdminTheaterMiniDTO theater;

}
