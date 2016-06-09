package com.NoteOrganizer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Justins PC on 5/22/2016.
 */
public interface NoteRepository extends CrudRepository<Note,Integer> {
//    @Query("SELECT g FROM Notes g WHERE g.noteSubject LIKE ?1%")
//    List<Note> findBySubject(String noteSubject);
//    List<Note> findByTag(String noteTag);
//    List<Note>fineByUser(User user);

}