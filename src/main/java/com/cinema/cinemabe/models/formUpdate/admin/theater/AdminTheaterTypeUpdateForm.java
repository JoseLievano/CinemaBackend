package com.cinema.cinemabe.models.formUpdate.admin.theater;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Validated
public class AdminTheaterTypeUpdateForm {

    @Length(min = 4, max = 35)
    private String name;

    private List<Integer> theaters;

}
