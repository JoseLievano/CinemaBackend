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
public class AdminTheaterDTO {

    private Integer id;

    private String name;

    private AdminTheaterTypeMiniDTO theaterType;

    private AdminGridStructureMiniDTO gridStructure;

    private List<AdminShowTimeMiniDTO> showTimes;

    private List<AdminZoneMiniDTO> zones;

}
