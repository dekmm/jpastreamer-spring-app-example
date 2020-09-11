package com.speedment.jpastreamer.demo.rest;

import com.speedment.jpastreamer.demo.exception.ActorNotFoundException;
import com.speedment.jpastreamer.demo.service.FilmService;
import com.speedment.jpastreamer.demo.viewmodel.FilmViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping(value = "/films", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FilmViewModel> list(
        @RequestParam(required = false, defaultValue = "0") int page,
        @RequestParam(required = false, defaultValue = "10") int pageSize
    ) {
        return filmService.list(page, pageSize);
    }

    @GetMapping(value = "/films/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmViewModel get(@PathVariable("id") int id) {
        try {
            return filmService.get(id);
        } catch (ActorNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @GetMapping(value = "/films/{id}/actors", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> getActors(@PathVariable("id") int id) {
        try {
            return filmService.get(id).getActors();
        } catch (ActorNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
