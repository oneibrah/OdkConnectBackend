package com.odk.connect.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

public class Userpromo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long Id;
    private  String Libelle;
    private LocalDate dateFin;
    private LocalDate dateDebut;


    @ManyToOne
    private User user;
    @ManyToOne
    private  Promotion promotion;

}
