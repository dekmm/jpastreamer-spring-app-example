package com.speedment.jpastreamer.demo.service;

import static java.util.stream.Collectors.toList;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.speedment.jpastreamer.demo.entity.Film;
import com.speedment.jpastreamer.demo.entity.Film$;
import com.speedment.jpastreamer.demo.exception.ActorNotFoundException;
import com.speedment.jpastreamer.demo.viewmodel.FilmViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    private final JPAStreamer jpaStreamer;

    @Autowired
    public FilmService(final JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }

    public List<FilmViewModel> list(int page, int pageSize) {
        return jpaStreamer.stream(Film.class)
            .skip(page * pageSize)
            .limit(pageSize)
            .map(FilmViewModel::from)
            .collect(toList());
    }

    public FilmViewModel get(int id) {
        final Film film = jpaStreamer.stream(Film.class).filter(Film$.filmId.equal(id)).findFirst()
                .orElseThrow(() -> new ActorNotFoundException(id));

        return FilmViewModel.from(film);
    }
}
