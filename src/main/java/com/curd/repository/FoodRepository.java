package com.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curd.model.Food;


public interface FoodRepository extends JpaRepository<Food, Long>{

}
