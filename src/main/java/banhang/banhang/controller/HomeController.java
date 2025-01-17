package banhang.banhang.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import banhang.banhang.DAO.UserDAO;
import banhang.banhang.models.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("login") 
public class HomeController {
    @Autowired
    UserDAO userDAO;
    @Autowired 
    ServletContext context;

    @ResponseBody
    @GetMapping("")
    public List<User> index(Model model) {
        List<User> users =  userDAO.findAll();
        return users;
    }

    @ModelAttribute("q")
    public String showSearch(){
        return "Học JAVA";
    }

    @GetMapping("/form/{id}")
    public String form(Model model, @RequestParam("page") Optional<Integer> page, @CookieValue("JSESSIONID") String ssID, @ModelAttribute("id") String id) {
        model.addAttribute("message", "abc");
        return "login/login";
    }
    
    @PostMapping("/check")
    public String login(Model model,  @RequestPart("photo") MultipartFile photoFile, Staff bean) {
        String message;
        // if (bean.uname.equals("poly") && bean.pass.equals("123")) {
        //     message = "Đăng Nhập Thành Công!!!";
        // } else {
        //     message = "Đăng Nhập Thất bại!!!";
        // }

        if(!photoFile.isEmpty()){
            String dir = "/Users/phamvanchien/SpringBoot/banhang/photos/";
            String fileName = photoFile.getOriginalFilename();
            try {
                photoFile.transferTo(new File(dir, fileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("message", bean.uname);
        return "redirect:/login";
    }
    
   
}
