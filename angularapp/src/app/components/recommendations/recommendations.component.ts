import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { TitleService } from 'src/app/services/title.service';
import { TokenService } from 'src/app/services/token.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-recommendations',
  templateUrl: './recommendations.component.html',
  styleUrls: ['./recommendations.component.scss']
})
export class RecommendationsComponent implements OnInit {

  moreCalorie: boolean = false;

  constructor(private titleService: TitleService, private userService: UserService, private tokenService: TokenService, private http: HttpClient) {
    this.titleService.setTitle("Recommendations");
  }

  receiveVariable(variable: number) {
    this.calorieAdded = variable;
    if (this.calorieAdded > this.maxRequiredCalories) {
      alert("You are taking more calories");
      this.moreCalorie = true;
    } else {
      this.moreCalorie = false;
    }
  }
  calorieAdded: number = 0;
  UserGender!: string;
  BMR: number = 0;
  userCalorie: number = 2000;
  activity_factor: number = 1.2;
  UserAge: number = 2;
  openClicked = false;
  setCustomClicked = false;
  maxRequiredCalories!: number;
  minRequiredCalories!: number;
  saved: boolean = false;
  UserWeight!: number;
  UserId!: any;
  ngOnInit(): void {

    this.userService.userSubject.subscribe((userData: any) => {
      this.UserGender = userData.gender;
      this.UserAge = userData.age;
      this.UserWeight = userData.weight;

      this.UserId = userData.id;
      //to get the max and min calorie required from table
      this.requiredCalorieRange.forEach(value => {
        if (userData.age >= value.range.min_age && userData.age <= value.range.max_age) {
          if (userData.gender == "Male") {
            this.maxRequiredCalories = value.male_calorie_range.max_cal;
            this.minRequiredCalories = value.male_calorie_range.min_cal;
          } else if (userData.gender == "Female") {
            this.maxRequiredCalories = value.female_calorie_range.max_cal;
            this.minRequiredCalories = value.female_calorie_range.min_cal;

          }
          console.log(this.minRequiredCalories);
        }
      });

    })
    this.userCalorie = this.userService.getUserCalorie(this.UserWeight);
    console.log("user cal:" + this.userCalorie)

  }

  bagItemsRecieved: any[] = [];



  receivedBagItems(event: any) {
    this.deleteAllSaved();
    for (const item in event) {
      const key = item;
      const val = event[item];
      if (val > 0) {
        this.http.put(`${this.userService.baseUrl}/nutrition/addNutrition/${this.UserId}`, { noOfItems: val, foodName: key }, this.tokenService.getHeader()).subscribe(response => {
          console.log("bagItems: ", this.bagItemsRecieved);
        });
        this.bagItemsRecieved.push({ key: key, value: val })
      }

    }
  }
  savedNutrition!: any;
  showSavedNutritions: boolean = false;
  showSaved() {
    this.showSavedNutritions = !this.showSavedNutritions;
    this.http.get(`${this.userService.baseUrl}/nutrition/getNutrition/${this.UserId}`, this.tokenService.getHeader()).subscribe(listOfNutrition => {
      this.savedNutrition = listOfNutrition;
      console.log(listOfNutrition);

    })
  }

  deleteAllSaved() {
    this.http.delete(`${this.userService.baseUrl}/nutrition/deleteNutrition/${this.UserId}`, this.tokenService.getHeader()).subscribe(deleted => {
      this.savedNutrition = deleted;
    })
  }

  saveCustomNutrition() {
    if (this.calorieAdded < this.minRequiredCalories) {
      alert("Add atleast " + this.minRequiredCalories + " calorie to proceed");
      this.saved = true;
    } else if (this.calorieAdded > this.maxRequiredCalories) {
      alert("Maximum of " + this.maxRequiredCalories + " calorie can be added.");
      this.saved = true;
    }
    this.saved = !this.saved;


  }

