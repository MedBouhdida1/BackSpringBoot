package com.site.SDE.Entite;

import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

@Data
public class OffresDto    {
    private  Long id;
    private  String titre;
    private  String salaire;
    private  String type;
    private  int etat;
    private  Long nbrPersonnes;
    private  String niveau;
    private  String datePub;
    private  String dateExpir;
    private  String genre;
    private  String langue;
    private  String description;
    private  String requirements;
    private  String experience;
    private  Entreprise entreprise;
    private List<Formateur> formateur;


}
