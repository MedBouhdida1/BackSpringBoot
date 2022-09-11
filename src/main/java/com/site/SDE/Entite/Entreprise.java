package com.site.SDE.Entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Entity
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String mdp;
    private String email;
    private int etat;
    private String localisation;
    private String site;
    @Lob
    private String logo;
    private String date;
    private String numeroTel;
    @OneToMany(mappedBy = "entreprise")
    @JsonProperty

    private List<Offres> offre;

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getMdp() {
        return mdp;
    }

    public String getEmail() {
        return email;
    }

    public int getEtat() {
        return etat;
    }

    public String getLocalisation() {
        return localisation;
    }

    public String getSite() {
        return site;
    }

    public String getLogo() {
        return logo;
    }

    public String getDate() {
        return date;
    }

    public String getNumeroTel() {
        return numeroTel;
    }
    @JsonManagedReference

    public List<Offres> getOffre() {
        return offre;
    }
}
