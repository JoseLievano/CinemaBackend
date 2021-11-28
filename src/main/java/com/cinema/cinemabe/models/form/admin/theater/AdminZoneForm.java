package com.cinema.cinemabe.models.form.admin.theater;


import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterMiniDTO;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AdminZoneForm {

    private String name;

    private Boolean isASeat;

    private List<Integer> showTimes;

    private AdminTheaterMiniDTO theater;

}
