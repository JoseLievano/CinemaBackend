package com.cinema.cinemabe.models.dto.admin.theater;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AdminGridStructureMiniDTO {

    private Integer id;

    private String name;

    private Integer rows;

    private Integer columns;

    private String bluePrint;

}
