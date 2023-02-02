package com.site.SDE.Repository;

import com.site.SDE.Entite.Admin;
import com.site.SDE.Entite.Entreprise;
import com.site.SDE.Entite.Offres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {

    boolean existsByEmail(String email);
    Entreprise findEntrepriseByEmail(String email);
    List<Entreprise> findByEtat(int etat);
    Entreprise findEntrepriseByOffreId(long id);



}
