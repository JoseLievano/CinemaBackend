package com.cinema.cinemabe.models.dto.admin.theater;

import com.cinema.cinemabe.models.entity.theater.Theater;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AdminGridStructureDTO {

    private Integer id;

    private String name;

    private Integer rows;

    private Integer columns;

    private String bluePrint;

    private List<AdminTheaterMiniDTO> theaters;

}
