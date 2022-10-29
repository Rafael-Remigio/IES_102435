package com.ies.lab3_3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private QuoteRepository quoteRepository;


    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable(value = "id") Long movieId)
        throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(movieId)
          .orElseThrow(() -> new ResourceNotFoundException("Movie not found for this id :: " + movieId));
        return ResponseEntity.ok().body(movie);
    }

    
    @PostMapping(path = "/movies", consumes = "application/json")
    public Movie createMovie(@Valid @RequestBody Movie filme) {
        return movieRepository.save(filme);
    }


    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") Long movieId,
         @Valid @RequestBody Movie movieDetails) throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(movieId)
        .orElseThrow(() -> new ResourceNotFoundException("Movie not found for this id :: " + movieId));

        movie.setTitle(movieDetails.getTitle());
        movie.setYear(movieDetails.getYear());
        final Movie updatedMovie = movieRepository.save(movie);
        return ResponseEntity.ok(updatedMovie);
    }

    
    @PostMapping("/movies/{id}/addQuote")
    public ResponseEntity<Movie> addQuote(@PathVariable(value = "id") Long movieId,
         @Valid @RequestBody Quote quote) throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(movieId)
        .orElseThrow(() -> new ResourceNotFoundException("Movie not found for this id :: " + movieId));

        movie.addQuote(quote);        
        quote.setMovie(movie);

        quoteRepository.save(quote);
        final Movie updatedmMovie = movieRepository.save(movie);
        return ResponseEntity.ok(updatedmMovie);
    }

    @DeleteMapping("/movies/{id}")
    public Map<String, Boolean> deleteMovie(@PathVariable(value = "id") Long movieId)
         throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(movieId)
       .orElseThrow(() -> new ResourceNotFoundException("Movie not found for this id :: " + movieId));

        movieRepository.delete(movie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    @GetMapping("/movieQuotes/{id}")
    public Object[] getMovieQuotes(@PathVariable(value = "id") Long movieId)
        throws ResourceNotFoundException {
        Movie movie = movieRepository.findById(movieId)
          .orElseThrow(() -> new ResourceNotFoundException("Movie not found for this id :: " + movieId));
        return movie.getQuotes().toArray();
    }



}