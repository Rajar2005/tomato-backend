package com.curd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.model.Food;
import com.curd.repository.FoodRepository;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    // GET ALL
    public List<Food> getAllFoods(){

        return foodRepository.findAll();
    }

    // ADD
    public Food addFood(Food food){

        return foodRepository.save(food);
    }

    // UPDATE
    public Food updateFood(Long id, Food food){

        Food existingFood =
                foodRepository.findById(id).orElse(null);

        if(existingFood != null){

            existingFood.setName(food.getName());
            existingFood.setDescription(food.getDescription());
            existingFood.setPrice(food.getPrice());
            existingFood.setCategory(food.getCategory());
            existingFood.setImage(food.getImage());

            return foodRepository.save(existingFood);
        }

        return null;
    }

    // DELETE
    public void deleteFood(Long id){

        foodRepository.deleteById(id);
    }
}