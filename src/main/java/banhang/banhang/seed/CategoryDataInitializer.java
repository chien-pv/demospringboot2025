package banhang.banhang.seed;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import banhang.banhang.DAO.CategoryDAO;
import banhang.banhang.entity.Category;

@Component
public class CategoryDataInitializer implements CommandLineRunner {
    private final CategoryDAO categoryRepository;
    public CategoryDataInitializer(CategoryDAO categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) {
        // if (categoryRepository.count() == 0) { // Tránh chèn dữ liệu trùng lặp
        //     List<Category> categories = List.of(
        //         new Category("Category 1"),
        //         new Category("Category 2"),
        //         new Category("Category 3")
        //     );

        //     categoryRepository.saveAll(categories);
        //     System.out.println("Sample categories inserted!");
        // }
    }
}
