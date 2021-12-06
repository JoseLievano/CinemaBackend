package com.cinema.cinemabe.models.dto.users;

import com.cinema.cinemabe.models.entity.users.User;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RoleDTO {

    private Integer id;

    private String authority;

    private List<UserMiniDTO> users;

}
