package com.kingbbode.controller;

import com.kingbbode.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by YG-MAC on 2016. 11. 28..
 */
@Controller
public class HomeController {

    @Autowired
    private QuestionService questionService;


    @GetMapping(value = "/")
    public String home(Model model){
        model.addAttribute("questions", questionService.getAll());
        return "index";
    }
}
