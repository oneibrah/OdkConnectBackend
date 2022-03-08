package com.odk.connect.controller;

import com.odk.connect.model.Question;
import com.odk.connect.repository.QuestionRepository;
import com.odk.connect.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/odkConnect/question/")
public class QuestionController {



    @Autowired
    QuestionService questionService;

    @PostMapping("ajouter")
    public Question ajouter(@RequestBody Question question){
        return questionService.ajouterQuestion(question);
    }
    @DeleteMapping("supprimer/{id}")
    Void supprimer(@PathVariable("id") Long id){
        return questionService.supprimerQuestion(id);}
}
