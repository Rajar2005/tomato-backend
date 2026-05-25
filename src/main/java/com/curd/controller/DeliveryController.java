package com.curd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.curd.model.DeliveryInfo;
import com.curd.service.DeliveryService;

@RestController
@RequestMapping("/api/delivery")
@CrossOrigin(origins = "*")
public class DeliveryController {

	@Autowired
    private DeliveryService deliveryService;

	@PostMapping("/place-order")
	public DeliveryInfo placeOrder(@RequestBody DeliveryInfo info) {
	    return deliveryService.saveDeliveryInfo(info);
	}
}



