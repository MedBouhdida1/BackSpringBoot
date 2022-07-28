package com.site.SDE.Repository;

import com.site.SDE.Entite.Admin;
import com.site.SDE.Entite.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise,Long> {

    boolean existsByEmail(String email);
    Entreprise findEntrepriseByEmail(String email);

}
