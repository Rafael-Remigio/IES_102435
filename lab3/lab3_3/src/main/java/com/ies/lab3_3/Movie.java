package com.ies.lab3_3;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private  long id;



    @Column(name = "title", nullable = false)
    private  String title;


    @Column(name = "year", nullable = false)
    private  int year;


    


    @OneToMany(mappedBy="movie")
    private Set<Quote> quotes = new HashSet<Quote>();

    public Movie(){

    }

	public Movie(String title, int year) {

        this.title = title;
        this.year = year;

	}

        public long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }


	public Quote randomQuote() {
  // generating the index using Math.random() 
        int index = (int)(Math.random() * quotes.size()); 
        return (Quote) quotes.toArray()[index];
	}


    public Set<Quote> getQuotes(){
        return quotes;
    }


    public void addQuote(Quote content){
        quotes.add(content);
    }



    public int getYear() {
        return year;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public void setYear(int year) {
        this.year = year;
    }

    public void setQuote(Quote  quote){
        this.quotes.add(quote);
    }



    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "{ name: " + title + " id: " + id + " }";
    }
}