  nutritions = {
    "macronutrients": [
      {
        "category": "Protein",
        "foods": [
          { "name": "Chicken breast", "serving_size": "3 ounces", "calories_per_serving": { 'min_cal': 165, 'max_cal': 190 } },
          { "name": "Turkey breast", "serving_size": "3 ounces", "calories_per_serving": { 'min_cal': 160, 'max_cal': 170 } },
          { "name": "Salmon", "serving_size": "3 ounces", "calories_per_serving": { 'min_cal': 280, 'max_cal': 350 } },
          { "name": "Eggs", "serving_size": "1 large egg", "calories_per_serving": { 'min_cal': 70, 'max_cal': 80 } },
          { "name": "Greek yogurt", "serving_size": "1 cup", "calories_per_serving": { 'min_cal': 100, 'max_cal': 150 } },
          { "name": "Cottage cheese", "serving_size": "1/2 cup", "calories_per_serving": { 'min_cal': 80, 'max_cal': 120 } },
          { "name": "Tofu", "serving_size": "1/2 cup", "calories_per_serving": { 'min_cal': 80, 'max_cal': 100 } },
          { "name": "Lentils", "serving_size": "1/2 cup", "calories_per_serving": { 'min_cal': 115, 'max_cal': 230 } },
          { "name": "Chickpeas", "serving_size": "1/2 cup", "calories_per_serving": { 'min_cal': 140, 'max_cal': 180 } }
        ]
      },
      {
        "category": "Carbohydrates",
        "foods": [
          { "name": "Brown rice", "serving_size": "1/2 cup cooked", "calories_per_serving": { 'min_cal': 108, 'max_cal': 115 } },
          { "name": "Quinoa", "serving_size": "1/2 cup cooked", "calories_per_serving": { 'min_cal': 111, 'max_cal': 125 } },
          { "name": "Oats", "serving_size": "1/2 cup dry", "calories_per_serving": { 'min_cal': 150, 'max_cal': 170 } },
          { "name": "Sweet potatoes", "serving_size": "1 medium potato", "calories_per_serving": { 'min_cal': 100, 'max_cal': 130 } },
          { "name": "Bananas", "serving_size": "1 medium banana", "calories_per_serving": { 'min_cal': 90, 'max_cal': 120 } },
          { "name": "Apples", "serving_size": "1 medium apple", "calories_per_serving": { 'min_cal': 80, 'max_cal': 100 } },
          { "name": "Berries (mixed)", "serving_size": "1 cup", "calories_per_serving": { 'min_cal': 50, 'max_cal': 80 } },
          { "name": "Broccoli", "serving_size": "1 cup", "calories_per_serving": { 'min_cal': 30, 'max_cal': 50 } },
          { "name": "Whole grain bread", "serving_size": "1 slice", "calories_per_serving": { 'min_cal': 70, 'max_cal': 90 } }
        ]
      },
      {
        "category": "Fats",
        "foods": [
          { "name": "Avocado", "serving_size": "1/4 avocado", "calories_per_serving": { 'min_cal': 60, 'max_cal': 100 } },
          { "name": "Almonds", "serving_size": "1/4 cup", "calories_per_serving": { 'min_cal': 160, 'max_cal': 180 } },
          { "name": "Chia seeds", "serving_size": "1 tablespoon", "calories_per_serving": { 'min_cal': 60, 'max_cal': 70 } },
          { "name": "Olive oil", "serving_size": "1 tablespoon", "calories_per_serving": { 'min_cal': 120, 'max_cal': 130 } },
          { "name": "Coconut oil", "serving_size": "1 tablespoon", "calories_per_serving": { 'min_cal': 120, 'max_cal': 130 } },
          { "name": "Salmon (fillet)", "serving_size": "3 ounces", "calories_per_serving": { 'min_cal': 280, 'max_cal': 350 } },
          { "name": "Peanut butter", "serving_size": "2 tablespoons", "calories_per_serving": { 'min_cal': 180, 'max_cal': 200 } },
          { "name": "Cheese (cheddar)", "serving_size": "1 ounce", "calories_per_serving": { 'min_cal': 110, 'max_cal': 120 } },
          { "name": "Full-fat Greek yogurt", "serving_size": "1 cup", "calories_per_serving": { 'min_cal': 140, 'max_cal': 180 } }
        ]
      }
    ]
  }

