package com.cinema.cinemabe.models.formUpdate.admin.theater;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@Data
public class AdminGridStructureUpdateForm {

    @NotBlank
    @Length(min = 2, max = 22)
    private String name;

    @NotBlank
    @Length(min = 1)
    private String bluePrint;

}
