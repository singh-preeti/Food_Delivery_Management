package com.restaurant.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.restaurant.model.Restaurant;

@Service
public interface RestaurantService extends JpaRepository<Restaurant,Long> {

}
