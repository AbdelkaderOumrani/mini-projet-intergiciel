package com.esi.mscommandscolarite.entities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScolariteRepository extends JpaRepository<Etablissement, String> {
}
