package com.cinema.cinemabe.models.form.admin.theater;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@Data
public class AdminTheaterForm {

    @NotBlank
    @Length(min = 4, max = 35)
    private String name;

    @Min(0)
    @NotNull
    private Integer theaterType;

    @NotNull
    @Min(0)
    private Integer gridStructure;

}
