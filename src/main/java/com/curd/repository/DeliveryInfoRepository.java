package com.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.curd.model.DeliveryInfo;

public interface DeliveryInfoRepository extends JpaRepository<DeliveryInfo, Long> {
}