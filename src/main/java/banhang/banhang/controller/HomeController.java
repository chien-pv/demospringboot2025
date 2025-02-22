package banhang.banhang.controller;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import banhang.banhang.DAO.ProductDAO;
import banhang.banhang.DAO.UserDAO;
import banhang.banhang.entity.Product;
import banhang.banhang.models.User;
import banhang.banhang.service.CookieService;
import banhang.banhang.service.CrudService;
import banhang.banhang.service.Mail;
import banhang.banhang.service.PgCrudService;
import banhang.banhang.service.SendMailService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
    @Autowired
    SendMailService sendMailService;

    @Autowired
    ProductDAO productDAO;

    @Qualifier("CS2")
    @Autowired
    CookieService cookieService;

    @Autowired
    CrudService crudService;

    @Autowired
    HttpSession session;

    @Autowired
    UserDAO userDAO;
    @Autowired 
    ServletContext context;
    @ResponseBody
    @GetMapping("/")
    public List<Product> index(Model model){
        
        sendMailService.push(new Mail("chienpv12@fpt.edu.vn", "Hello 2", "Hello 2"));
        // crudService.create();
        // cookieService.create(null, null, 0);
        List<Product> products = productDAO.findAll(Sort.by(Sort.Direction.DESC, "name"));
        // List<Product> products = productDAO.findByPriceLessThanAndNameContaining(30000, "a");
        // Page<Product> pages = productDAO.findAll(PageRequest.of((page-1), 2));
        // List<Product> products = pages.getContent();
        return products;
    }

    @GetMapping("about")
    public String about(Model model) {
        return "home/about";
    }

    // @Scheduled(fixedDelay = 3000, initialDelay = 5000)
    public void setSchedule(){
        System.out.println("Chúc mừng sinh nhật!!!");
    }
    
    // public List<User> index(Model model) {
    //     List<User> users =  userDAO.findAll();
    //     return users;
    // }

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
