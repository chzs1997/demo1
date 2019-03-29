package com.winterchen.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.winterchen.dao.NewsDao;
import com.winterchen.model.Comment;
import com.winterchen.model.News;
import com.winterchen.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liuzipan
 * @Description
 * @Date :19:36 2019/3/19
 * @Modefied By:
 */
@Service(value = "NewsService")
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public int findArtId() {
        return newsDao.findArtId();
    }

    @Override
    public int save(int artType, String artTitle, String artContent, String artImage, String[] stage) {
        String artLabel1 ="无"
               ,artLabel2 = "无"
                ,artLabel3 = "无"
                ,artLabel4 = "无";
        switch (stage.length){
            case 0:
                break;
            case 1:
                artLabel1 = stage[0];
                break;
            case 2:
                artLabel1 = stage[0];
                artLabel2 = stage[1];
                break;
            case 3:
                artLabel1 = stage[0];
                artLabel2 = stage[1];
                artLabel3 = stage[2];
                break;
            case 4:
                artLabel1 = stage[0];
                artLabel2 = stage[1];
                artLabel3 = stage[2];
                artLabel4 = stage[3];
                break;
        }
        return newsDao.save(artType, artTitle, artContent, artImage, artLabel1, artLabel2, artLabel3, artLabel4);
    }

    @Override
    public PageInfo<News> findAllNews(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<News> news = newsDao.selectAllNews();
        PageInfo result = new PageInfo(news);
        return result;
    }

    @Override
    public PageInfo<News> findAnnouncement(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<News> news = newsDao.selectAnnouncement();
        PageInfo result = new PageInfo(news);
        return result;
    }

    @Override
    public News findNewsByartId(int artId) {
        return newsDao.findNewsByartId(artId);
    }

    @Override
    public List<News> findNewsExtra(int artId) {
        return newsDao.findNewsExtra(artId);
    }

    @Override
    public List<News> findNewsRelation(int artId) {
        return newsDao.findNewsRelation(artId);
    }

    @Override
    public int addComments(String commentName, String commentMail, String commentContent, int artId) {
        return  newsDao.addComments(commentName, commentMail, commentContent, artId);
    }

    @Override
    public List<Comment> commentsSeralize(int artId) {
        return newsDao.commentsSeralize(artId);
    }
}
