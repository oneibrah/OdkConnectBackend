package com.odk.connect.service;

import com.odk.connect.model.Reponse;

public interface ReponseService {

    public Reponse ajouterReponse(Reponse reponse);
    public Void supprimerReponse(Long id);
}
