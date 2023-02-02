package com.site.SDE.Repository;

import com.site.SDE.Entite.Admin;
import com.site.SDE.Entite.Formateur;
import com.site.SDE.Entite.Offres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur,Long> {

    boolean existsByEmail(String email);

    Formateur findFormateurByEmail(String email);
    List<Formateur>findFormateursByOffreId(Long id);
    boolean existsByOffre(Offres offre);
}
