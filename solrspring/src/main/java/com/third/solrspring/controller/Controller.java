package com.third.solrspring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.third.solrspring.model.Order;
import com.third.solrspring.repository.Repository;

@RestController
public class Controller {
	@Autowired
	private Repository orderRepository;
	
	/*@PostConstruct
	public void addOrder()
	{
		List<Order> order = new ArrayList<>();
		order.add(new Order(100,"Coke","MSD"));
		order.add(new Order(101,"Fanta","Virat"));
		orderRepository.saveAll(order);
	}
	*/
	
	@PostMapping("/order")
	 public String createOrder(@RequestBody Order order) {
	  String description = "Order Created";
	  orderRepository.save(order);
	  return description;
	 }
	
	 @GetMapping("/order/{orderid}")
	 public Order readOrder(@PathVariable Long orderid) {
		 System.out.println(orderid);
	  return orderRepository.findByOrderid(orderid);
	 }
	 
	 @DeleteMapping("/order/{orderid}")
	 public String deleteOrder(@PathVariable Long orderid) {
	  String description = "Order Deleted";
	  orderRepository.delete(orderRepository.findByOrderid(orderid));
	  return description;
	 }
	 
	 @GetMapping("/order/getAll")
	 public Iterable<Order> getOrders()
	 {
		 return orderRepository.findAll();
	 }

}
