package com.speedment.jpastreamer.demo.entity;

import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "film")
@Getter
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", nullable = false, updatable = false, columnDefinition = "smallint(5)")
    private Integer filmId;

    @Column(name = "title", nullable = false, columnDefinition = "varchar(255)")
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "text")
    private String description;

    @ManyToOne
    @JoinColumn(name="language_id", nullable = false)
    private Language language;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "film_actor",
            joinColumns = { @JoinColumn(name = "film_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id") }
    )
    private List<Actor> actors = new ArrayList<>();

    @Column(name = "rental_duration", columnDefinition = "smallint(5)")
    private Integer rentalDuration;

    @Column(name = "rental_rate", columnDefinition = "decimal(4,2)")
    private Float rentalRate;

    @Column(name = "length", columnDefinition = "smallint(5)")
    private Integer length;

    @Column(name = "replacement_cost", columnDefinition = "decimal(5,2)")
    private Float replacementCost;

    @Column(name = "rating", columnDefinition = "enum('G','PG','PG-13','R','NC-17')")
    private String rating;

    @Column(name = "special_features", columnDefinition = "set('Trailers','Commentaries','Deleted Scenes','Behind the Scenes')")
    private String specialFeatures;

    @Column(name = "last_update", nullable = false, columnDefinition = "timestamp")
    private LocalDateTime lastUpdate;
}
