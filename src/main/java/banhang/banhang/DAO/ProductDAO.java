package banhang.banhang.DAO;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import banhang.banhang.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Long>  {

    @Query(name = "findByK")
    List<Product> findByQuantity(Integer x);

    // List<Product> findAll(Pageable pageable);
    List<Product> findByQuantityLessThan(Integer quantity);

    List<Product> findByQuantityBetween(Integer min, Integer max);

    List<Product> findByPriceLessThanAndNameContaining(Integer price, String name);
}
