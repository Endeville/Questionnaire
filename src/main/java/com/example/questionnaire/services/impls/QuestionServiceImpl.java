package com.example.questionnaire.services.impls;

import com.example.questionnaire.models.enitities.AnswerEntity;
import com.example.questionnaire.models.views.QuestionViewDto;
import com.example.questionnaire.repositories.QuestionRepository;
import com.example.questionnaire.services.interfaces.QuestionService;
import com.example.questionnaire.services.interfaces.UserService;
import org.apache.tomcat.util.descriptor.web.ContextHandler;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.net.ContentHandler;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public QuestionServiceImpl(QuestionRepository questionRepository, ModelMapper modelMapper, UserService userService) {
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public Long getQuestionCount() {
        return questionRepository.count();
    }

    @Override
    public QuestionViewDto findQuestionById(Long questionId) {
        return this.modelMapper.map(this.questionRepository.findById(questionId), QuestionViewDto.class);
    }

    @Override
    public void checkAnswers(String username, Long questionId, Set<Long> answers) {
        var right = this.questionRepository.findById(questionId)
                .orElseThrow(IllegalStateException::new)
                .getAnswers()
                .stream()
                .filter(AnswerEntity::getCorrect)
                .map(AnswerEntity::getId)
                .collect(Collectors.toCollection(LinkedHashSet::new))
                .equals(new LinkedHashSet<>(answers));

        if(right){
            this.userService.addRightAnswers(username, 1);
        }

        this.userService.addAttempts(username, 1);
    }
}
