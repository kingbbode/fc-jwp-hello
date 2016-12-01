package com.kingbbode.service;

import com.kingbbode.model.Answer;
import com.kingbbode.model.QnA;
import com.kingbbode.model.User;

/**
 * Created by YG-MAC on 2016. 11. 28..
 */
public interface AnswerService {
    void save(Answer answer, User user, QnA qnA);
}
