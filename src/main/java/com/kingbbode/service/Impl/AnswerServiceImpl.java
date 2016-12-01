package com.kingbbode.service.Impl;

import com.kingbbode.model.Answer;
import com.kingbbode.model.QnA;
import com.kingbbode.model.User;
import com.kingbbode.repository.AnswerRepository;
import com.kingbbode.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by YG-MAC on 2016. 12. 1..
 */
@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public void save(Answer answer, User user, QnA qnA) {
        answer.setWriter(user);
        answer.setQna(qnA);
        answerRepository.save(answer);
    }
}
