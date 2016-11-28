package com.kingbbode.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by YG-MAC on 2016. 11. 24..
 */
@Entity
public class QnA {
    @Id
    @GeneratedValue
    private long idx;
    private String writer;
    private String title;
    private String contents;

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}
