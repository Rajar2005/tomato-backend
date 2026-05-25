package com.curd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.curd.model.Food;
import com.curd.service.FoodService;

@RestController
@RequestMapping("/api/foods")
@CrossOrigin(origins = "http://localhost:5173")
public class FoodController {

    @Autowired
    private FoodService foodService;

    // GET ALL FOODS
    @GetMapping
    public List<Food> getFoods(){

        return foodService.getAllFoods();
    }

    // ADD FOOD
    @PostMapping
    public Food addFood(@RequestBody Food food){

        return foodService.addFood(food);
    }

    // UPDATE FOOD
    @PutMapping("/{id}")
    public Food updateFood(
            @PathVariable Long id,
            @RequestBody Food food){

        return foodService.updateFood(id, food);
    }

    // DELETE FOOD
    @DeleteMapping("/{id}")
    public String deleteFood(@PathVariable Long id){

        foodService.deleteFood(id);

        return "Food Deleted";
    }
}