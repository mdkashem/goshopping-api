package com.revature.goshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.revature.goshopping.dto.Auth;
import com.revature.goshopping.dto.Order;
import com.revature.goshopping.entity.OrderEntity;
import com.revature.goshopping.service.OrderService;
import com.revature.goshopping.utility.ControllerUtility;
import com.revature.goshopping.utility.JwtUtility;

import com.revature.goshopping.dto.Auth;
import com.revature.goshopping.dto.Order;
import com.revature.goshopping.entity.OrderEntity;
import com.revature.goshopping.service.OrderService;
import com.revature.goshopping.utility.ControllerUtility;
import com.revature.goshopping.utility.JwtUtility;

import java.util.*;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;
	@RequestMapping(value="", method= RequestMethod.GET)
	public ResponseEntity<List<Order>> getOrders(@RequestHeader Map<String, String> headers){
		Auth auth =JwtUtility.getAuth(headers);
		return ControllerUtility.handle(() -> orderService.getOrders(auth));
	}
	/**
	 * this posts an order to be recorded
	 * @param order
	 * @param headers
	 * @return
	 */
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<Order> postOrder(@RequestBody Order order, @RequestHeader Map<String, String> headers) {
		Auth auth = JwtUtility.getAuth(headers);
		return ControllerUtility.handle(() -> orderService.createOrder(auth, order) );
	}
	/**
	 * This returns the list of orders for a specific user
	 * @param id
	 * @param headers
	 * @return
	 */
	@RequestMapping(value="user/{id}", method=RequestMethod.POST)
	public ResponseEntity<List<Order>> getOrdersByUser(@PathVariable("id") int id, @RequestHeader Map<String, String> headers) {
		Auth auth = JwtUtility.getAuth(headers);
		return ControllerUtility.handle(() -> orderService.getOrders(auth, id));
	}
	
	@RequestMapping(value="order/{id}", method=RequestMethod.POST)
	public ResponseEntity<Order> getOrderById(@PathVariable("id") int id, @RequestHeader Map<String, String> headers) {
		return ControllerUtility.handle(() -> orderService.getOrder(id));
	}
}
