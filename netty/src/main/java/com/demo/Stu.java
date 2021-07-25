package com.demo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class Stu {
    //编号
    private Integer id;
    //分数
    private Integer score;

    private LocalDateTime date;

    public Stu(Integer id, Integer score,LocalDateTime date) {
        this.id = id;
        this.score = score;
        this.date = date;
    }

}
