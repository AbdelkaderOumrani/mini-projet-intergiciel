package com.esi.mscommandscolarite.entities;

import com.esi.mscommandscolarite.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
