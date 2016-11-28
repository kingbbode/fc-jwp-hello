package com.kingbbode.service;

import com.kingbbode.model.QnA;

import java.util.List;

/**
 * Created by YG-MAC on 2016. 11. 28..
 */
public interface QuestionService {
    QnA get(long idx);

    List<QnA> getAll();

    void save(QnA user);
}
