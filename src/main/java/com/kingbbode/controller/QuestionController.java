package com.kingbbode.controller;

import com.kingbbode.model.QnA;
import com.kingbbode.model.User;
import com.kingbbode.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by YG-MAC on 2016. 11. 24..
 */
@Controller
@RequestMapping("questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping(value = "")
    public String create(QnA qna, HttpSession httpSession){
        User user = getLoginSession(httpSession);
        if(user == null){
            return "redirect:/users/login";
        }
        questionService.save(qna, user);
        return "redirect:/";
    }

    @GetMapping(value = "/form")
    public String form(HttpSession httpSession){
        User user = getLoginSession(httpSession);
        if(user == null){
            return "redirect:/users/login";
        }
        return "qna/form";
    }

    @GetMapping(value = "/{idx}")
    public String show(Model model, @PathVariable Long idx){
        QnA qnA = questionService.get(idx);
        if(qnA == null){
            return "redirect:/";
        }
        model.addAttribute("qna", qnA);
        return "qna/show";
    }

    private User getLoginSession(HttpSession httpSession){
        Object tempUser = httpSession.getAttribute("loginUser");
        if(tempUser == null){
            return null;
        }
        return (User)tempUser;
    }
}
