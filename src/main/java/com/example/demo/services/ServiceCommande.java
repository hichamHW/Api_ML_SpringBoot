package com.example.demo.services;

import com.example.demo.Repo.RepCommande;
import com.example.demo.models.commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCommande {
    @Autowired
    private RepCommande RC;

    public  Boolean insertCommande(commande commande){
        try{
            RC.save(commande);
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    public List<commande> showCommandes(){
        try{
            return  RC.findAll();
        }catch (Exception e){
            return null;
        }
    }
    public  commande showCommandeById(Integer Id){
        try{
            return  RC.findById(Id).get();
        }catch (Exception e){
            return null;
        }
    }
    public  commande showCommandeByReference(String ref){
        try{
            return  RC.findByRefernce(ref);
        }catch (Exception e){
            return null;
        }
    }

}
