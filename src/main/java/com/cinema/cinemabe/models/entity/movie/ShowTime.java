package com.cinema.cinemabe.models.entity.movie;

import com.cinema.cinemabe.models.entity.theater.Theater;
import com.cinema.cinemabe.models.entity.theater.Zone;
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
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private Date startTime;

    @Column
    private Date endTime;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "show_time_zones",
            joinColumns = @JoinColumn(name = "show_time_id"),
            inverseJoinColumns = @JoinColumn(name = "zones_id"))
    private List<Zone> zones;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
