package com.NoteOrganizer;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Justins PC on 5/23/2016.
 */
public interface UserRepository extends CrudRepository<User,Integer>{
    User findByEmail(String userEmail);
}
