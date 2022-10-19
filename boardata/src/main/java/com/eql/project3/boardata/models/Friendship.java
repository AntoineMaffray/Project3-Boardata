package com.eql.project3.boardata.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "friendship")
@Getter
@Setter
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long frienshipId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    User requester;


    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    User friend;

    LocalDate date;

    @Column(nullable = false)
    boolean active;
}
