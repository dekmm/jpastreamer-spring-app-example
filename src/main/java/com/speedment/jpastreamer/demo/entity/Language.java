package com.speedment.jpastreamer.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "language")
@Data
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id", nullable = false, updatable = false, columnDefinition = "tinyint(3)")
    private Integer languageId;

    @Column(name = "name", nullable = false, columnDefinition = "char(20)")
    private String name;

    @OneToMany(mappedBy = "language")
    private Set<Film> films;
}
