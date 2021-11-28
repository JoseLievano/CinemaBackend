package com.cinema.cinemabe.models.entity.movie;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String name;

    @Column
    private Integer durationSecs;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ShowTime> showTimes;



}
