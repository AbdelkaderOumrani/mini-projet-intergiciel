package com.esi.msqueryview.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface EtudiantViewRepositoryE extends JpaRepository<EtudiantViewE,Long> {
}
