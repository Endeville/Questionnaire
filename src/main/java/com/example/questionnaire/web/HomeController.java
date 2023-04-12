package com.example.questionnaire.web;

import com.example.questionnaire.services.interfaces.QuestionService;
import com.example.questionnaire.services.interfaces.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.concurrent.ThreadLocalRandom;

@Controller
@RequestMapping("/")
public class HomeController {

    private final QuestionService questionService;
    private final UserService userService;

    public HomeController(QuestionService questionService, UserService userService) {
        this.questionService = questionService;
        this.userService = userService;
    }

    @GetMapping
    public String home(Model model, Principal principal){
        model.addAttribute("nextQuestion", ThreadLocalRandom.current().nextLong(1, questionService.getQuestionCount() + 1));
        model.addAttribute("profile", userService.getUserProfileByUsername(principal.getName()));
        return "home";
    }
}
