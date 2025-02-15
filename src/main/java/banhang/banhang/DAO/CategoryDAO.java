package banhang.banhang.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import banhang.banhang.entity.Category;

public interface CategoryDAO extends JpaRepository<Category, Long> {
}
