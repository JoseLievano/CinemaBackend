package com.cinema.cinemabe.models.form.users;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Validated
@Data
public class RoleForm {

    @NotBlank
    private String authority;

}
