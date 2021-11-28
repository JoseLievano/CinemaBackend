package com.cinema.cinemabe.models.entity.theater;

import com.cinema.cinemabe.models.entity.movie.ShowTime;
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
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String name;

    @Column(nullable = false)
    private Boolean isASeat;

    @ManyToMany(mappedBy = "zones", cascade = CascadeType.PERSIST)
    private List<ShowTime> showTimes;


    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

}
