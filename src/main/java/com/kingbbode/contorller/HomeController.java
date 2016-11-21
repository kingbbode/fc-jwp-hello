package com.kingbbode.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by YG-MAC on 2016. 11. 21..
 */
@Controller
public class HomeController {

    @GetMapping(value = "/home")
    public String home(Model model){
        model.addAttribute("message","Hello World!!");
        return "home";
    }
}
