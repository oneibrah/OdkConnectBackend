package com.odk.connect.service;

import com.odk.connect.model.Question;
import jdk.jfr.Category;

public interface QuestionService {

    public Question ajouterQuestion(Question question);
    public Void supprimerQuestion(Long id);
}
