package com.kingbbode.repository;

import com.kingbbode.model.QnA;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YG-MAC on 2016. 11. 28..
 */
public interface QuestionRepository extends JpaRepository<QnA, Long> {
}
