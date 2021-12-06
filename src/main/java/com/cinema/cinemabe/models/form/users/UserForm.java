package com.cinema.cinemabe.models.form.users;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Validated
public class UserForm {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Min(1)
    private Integer role;

}
