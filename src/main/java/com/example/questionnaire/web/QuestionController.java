package com.example.questionnaire.web;

import com.example.questionnaire.models.dtos.rest.AnswerCheckDto;
import com.example.questionnaire.services.interfaces.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/{id}")
    public String showQuestion(@PathVariable(name="id") Long questionId, Model model){
        var question = questionService.findQuestionById(questionId);

        model.addAttribute("question", question);
        model.addAttribute("id", questionId);

        return "question";
    }

    @PostMapping("/{id}/check")
    public String checkAnswers(@PathVariable(name="id") Long questionId,
                               AnswerCheckDto answerCheckDto,
                               Principal principal){
        this.questionService.checkAnswers(principal.getName(), questionId, answerCheckDto.getAnswer().stream().map(Long::valueOf).collect(Collectors.toSet()));
        return "redirect:/";
    }
}
