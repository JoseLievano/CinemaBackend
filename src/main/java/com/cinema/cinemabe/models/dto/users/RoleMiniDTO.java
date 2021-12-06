package com.cinema.cinemabe.models.dto.users;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RoleMiniDTO {

    private Integer id;

    private String authority;

}
