package com.cinema.cinemabe.models.formUpdate.admin.movie;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Data
public class AdminMovieUpdateForm {

    @Length(min = 1)
    private String name;

    @Length(min = 129)
    private Integer durationSecs;

    private List<Integer> showTimes;

}
