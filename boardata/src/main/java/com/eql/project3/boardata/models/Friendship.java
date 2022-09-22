package com.eql.project3.boardata.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "friendship")
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

    @Temporal(javax.persistence.TemporalType.DATE)
    Date date;

    @Column(nullable = false)
    boolean active;
}
