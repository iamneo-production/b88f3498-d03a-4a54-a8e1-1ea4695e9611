package com.example.springapp.recommendedFood;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecommendedFoodModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    /**
     * @param id
     * @param userId
     * @param noOfItems
     * @param foodName
     */
    public RecommendedFoodModel(long id, long userId, int noOfItems, String foodName) {
        this.id = id;
        this.userId = userId;
        this.noOfItems = noOfItems;
        this.foodName = foodName;
    }
    /**
     * 
     */
    public RecommendedFoodModel() {
    }
    private long userId;
    private int noOfItems;
    private String foodName;
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * @return the userId
     */
    public long getUserId() {
        return userId;
    }
    /**
     * @param userId the userId to set
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }
    /**
     * @return the noOfItems
     */
    public int getNoOfItems() {
        return noOfItems;
    }
    /**
     * @param noOfItems the noOfItems to set
     */
    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }
    /**
     * @return the foodName
     */
    public String getFoodName() {
        return foodName;
    }
    /**
     * @param foodName the foodName to set
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
   
}
