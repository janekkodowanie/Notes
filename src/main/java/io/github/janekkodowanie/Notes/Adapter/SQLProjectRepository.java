package io.github.janekkodowanie.Notes.Adapter;

import io.github.janekkodowanie.Notes.Model.Project;
import io.github.janekkodowanie.Notes.Model.ProjectRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SQLProjectRepository extends ProjectRepository, JpaRepository<Project, Long> {

    @Override
    @Query("select distinct p from Project p join fetch p.steps")
    List<Project> findAll();
}
