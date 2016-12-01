package com.kingbbode.controller;

import com.kingbbode.model.Answer;
import com.kingbbode.model.QnA;
import com.kingbbode.model.User;
import com.kingbbode.service.AnswerService;
import com.kingbbode.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by YG-MAC on 2016. 11. 24..
 */
@Controller
@RequestMapping("questions/{questionId}/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @PostMapping(value = "")
    public String create(@PathVariable Long questionId, Answer answer, HttpSession httpSession){
        User user = getLoginSession(httpSession);
        if(user == null){
            return "redirect:/users/login";
        }
        QnA qnA = questionService.get(questionId);
        if(qnA == null){
            return "redirect:/";
        }
        answerService.save(answer, user, qnA);
        return "redirect:/questions/" + questionId;
    }

    private User getLoginSession(HttpSession httpSession){
        Object tempUser = httpSession.getAttribute("loginUser");
        if(tempUser == null){
            return null;
        }
        return (User)tempUser;
    }
}
