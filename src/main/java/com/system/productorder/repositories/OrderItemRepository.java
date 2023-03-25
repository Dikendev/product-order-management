package com.system.productorder.repositories;

import com.system.productorder.entities.OrderItem;
import com.system.productorder.entities.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}
