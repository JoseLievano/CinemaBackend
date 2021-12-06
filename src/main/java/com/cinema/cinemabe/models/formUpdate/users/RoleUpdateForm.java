package com.cinema.cinemabe.models.formUpdate.users;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Data
public class RoleUpdateForm {

    private String authority;


}
