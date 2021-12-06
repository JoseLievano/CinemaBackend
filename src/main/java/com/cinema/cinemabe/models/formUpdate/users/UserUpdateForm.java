package com.cinema.cinemabe.models.formUpdate.users;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;


@Data
@Validated
public class UserUpdateForm {

    private String username;

    private String password;

    @NotEmpty
    private Integer role;

}
