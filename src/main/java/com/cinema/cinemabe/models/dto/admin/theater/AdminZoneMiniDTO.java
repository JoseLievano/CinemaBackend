package com.cinema.cinemabe.models.dto.admin.theater;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AdminZoneMiniDTO {

    private Integer id;

    private String name;

    private Boolean isASeat;

}
