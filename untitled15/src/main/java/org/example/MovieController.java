package org.example;

import org.example.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.Repositories.MovieRepository;

import java.util.List;




@RestController
@RequestMapping("/Movie")
public class MovieController {

    @GetMapping("/home")
    public String home() {
        return "Hello, Spring Boot!";
    }

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/")
    public List<Movie> list() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie get(@PathVariable String id) {
        return movieRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    public Movie create(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable String id, @RequestBody Movie movie) {
        // Additional code for updating and handling LastModified attribute
        return movieRepository.save(movie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        movieRepository.deleteById(id);
    }
}