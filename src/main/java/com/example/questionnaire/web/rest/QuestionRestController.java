package com.example.questionnaire.web.rest;

import com.example.questionnaire.models.dtos.rest.AnswerCheckDto;
import com.example.questionnaire.services.interfaces.QuestionService;
import com.example.questionnaire.services.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/questions")
public class QuestionRestController {

//    private final QuestionService questionService;
//
//    public QuestionRestController(QuestionService questionService) {
//        this.questionService = questionService;
//    }
//
//    @PostMapping(value = "/check", consumes = "application/json")
//    public ResponseEntity<Void> checkQuestion(@Valid @RequestBody AnswerCheckDto answerCheckDto,
//                                                @AuthenticationPrincipal UserDetails principal){
//        if (principal == null) {
//            return ResponseEntity
//                    .status(HttpStatus.MOVED_PERMANENTLY)
//                    .header(HttpHeaders.LOCATION, "/users/login")
//                    .build();
//        }
//
//        this.questionService.checkAnswers(principal.getUsername(), answerCheckDto.getQuestionId(), answerCheckDto.getChecked().stream().map(Long::valueOf).collect(Collectors.toSet()));
//
//        return ResponseEntity
//                .status(HttpStatus.NO_CONTENT)
//                .build();
//    }
}
