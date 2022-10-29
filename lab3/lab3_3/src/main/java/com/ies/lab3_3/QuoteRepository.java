package com.ies.lab3_3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuoteRepository extends JpaRepository<Quote, Long>{


    
  List<Quote> findById (String Id);

}