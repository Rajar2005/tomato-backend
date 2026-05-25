package com.curd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.curd.model.DeliveryInfo;
import com.curd.repository.DeliveryInfoRepository;

@Service
public class DeliveryService {

	 @Autowired
	    private DeliveryInfoRepository deliveryInfoRepository;

	 public DeliveryInfo saveDeliveryInfo(DeliveryInfo info) {
	        // total calculate panna
	        double deliveryFee = info.getSubtotal() == 0 ? 0 : 2;
	        info.setDeliveryFee(deliveryFee);
	        info.setTotal(info.getSubtotal() + deliveryFee);
	        return deliveryInfoRepository.save(info); // DB la store pannum
	    }
}
