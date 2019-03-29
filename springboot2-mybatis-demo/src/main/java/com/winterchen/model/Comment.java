package com.winterchen.model;

import lombok.Data;

import java.sql.Date;

/**
 * @Author: liuzipan
 * @Description
 * @Date :21:50 2019/3/23
 * @Modefied By:
 */
@Data
public class Comment {

    //评论ID
    private Integer commentId;

    //新闻ID
    private Integer artId;

    //评论时间
    private Date commentTime;

    //评论邮箱
    private String commentMail;

    //评论内容
    private String commentContent;

    //评论人姓名
    private String commentName;
}
