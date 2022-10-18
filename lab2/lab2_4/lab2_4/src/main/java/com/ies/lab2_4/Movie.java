package com.ies.lab2_4;

import java.util.ArrayList;

public class Movie {

	private final long id;
    private final String name;
	private final ArrayList<String> quotes;

	public Movie(long id, String name, String content) {
        this.name = name;
		this.id = id;
		this.quotes = new  ArrayList<String>();
        this.quotes.add(content);
	}

    public void addQuote(String content){
        quotes.add(content);
    }

	public long getId() {
		return id;
	}

	public String randomQuote() {
  // generating the index using Math.random() 
        int index = (int)(Math.random() * quotes.size()); 
        return quotes.get(index);
	}

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name: " + name + " id: " + id ;
    }
}
