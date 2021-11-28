package com.cinema.cinemabe.models.dto.admin.movie;

import lombok.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AdminMovieDTO {

    private Integer id;

    private String name;

    private Integer durationSecs;

    private List<AdminShowTimeMiniDTO> showTimes;

}
