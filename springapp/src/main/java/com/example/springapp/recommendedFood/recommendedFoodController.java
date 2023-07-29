package com.example.springapp.recommendedFood;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nutrition")
@Transactional
public class recommendedFoodController {

    @Autowired
    private recommendedFoodRepository foodRepository;

    @PutMapping("/addNutrition/{userId}")
    public ResponseEntity<String> saveFoodData(@PathVariable("userId") long userId,
            @RequestBody RecommendedFoodModel foodBody) {
        foodBody.setUserId(userId);
        foodRepository.save(foodBody);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getNutrition/{userId}")
    public Iterable<RecommendedFoodModel> getAllNutritionData(@PathVariable("userId") long userId) {
        return foodRepository.findAllByUserId(userId);

    }

    @DeleteMapping("/deleteNutrition/{userId}")
    public Iterable<RecommendedFoodModel> deleteAllNutritions(@PathVariable("userId") long userId){
        foodRepository.deleteAllByUserId(userId);
        Iterable<RecommendedFoodModel> newNutrition = foodRepository.findAllByUserId(userId);
        return newNutrition;
    }

}
