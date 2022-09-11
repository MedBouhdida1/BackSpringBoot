package com.site.SDE.Entite;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


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
    private String salaire;
    private String type;
    private int etat;
    private Long nbrPersonnes;
    private String niveau;
    private String datePub;
    private String dateExpir;
    private String genre;
    private String langue;
    private String description;
    private String requirements;
    private String experience;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;

    //
    @ManyToMany(mappedBy = "offre",cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<Formateur> formateur;
    //

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getSalaire() {
        return salaire;
    }

    public String getType() {
        return type;
    }

    public int getEtat() {
        return etat;
    }

    public Long getNbrPersonnes() {
        return nbrPersonnes;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getDatePub() {
        return datePub;
    }

    public String getDateExpir() {
        return dateExpir;
    }

    public String getGenre() {
        return genre;
    }

    public String getLangue() {
        return langue;
    }

    public String getDescription() {
        return description;
    }

    public String getRequirements() {
        return requirements;
    }

    public String getExperience() {
        return experience;
    }
    @JsonBackReference
    public Entreprise getEntreprise() {
        return entreprise;
    }

    //
    public List<Formateur> getFormateur() {
        return formateur;
    }
    //
}
