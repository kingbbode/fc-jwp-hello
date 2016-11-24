package com.kingbbode.web;

import com.kingbbode.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

/**
 * Created by YG-MAC on 2016. 11. 24..
 */
@Controller
public class UserController {
    private ArrayList<User> users = new ArrayList<>();

    @PostMapping(value = "/user/create")
    public String create(User user){
        System.out.println(user);
        users.add(user);

        return "redirect:/users";
    }

    @GetMapping(value = "/users")
    public String list(Model model){
        model.addAttribute("users", users);
        return "/user/list";
    }

    @GetMapping(value = "/user/form")
    public String form(){
        return "user/form";
    }
}
