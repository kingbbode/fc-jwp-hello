package com.kingbbode.controller.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by YG-MAC on 2016. 11. 28..
 */
@ControllerAdvice
public class NaviAdviceController {
    @ModelAttribute
    public void setNavigator(Model model){

    }
}
