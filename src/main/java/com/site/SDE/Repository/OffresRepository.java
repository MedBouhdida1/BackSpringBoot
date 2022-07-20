package com.site.SDE.Repository;

import com.site.SDE.Entite.Offres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OffresRepository extends JpaRepository<Offres,Long> {
}
