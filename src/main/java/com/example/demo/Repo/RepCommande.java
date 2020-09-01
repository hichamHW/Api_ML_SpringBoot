package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import  com.example.demo.models.commande;
import org.springframework.stereotype.Repository;

@Repository
public interface RepCommande extends JpaRepository<commande,Integer> {
    public  commande findByRefernce(String reference);
}
