package com.eql.project3.boardata.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "round_id")
    Round round;

    private int score;

    private String wonder;

    @OneToOne
    @JoinColumn (name = "nature_id", referencedColumnName = "natureId")
    private Nature nature;

}
