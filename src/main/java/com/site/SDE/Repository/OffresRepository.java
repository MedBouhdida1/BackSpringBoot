package com.site.SDE.Repository;

import com.site.SDE.Entite.Offres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OffresRepository extends JpaRepository<Offres,Long> {
    List<Offres> findByEtat(int etat);
}
