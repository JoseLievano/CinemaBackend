package com.cinema.cinemabe.models.form.admin.movie;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Validated
public class AdminShowTimeForm {

    @NotNull
    private Date startTime;
    @NotNull
    private Date endTime;
    @NotNull
    private Integer theater;
    @NotNull
    private Integer movie;

}
