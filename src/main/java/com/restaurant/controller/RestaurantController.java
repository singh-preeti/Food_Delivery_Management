package com.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.model.Restaurant;
import com.restaurant.service.RestaurantService;




@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/resturant")
@RestController
public class RestaurantController {
	
	private RestaurantService restService;
	
	@Autowired
	public void setEmployeeService(RestaurantService prodService) {
		this.restService = restService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Restaurant>> getAll() {
		return ResponseEntity.ok(restService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> findById(@PathVariable Long id) {
		return ResponseEntity.ok(restService.findById(id).orElse(null));
	}
	
	@PostMapping("/")
	public ResponseEntity<Restaurant> add(@RequestBody Restaurant rest) {
		return ResponseEntity.ok(restService.save(rest));
	}
	
	@PutMapping("/")
	public ResponseEntity<Restaurant> update(@RequestBody Restaurant rest) {
		return ResponseEntity.ok(restService.save(rest));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Restaurant> delete(@PathVariable Long id) {
		restService.findById(id).ifPresent(restService::delete);
		return ResponseEntity.ok().build();
	}
}