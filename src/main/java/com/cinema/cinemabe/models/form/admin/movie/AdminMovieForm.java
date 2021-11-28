package com.cinema.cinemabe.models.form.admin.movie;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@Data
public class AdminMovieForm {

    @NotBlank
    @Length(min = 1, max = 299)
    private String name;

    @NotNull
    @Length(min = 900)
    private Integer durationSecs;

}
