package banhang.banhang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import banhang.banhang.DAO.CategoryDAO;
import banhang.banhang.entity.Category;

@Service
public class CrudCategory {
    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> getAllData(){
        return categoryDAO.findAll();
    }

    public void createData(String name, String description){
        Category category = new Category(null, name, description);
        categoryDAO.save(category);
    }
}
