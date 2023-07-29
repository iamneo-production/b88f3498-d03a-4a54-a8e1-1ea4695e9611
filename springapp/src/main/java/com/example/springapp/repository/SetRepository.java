package com.example.springapp.repository;

import java.util.Optional;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.springapp.model.Set;


public interface SetRepository extends CrudRepository<Set,Long>{

    Optional<Set> getSetById(Long id);

    Iterable<Set> getSetByExerciseId(long e_id);

    Set deleteSetById(long id);

    Set findById(long id);

    List<Set> findByExerciseId(Long exerciseId);

}



