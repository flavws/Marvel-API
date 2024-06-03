package br.com.marvel_api.controller;

import br.com.marvel_api.service.MarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/marvel")
public class MarvelController {

    @Autowired
    private MarvelService marvelService;

    @GetMapping("/comics")
    public ResponseEntity<String> getComics(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "title") String orderBy) {
        return ResponseEntity.ok(marvelService.fetchFromMarvel("comics", null, page, size, orderBy));
    }

    @GetMapping("/series")
    public ResponseEntity<String> getSeries(
            @RequestParam String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "title") String orderBy) {
        return ResponseEntity.ok(marvelService.fetchFromMarvel("series", null, page, size, orderBy));
    }

    @GetMapping("/superheroes")
    public ResponseEntity<String> getSuperheroes(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(marvelService.fetchFromMarvel("characters", name, page, size, "name"));
    }
}