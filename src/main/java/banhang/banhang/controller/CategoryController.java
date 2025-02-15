package banhang.banhang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import banhang.banhang.entity.Category;
import banhang.banhang.service.CrudCategory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    CrudCategory crudCategory;

    @GetMapping("")
    public String index(Model model) {
        List<Category> list = crudCategory.getAllData();
        model.addAttribute("categories", list);
        return "category/index";
    }

    @PostMapping("create")
    public String create(Model model, @RequestParam("name") String name, @RequestParam("description") String description) {
        crudCategory.createData(name, description);
        return "redirect:/categories";
    }
    
    
}
