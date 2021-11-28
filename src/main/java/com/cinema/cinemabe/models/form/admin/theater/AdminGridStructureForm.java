package com.cinema.cinemabe.models.form.admin.theater;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@Data
public class AdminGridStructureForm {

    @NotBlank
    @Length(min = 2, max = 22)
    private String name;

    @Min(1)
    @NotNull
    private Integer rows;

    @Min(1)
    @NotNull
    private Integer columns;

}
