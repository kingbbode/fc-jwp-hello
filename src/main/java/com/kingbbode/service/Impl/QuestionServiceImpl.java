package com.kingbbode.service.Impl;

import com.kingbbode.model.QnA;
import com.kingbbode.repository.QuestionRepository;
import com.kingbbode.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YG-MAC on 2016. 11. 28..
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public QnA get(long idx) {
        return questionRepository.getOne(idx);
    }

    @Override
    public List<QnA> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public void save(QnA qnA) {
        questionRepository.save(qnA);
    }
}
