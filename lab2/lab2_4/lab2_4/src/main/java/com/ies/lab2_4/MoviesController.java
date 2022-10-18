package com.ies.lab2_4;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MoviesController {
    public List<Movie> filmes = new ArrayList<Movie>();


    public MoviesController(){
        Movie filme1 = new Movie(0, "Monty Python and the Holy Grail", "It's just a flesh wound.");
        filme1.addQuote("I fart in your general direction. Your mother was a hamster and your father smelled of elderberries!");
        filme1.addQuote("Oh! Now we see the violence inherent in the system! Help, help, I'm being repressed!");
        filme1.addQuote("On second thought, let's not go to Camelot. It is a silly place");
        filme1.addQuote("Are you suggesting coconuts migrate?");

        Movie filme2 = new Movie(1, "Monty Python The Meaning of Life", "We interrupt this program to annoy you and make things generally more irritating.");
        filme2.addQuote("But despite the efforts of Protestants to promote the idea of sex for pleasure, children continue to multiply everywhere.");
        filme2.addQuote("Is it a boy or a girl?, asks the new mother… To which the obstetrician answers: I think it's a bit early to start imposing roles on it, don't you?");
        
        Movie filme3 = new Movie(2, "Monty Python’s Flying Circus", "It is my belief that these sheep are labouring under the misapprehension that they're birds.");
        filme3.addQuote("We use only the finest baby frogs, dew picked and flown from Iraq, cleansed in finest quality spring water, lightly killed, and then sealed in a succulent Swiss quituple smooth treble cream milk chocolate envelope and lovingly frosted with glucose.");
        filme3.addQuote("Nobody expects the Spanish Inquisition!");
        
        filmes.add(filme1);
        filmes.add(filme2);
        filmes.add(filme3);
    }


  @GetMapping("/movies")
  public List<String> getQuote() {
    List<String> local = new ArrayList<String>(); 
    for (Movie movie : filmes) {
        local.add(movie.toString());
    };
    return local;
  }


  @GetMapping("/quote")
  public String getRandomQuote() {
    // random number from 0 to the size of the list
    int random = (int) (Math.random() * filmes.size());
    // return the random quote
    return filmes.get(random).randomQuote();
  }


  @GetMapping("/showQuote")
  public String getRandomQuotefromShow(@RequestParam Integer show_id) {
    // random number from 0 to the size of the list
    Movie local = filmes.get(0);
    for (Movie movie : filmes) {
        if (movie.getId() == show_id){
            local = movie;
        }
    }
    // return the random quote

    return local.randomQuote();

    }


}
