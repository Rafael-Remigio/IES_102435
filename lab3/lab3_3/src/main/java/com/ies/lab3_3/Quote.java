package com.ies.lab3_3;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Quote")
public class Quote {


    @ManyToOne
    @JoinColumn(name="movie", nullable=false)
    private  Movie movie;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    
    @Column(name = "value", nullable = false)
    private String value;


    public Quote(){

    }

    public Quote(Movie movie, String value) {
        this.movie = movie;
        this.value = value;
    }


    public Movie getMovie() {
        return movie;
    }



    public long getId() {
        return id;
    }


    public String getValue() {
        return value;
    }


    @Override
    public String toString() {
        return "Quote [movie=" + movie + ", id=" + id + ", value=" + value + "]";
    }

    

    

}