package banhang.banhang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class HomeController {
    

    @Autowired 
    ServletContext context;
   
    @GetMapping("/")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        String q = request.getParameter("q");
        model.addAttribute("title", q);
        Cookie cookie  = new Cookie("aBC", "XYZ");
        response.addCookie(cookie);
        response.setHeader("abc", "abc");
        return "home/index";
    }

    @GetMapping("/login/form")
    public String form(Model model) {
        return "login/login";
    }
    
    @PostMapping("/login/check")
    public String login(Model model,  HttpServletRequest request) {
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");
        
        model.addAttribute("message", uname);
        return "login/login";
    }
    
   
}
