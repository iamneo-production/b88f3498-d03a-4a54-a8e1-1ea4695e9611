package com.example.springapp.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.example.springapp.model.Set;


public interface SetRepository extends CrudRepository<Set,Long>{

    Optional<Set> getSetById(Long id);

    Iterable<Set> getSetByExerciseId(long e_id);

    void deleteSetById(long id);

}



