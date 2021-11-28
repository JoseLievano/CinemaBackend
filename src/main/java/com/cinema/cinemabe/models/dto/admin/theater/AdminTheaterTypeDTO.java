package com.cinema.cinemabe.models.dto.admin.theater;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AdminTheaterTypeDTO {

    private Integer id;

    private String name;

    private List<AdminTheaterMiniDTO> theaters;

}