  requiredCalorieRange = [
    {
      'range': { 'min_age': 1, 'max_age': 3 },
      "age": "1-3 years old",
      "male_calorie_range": { 'min_cal': 1000, 'max_cal': 1400 },
      "female_calorie_range": { 'min_cal': 1000, 'max_cal': 1200 },
    },
    {
      'range': { 'min_age': 4, 'max_age': 8 },
      "age": "4-8 years old",
      "male_calorie_range": { 'min_cal': 1200, 'max_cal': 1800 },
      "female_calorie_range": { 'min_cal': 1200, 'max_cal': 1600 },
    },
    {
      'range': { 'min_age': 9, 'max_age': 13 },
      "age": "9-13 years old",
      "male_calorie_range": { 'min_cal': 1600, 'max_cal': 2200 },
      "female_calorie_range": { 'min_cal': 1400, 'max_cal': 2200 },
    },
    {
      'range': { 'min_age': 14, 'max_age': 18 },
      "age": "14-18 years old",
      "male_calorie_range": { 'min_cal': 2000, 'max_cal': 3200 },
      "female_calorie_range": { 'min_cal': 1800, 'max_cal': 2400 },
    },
    {
      'range': { 'min_age': 19, 'max_age': 30 },
      "age": "19-30 years old",
      "male_calorie_range": { 'min_cal': 2400, 'max_cal': 3000 },
      "female_calorie_range": { 'min_cal': 2000, 'max_cal': 2400 },
    },
    {
      'range': { 'min_age': 31, 'max_age': 50 },
      "age": "31-50 years old",
      "male_calorie_range": { 'min_cal': 2200, 'max_cal': 3000 },
      "female_calorie_range": { 'min_cal': 1800, 'max_cal': 2200 },
    },
    {
      'range': { 'min_age': 51, 'max_age': 200 },
      "age": "51+ years old",
      "male_calorie_range": { 'min_cal': 2000, 'max_cal': 2800 },
      "female_calorie_range": { 'min_cal': 1600, 'max_cal': 2200 },
    }
  ]


  proteinFoods: any[] = [];
  carbohydrateFoods: any[] = [];
  fatFoods: any[] = [];

  openFoodRecommendation() {
    // Arrays to store recommended foods for each category
    this.openClicked = !this.openClicked;

    // (25% protein, 55% carbohydrates, 20% fats 
    // Calculate the target amounts for each macronutrient
    let proteinCalories = this.maxRequiredCalories * 0.25;
    let carbohydrateCalories = this.maxRequiredCalories * 0.55;
    let fatCalories = this.maxRequiredCalories * 0.20;

    console.log("protien:" + proteinCalories);
    console.log("carb:" + carbohydrateCalories);
    console.log("fat:" + fatCalories);


    // Iterate through the macronutrients and find matching foods
    for (const macronutrient of this.nutritions.macronutrients) {
      if (macronutrient.category === 'Protein') {

        while (proteinCalories > 0) {
          for (const food of macronutrient.foods) {
            const minProtein = food.calories_per_serving.min_cal;
            if (minProtein <= proteinCalories) {
              this.proteinFoods.push(food);
            }
            proteinCalories -= minProtein;

          }
        }
        if (this.proteinFoods.length === 0) {
          this.proteinFoods.push(macronutrient.foods[0]); // Add a default food if no match found
        }
      } else if (macronutrient.category === 'Carbohydrates') {
        while (carbohydrateCalories > 0) {
          for (const food of macronutrient.foods) {
            const minCarbohydrates = food.calories_per_serving.min_cal;
            if (minCarbohydrates <= carbohydrateCalories) {
              this.carbohydrateFoods.push(food);
            }
            carbohydrateCalories -= minCarbohydrates;
          }
        }
        if (this.carbohydrateFoods.length === 0) {
          this.carbohydrateFoods.push(macronutrient.foods[0]); // Add a default food if no match found
        }
      } else if (macronutrient.category === 'Fats') {
        while (fatCalories > 0) {
          for (const food of macronutrient.foods) {
            const minFats = food.calories_per_serving.min_cal;
            if (minFats <= fatCalories) {
              this.fatFoods.push(food);
            }
            fatCalories -= minFats;
          }
        }
        if (this.fatFoods.length === 0) {
          this.fatFoods.push(macronutrient.foods[0]); // Add a default food if no match found
        }
      }
    }

    // Display the recommended foods to the user
    console.log('Recommended Protein Foods:', this.proteinFoods);
    console.log('Recommended Carbohydrate Foods:', this.carbohydrateFoods);
    console.log('Recommended Fat Foods:', this.fatFoods);




  }
  openCustomRecommendations() {
    this.setCustomClicked = !this.setCustomClicked;

    //open stored database of previous recommendations
  }


}