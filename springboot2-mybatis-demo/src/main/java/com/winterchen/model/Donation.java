package com.winterchen.model;

import lombok.Data;

import java.util.Date;

/**
 * @Author: liuzipan
 * @Description
 * @Date :15:47 2019/2/13
 * @Modefied By:
 */
@Data
public class Donation {

    /*捐赠ID*/
    private String donId;

    /*用户ID*/
    private Integer userId;

    /*捐赠类型*/
    private Integer donProperty;

    /*捐赠项目*/
    private String donItem;

    /*捐赠时间*/
    private Date donTime;

    /*捐赠金额*/
    private long donAmount;
}
