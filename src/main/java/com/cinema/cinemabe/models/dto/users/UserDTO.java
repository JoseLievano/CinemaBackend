package com.cinema.cinemabe.models.dto.users;

import lombok.*;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserDTO {

    private Integer id;

    private String username;

    private RoleMiniDTO role;

}
