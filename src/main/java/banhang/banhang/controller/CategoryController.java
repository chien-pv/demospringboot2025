package banhang.banhang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import banhang.banhang.DAO.CategoryDAO;
import banhang.banhang.entity.Category;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping("")
    public String index(Model model) {
        List<Category> list =  categoryDAO.findAll();
        model.addAttribute("categories", list);
        return "categories/index";
    }

    @PostMapping("create")
    public String create(Model model, @RequestParam("name") String name ) {
        Category category = new Category();
        category.setName(name);
        categoryDAO.save(category);
        return "redirect:/categories";
    }
    
    
}
