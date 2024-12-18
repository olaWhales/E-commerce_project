package org.example.data.repositories.goods;

import org.example.data.model.goods.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
//    boolean findById(String id);
    Optional<Product> findById(Long productId);
    List<Product> findByid(Long productId);
    List<Product> findProductBySellerId( Long seller_id);
}
