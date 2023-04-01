package io.github.WegielWBucie.Notes.Adapter;

import io.github.WegielWBucie.Notes.Model.NoteGroup;
import io.github.WegielWBucie.Notes.Model.NoteGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface SQLNoteGroupRepository extends NoteGroupRepository, JpaRepository<NoteGroup, Long> {

    @Override
    @Query("select distinct g from NoteGroup g join fetch g.notes")
    List<NoteGroup> findAll();
    /* inner join by default */

    @Override
    boolean existsByProjectID(Long projectID);

}
