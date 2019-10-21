package securitytest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;
import securitytest.model.Message;
import securitytest.repository.MessageRepository;

@Controller
public class HomeController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/admin/home")
    public String admin(){
        return "admin/home";
    }

    @PostMapping("/messages")
    public RedirectView saveMessage(Message message){
        System.out.println(message.getContent());
        messageRepository.save(message);
        return new RedirectView("/index");
    }
}
