package com.eql.project3.boardata.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "round")
@Getter
@Setter
public class Round {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate matchDate;

    @OneToMany(mappedBy = "round")
    private List<Result> results = new ArrayList<>();

    @ManyToOne
    @JoinColumn (name = "game_id")
    private Game game;

}
