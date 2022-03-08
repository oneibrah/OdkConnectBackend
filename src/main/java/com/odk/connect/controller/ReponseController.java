package com.odk.connect.controller;


import com.odk.connect.model.Reponse;
import com.odk.connect.repository.ReponseRepository;
import com.odk.connect.service.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/odkConnect/reponse/")
public class ReponseController {

    @Autowired
    ReponseService reponseService;


    @PostMapping("ajouter")
    Reponse ajouter(@RequestBody Reponse reponse) {
        return reponseService.ajouterReponse(reponse);
    }
    @DeleteMapping("supprimer/{id}")
    Void supprimer(@PathVariable("id") Long id){
        return reponseService.supprimerReponse(id);}



}
