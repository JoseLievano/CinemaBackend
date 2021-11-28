package com.cinema.cinemabe.models.formUpdate.admin.theater;

import com.cinema.cinemabe.models.dto.admin.theater.AdminTheaterTypeMiniDTO;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Validated
public class AdminTheaterUpdateForm {

    @Length(min = 4, max = 35)
    private String name;

    @Min(0)
    @NotNull
    private Integer theaterType;

    @Min(1)
    private Integer gridStructure;

}
