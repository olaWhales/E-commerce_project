package org.example.data.repositories.goods;

import org.example.data.model.goods.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
