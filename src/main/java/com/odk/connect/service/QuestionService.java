package com.odk.connect.service;

import com.odk.connect.model.Question;
import jdk.jfr.Category;
import org.springframework.stereotype.Service;


@Service
public interface QuestionService {

    public Question ajouterQuestion(Question question);
    public Void supprimerQuestion(Long id);
}
