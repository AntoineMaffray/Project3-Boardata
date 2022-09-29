package com.eql.project3.boardata.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    private String name;

    private boolean typeCalc;

    @OneToMany(mappedBy = "game")
    private List<Round> rounds = new ArrayList<>();
}
