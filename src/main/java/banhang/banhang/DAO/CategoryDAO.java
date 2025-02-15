package banhang.banhang.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import banhang.banhang.entity.Category;

@Repository
public interface CategoryDAO extends JpaRepository< Category, Long> {
}
