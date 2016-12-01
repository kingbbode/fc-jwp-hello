package com.kingbbode.model;

import javax.persistence.*;

/**
 * Created by YG-MAC on 2016. 12. 1..
 */
@Entity
public class Answer {
    @Id
    @GeneratedValue
    private Long idx;


    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_writer"))
    private User writer;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_answer_qna"))
    private QnA qna;


    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }

    public void setQna(QnA qna) {
        this.qna = qna;
    }
}
