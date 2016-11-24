package com.kingbbode.web;

import com.kingbbode.model.QnA;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

/**
 * Created by YG-MAC on 2016. 11. 24..
 */
@Controller
public class QuestionController {
    private ArrayList<QnA> questions = new ArrayList<>();

    @PostMapping(value = "/questions")
    public String question(QnA qna){
        questions.add(qna);

        return "redirect:/";
    }

    @GetMapping(value = "/")
    public String home(Model model){
        model.addAttribute("questions", questions);
        return "index";
    }

    @GetMapping(value = "/qna/form")
    public String form(){
        return "qna/form";
    }
}
