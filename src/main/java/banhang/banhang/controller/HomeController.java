package banhang.banhang.controller;

import java.io.File;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping("login") 
public class HomeController {
    @Autowired 
    ServletContext context;
    @RequestMapping("")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        String q = request.getParameter("q");
        model.addAttribute("title", q);
        Cookie cookie  = new Cookie("aBC", "XYZ");
        response.addCookie(cookie);
        response.setHeader("abc", "abc");
        return "home/index";
    }

    @GetMapping("/form")
    public String form(Model model, @RequestParam("page") Optional<Integer> page) {
        
        int pg = page.orElse(0);

        model.addAttribute("message", pg);
        return "login/login";
    }
    
    @PostMapping("/check")
    public String login(Model model, @RequestParam("uname") String uname,  @RequestParam("pass") String pass, @RequestPart("photo") MultipartFile photoFile) {
        String message;
        if (uname.equals("poly") && pass.equals("123")) {
            message = "Đăng Nhập Thành Công!!!";
        } else {
            message = "Đăng Nhập Thất bại!!!";
        }

        if(!photoFile.isEmpty()){
            String dir = "/Users/phamvanchien/SpringBoot/banhang/photos/";
            String fileName = photoFile.getOriginalFilename();
            try {
                photoFile.transferTo(new File(dir, fileName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("message", message);
        return "login/login";
    }
    
   
}
