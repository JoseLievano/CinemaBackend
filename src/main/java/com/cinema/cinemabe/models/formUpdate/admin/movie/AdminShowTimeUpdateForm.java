package com.cinema.cinemabe.models.formUpdate.admin.movie;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;

@Data
@Validated
public class AdminShowTimeUpdateForm {

    private Date startTime;

    private Date endTime;

    @Length(min = 1)
    private Integer theater;

    @Length(min = 1)
    private Integer movie;

    private List<Integer> zone;

}
