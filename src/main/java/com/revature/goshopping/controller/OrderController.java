package com.revature.goshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.goshopping.dto.Order;


import java.util.*;

@RestController
@RequestMapping("/order")
public class OrderController {

	@RequestMapping(value="", method= RequestMethod.GET)
	public List<Order> getOrders(){
		List<Order> orders = new ArrayList<>();
		//orders.add(new Order(1,));
		return orders;
	}
	@RequestMapping(value="", method=RequestMethod.POST)
	public Order postOrder(@RequestBody Order order) {
		try {
			return null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value="{id}", method=RequestMethod.POST)
	public Order getOrder(@PathVariable("id") int id) {
		
		return null;
	}
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public Order deleteOrder(@PathVariable("id") int id) {
		return null;
	}
}
