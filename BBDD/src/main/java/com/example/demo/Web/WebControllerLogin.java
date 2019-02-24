package com.example.demo.Web;

import com.example.demo.web.WebController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebControllerLogin extends WebController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginerror")
    public String loginerror() {
        return "loginerror";
    }


    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("hideLogin",true);
        return "login";
    }

    @GetMapping("/loginerror")
    public String loginError(){
        return "loginError";
    }
}
