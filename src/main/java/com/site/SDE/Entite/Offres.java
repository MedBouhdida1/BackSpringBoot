package com.site.SDE.Entite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Offres {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String site;
    private String salaire;
    private String Localisation;
    private String type;
    private int etat;
    @Lob
    private String logo;
    private Long nbrPersonnes;
    private String niveau;
    private String datePub;
    private String dateExpir;
    private String genre;
    private String langue;
    private String description;

}
