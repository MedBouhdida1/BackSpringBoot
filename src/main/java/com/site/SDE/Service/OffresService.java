package com.site.SDE.Service;

import com.site.SDE.Entite.Offres;

import java.util.List;
import java.util.Optional;

public interface OffresService {

    Offres ajouterOffre(Offres offre);
    Offres modifierOffre(Offres offre);
    List<Offres>lstOffres();
    Optional<Offres>getOffreById(Long id);
    List<Offres>getOffreByEtat(int etat);

    void supprimerOffre(Long id);
}
