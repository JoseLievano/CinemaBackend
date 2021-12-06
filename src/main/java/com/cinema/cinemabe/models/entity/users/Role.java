package com.cinema.cinemabe.models.entity.users;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String authority;

    @OneToMany(mappedBy = "role", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<User> users;

    //Add user to this role
    public void addUser(User user){
        this.users.add(user);
    }

    //Add a list of users
    public void addListUsers(List<User> users){
        this.users.addAll(users);
    }

}
