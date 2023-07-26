package com.example.springapp.recommendedFood;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class recommendedFoodController {

    @Autowired
    private recommendedFoodRepository foodRepository;

    @PostMapping("/addNutrition/{userId}")
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

}
