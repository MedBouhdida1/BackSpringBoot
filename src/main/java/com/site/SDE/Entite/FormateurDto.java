package com.site.SDE.Entite;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class FormateurDto   {
    private  Long id;
    private  String nom;
    private  String prenom;
    private  String numeroTel;
    private  String email;
    private  String mdp;
    private  String photo;
    private  String cv;
    private  List<Offres> offre;
}
