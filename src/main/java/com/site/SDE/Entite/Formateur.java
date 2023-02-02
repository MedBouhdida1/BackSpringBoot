package com.site.SDE.Entite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Formateur {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String nom;
    private String prenom;
    private String numeroTel;
    private String email;
    private String mdp;
    @Lob
    private String photo;
    @Lob
    private String cv;
    //
    @ManyToMany
    @JoinTable(name = "Postulation",
    joinColumns = {@JoinColumn(name = "formateur_id")},
    inverseJoinColumns = {@JoinColumn(name = "offre_id")})
    private List<Offres> offre;
    //


}
