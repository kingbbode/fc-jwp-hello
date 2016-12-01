package com.kingbbode.controller;

import com.kingbbode.model.User;
import com.kingbbode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by YG-MAC on 2016. 11. 24..
 */
@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public String list(Model model){
        model.addAttribute("users", userService.getAll());
        return "user/list";
    }

    @PostMapping(value = "")
    public String create(User user){
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/form")
    public String form(){
        return "user/form";
    }

    @GetMapping(value = "/{id}")
    public String show(Model model, @PathVariable long id){
        User user = userService.get(id);
        if(user != null)
        model.addAttribute("user", user);
        return "user/show";
    }

    @GetMapping(value = "/{id}/form")
    public String updateForm(Model model, @PathVariable long id, HttpSession httpSession){

        User loginUser = getLoginSession(httpSession);
        if(loginUser == null){
            return "redirect:/users/login";
        }
        User user = userService.get(id);
        if(user == null || !loginUser.matchId(id)) {
            return "redirect:/users/login";
        }
        model.addAttribute("user", user);
        return "user/updateForm";
    }

    @PutMapping(value = "/{id}")
    public String update(@PathVariable Long id,  User user, HttpSession httpSession){
        User loginUser = getLoginSession(httpSession);
        if(loginUser == null){
            return "redirect:/users/login";
        }
        if(user == null || !loginUser.matchId(id)) {
            return "redirect:/users/login";
        }
        userService.update(id, user);
        return "redirect:/users";
    }

    @GetMapping(value = "login")
    public String loginForm(){
        return "user/login";
    }

    @PostMapping(value = "login")
    public String login(String userId, String password, HttpSession httpSession){
        if(!userService.login(userId, password, httpSession)){
            return "redirect:/user/login_failed";
        }

        return "redirect:/";
    }

    private User getLoginSession(HttpSession httpSession){
        Object tempUser = httpSession.getAttribute("loginUser");
        if(tempUser == null){
            return null;
        }
        return (User)tempUser;
    }
}
