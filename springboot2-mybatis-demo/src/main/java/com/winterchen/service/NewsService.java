package com.winterchen.service;

import com.github.pagehelper.PageInfo;
import com.winterchen.model.Comment;
import com.winterchen.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liuzipan
 * @Description
 * @Date :19:34 2019/3/19
 * @Modefied By:
 */
@Service
public interface NewsService {

    //查找当前截止到最后一条新闻ID号
    int findArtId();

    //存储新闻
    int save(int artType, String artTitle, String artContent, String artImage, String stage[]);

    //初始化加载新闻
    PageInfo<News> findAllNews(int pageNum, int pageSize);

    //初始化加载通知公告
    PageInfo<News> findAnnouncement(int pageNum, int pageSize);

    //根据id查找一条新闻
    News findNewsByartId(int artId);

    //根据指定id寻找其他新闻
    List<News> findNewsExtra(int artId);

    //根据指定id寻找相关新闻
    List<News> findNewsRelation(int artId);

    //添加评论
    int addComments(String commentName, String commentMail, String commentContent, int artId);

    //初始化评论
    List<Comment> commentsSeralize(int artId);
}
