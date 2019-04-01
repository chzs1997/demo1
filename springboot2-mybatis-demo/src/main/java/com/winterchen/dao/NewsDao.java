package com.winterchen.dao;

import com.winterchen.model.Comment;
import com.winterchen.model.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: liuzipan
 * @Description
 * @Date :19:27 2019/3/19
 * @Modefied By:
 */
@Repository
public interface NewsDao {

    //查找当前截止到最后一条新闻ID号
    int findArtId();

    //存储新闻
    int save(@Param("artType") int artType
            ,@Param("artTitle") String artTitle
            ,@Param("artContent") String artContent
            ,@Param("artImage") String artImage
            ,@Param("artLabel1") String artLabel1
            ,@Param("artLabel2") String artLabel2
            ,@Param("artLabel3") String artLabel3
            ,@Param("artLabel4") String artLabel4);

    //初始化加载新闻
    List<News> selectAllNews();

    //初始化加载通知公告
    List<News> selectAnnouncement();

    //根据id查找一条新闻
    News findNewsByartId(@Param("artId") int artId);

    //根据指定id寻找其他新闻
    List<News> findNewsExtra(@Param("artId") int artId);

    //根据指定id寻找相关新闻
    List<News> findNewsRelation(int artId);

    //添加评论
    int addComments(@Param("commentName") String commentName
                    ,@Param("commentMail") String commentMail
                    ,@Param("commentContent") String commentContent
                    ,@Param("artId") int artId);

    //初始化评论
    List<Comment> commentsSeralize(int artId);
}
