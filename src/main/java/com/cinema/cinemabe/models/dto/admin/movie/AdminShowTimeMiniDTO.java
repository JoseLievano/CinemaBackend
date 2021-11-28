package com.cinema.cinemabe.models.dto.admin.movie;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AdminShowTimeMiniDTO {

    private Integer id;

    private Date startTime;

    private Date endTime;

}
