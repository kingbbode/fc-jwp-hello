package com.kingbbode.controller;

import com.kingbbode.model.QnA;
import com.kingbbode.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YG-MAC on 2016. 11. 24..
 */
@Controller
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping(value = "")
    public String create(QnA qna){
        questionService.save(qna);
        return "redirect:/";
    }

    @GetMapping(value = "/form")
    public String form(){
        return "qna/form";
    }
}
