package com.site.SDE.Service;

import com.site.SDE.Entite.Entreprise;

import java.util.List;
import java.util.Optional;

public interface EntrepriseService {

    Entreprise ajouterEntreprise(Entreprise entreprise);
    Entreprise modifierEntreprise(Entreprise entreprise);
    List<Entreprise>listEntreprise();
    void supprimerEntreprise(Long id);
    Optional<Entreprise>getEntrepriseById(Long id);
    Entreprise getEntrepriseByEmail(String email);
    List<Entreprise>getEntrepriseByEtat(int etat);


}
