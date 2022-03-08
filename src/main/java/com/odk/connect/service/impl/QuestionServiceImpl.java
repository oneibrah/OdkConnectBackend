package com.odk.connect.service.impl;

import com.odk.connect.model.Question;
import com.odk.connect.repository.QuestionRepository;
import com.odk.connect.service.QuestionService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuestionServiceImpl implements QuestionService {


    @Autowired
    private QuestionRepository questionRepository;

    public Question ajouterQuestion(Question question){
        return questionRepository.save(question);}

    @Override
    public Void supprimerQuestion(Long id) {
        return null;
    }
}


