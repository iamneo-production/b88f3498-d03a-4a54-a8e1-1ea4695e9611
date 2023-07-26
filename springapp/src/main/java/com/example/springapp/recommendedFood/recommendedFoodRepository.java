package com.example.springapp.recommendedFood;

import org.springframework.data.repository.CrudRepository;

public interface recommendedFoodRepository extends CrudRepository<RecommendedFoodModel, Long>{

    Iterable<RecommendedFoodModel> findAllById(long id);

    Iterable<RecommendedFoodModel> findAllByUserId(long userId);
    
}
