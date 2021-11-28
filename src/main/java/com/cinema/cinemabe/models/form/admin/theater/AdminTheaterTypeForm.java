package com.cinema.cinemabe.models.form.admin.theater;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class AdminTheaterTypeForm {

    @NotBlank
    @Length(min = 4, max = 35)
    private String name;

}
