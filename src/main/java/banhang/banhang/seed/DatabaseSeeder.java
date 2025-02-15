package banhang.banhang.seed;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import banhang.banhang.DAO.CategoryDAO;
import banhang.banhang.entity.Category;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    CategoryDAO categoryDAO;

    @Override 
    public void run(String... args){
        System.out.println("Bắt đầu tạo dữ liệu mẫu!!!!");
        if( categoryDAO.count() == 0 ){
            List<Category>  list = List.of(
                new Category(null, "Category 1",  "Category 1 description"),
                new Category(null, "Category 2",  "Category 2 description"),
                new Category(null, "Category 3",  "Category 3 description"),
                new Category(null, "Category 4",  "Category 4 description")
            );
            categoryDAO.saveAll(list);
        }
        System.out.println("Kết thúc tạo liệu mẫu!!!!");
    } 
}
