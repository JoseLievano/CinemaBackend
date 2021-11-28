package com.cinema.cinemabe.models.dto.admin.movie;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AdminMovieMiniDTO {

    private Integer id;

    private String name;

    private Integer durationSecs;

}
