package com.odk.connect.service.impl;

import com.odk.connect.model.Reponse;
import com.odk.connect.repository.ReponseRepository;
import com.odk.connect.service.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReponseServiceImpl implements ReponseService {


    ReponseService reponseService;


    @Autowired
    private ReponseRepository reponseRepository;

    @Override
    public Reponse ajouterReponse(Reponse reponse){
        return reponseRepository.save(reponse);

    }

    @Override
    public Void supprimerReponse(Long id) {
        return null;
    }
}
