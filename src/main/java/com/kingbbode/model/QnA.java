package com.kingbbode.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by YG-MAC on 2016. 11. 24..
 */
@Entity
public class QnA {
    @Id
    @GeneratedValue
    private Long idx;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
    private User writer;

    @OneToMany(mappedBy="qna")
    private List<Answer> answers;

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setWriter(User writer) {
        this.writer = writer;
    }


    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}
