package com.cinema.cinemabe.models.entity.users;

import lombok.*;

import javax.persistence.*;

@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "roles_id", nullable = false)
    private Role role;

    @Column(nullable = false)
    private boolean accountNonExpired = true;
    @Column(nullable = false)
    private boolean accountNonLocked = true;
    @Column(nullable = false)
    private boolean credentialsNonExpired = true;
    @Column(nullable = false)
    private boolean enabled = true;

}
