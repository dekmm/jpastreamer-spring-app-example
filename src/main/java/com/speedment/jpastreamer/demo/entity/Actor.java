package com.speedment.jpastreamer.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actor")
@Data
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false, updatable = false, columnDefinition = "smallint(5)")
    private Integer actorId;

    @Column(name = "first_name", nullable = false, columnDefinition = "varchar(45)")
    private String firstName;

    @Column(name = "last_name", nullable = false, columnDefinition = "varchar(45)")
    private String lastName;

    @ManyToMany(mappedBy = "actors")
    private List<Film> films = new ArrayList<>();
}
