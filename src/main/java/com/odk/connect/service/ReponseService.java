package com.odk.connect.service;

import com.odk.connect.model.Reponse;
import org.springframework.stereotype.Service;


@Service
public interface ReponseService {

    public Reponse ajouterReponse(Reponse reponse);
    public Void supprimerReponse(Long id);
}
