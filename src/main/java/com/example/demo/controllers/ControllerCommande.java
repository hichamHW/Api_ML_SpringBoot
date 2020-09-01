package com.example.demo.controllers;

import com.example.demo.models.commande;
import com.example.demo.services.ServiceCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
@RequestMapping(path = "api")
public class ControllerCommande {


    @Autowired
    private ServiceCommande SC;





    @GetMapping("test")
    @ResponseBody
    public String test() {
        return "Hicham BENHACHEM";
    }

    @GetMapping("commande/{Id}")
    @ResponseBody
    public ResponseEntity<commande> getCommandeById(@PathVariable("Id") Integer Id){
        System.out.println(Id);
        return new ResponseEntity<commande>(SC.showCommandeById(Id), HttpStatus.OK);
    }
    @GetMapping("commande/ref/{ref}")
    @ResponseBody
    public ResponseEntity<commande> getCommandeByRef(@PathVariable("ref") String ref){
        System.out.println(ref);
        return new ResponseEntity<commande>(SC.showCommandeByReference(ref), HttpStatus.OK);
    }

    @PostMapping("commande")
    @ResponseBody
    public ResponseEntity<Boolean>  insertCommande(){
        commande c = new commande();
        c.setRefernce("TR62692");
        c.setPrice(112);
        c.setDateCreation(new Date());
        c.setDateLivraison(new Date());
        c.setEtat("Creation");
        return new ResponseEntity<Boolean>(SC.insertCommande(c),HttpStatus.CREATED);
    }

}
