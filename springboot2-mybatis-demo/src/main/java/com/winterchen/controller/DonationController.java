package com.winterchen.controller;

import com.winterchen.model.Donation;
import com.winterchen.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * @Author: liuzipan
 * @Description
 * @Date :15:47 2019/2/20
 * @Modefied By:
 */
@RestController
@RequestMapping(value = "donation")
public class DonationController {

    @Autowired
    private DonationService donationService;


    /*捐赠信息存储*/
    @PostMapping("donationKeep")
    public Object donationKeep(
            @RequestParam(value = "userId") int userId,
            @RequestParam(value = "donProperty") int donProperty,
            @RequestParam(value = "donItem") String donItem,
            @RequestParam(value = "donAmount") int donAmount
    ){
        try{
            int i = donationService.donationKeep(userId, donProperty, donItem, donAmount);
            if(i>0){
                return 1;
            }
            else{
                return 0;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 查询某一个校友的所有捐赠信息
     * */
    @PostMapping("donationSelectByuserId")
    public Object strokeSelect(
            @RequestParam(value = "userId") Integer userId
    ){
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Donation donation = donationService.donationSelectByuserId(userId);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        hashMap.put("donTime", f.format(donation.getDonTime()));
        hashMap.put("donProperty", donation.getDonProperty());
        hashMap.put("donItem", donation.getDonItem());
        hashMap.put("donAmount", donation.getDonAmount());
        return hashMap;
    }

    /*
     * 修改某一个校友的捐赠信息
     * */
    @PostMapping("donationUpdateByuserId")
    public Object donationUpdateByuserId(
            @RequestParam(value = "userId") Integer userId,
            @RequestParam(value = "donProperty") Integer donProperty,
            @RequestParam(value = "donItem") String donItem,
            @RequestParam(value = "donAmount") Integer donAmount
    ){
        int a = donationService.donationUpdateByuserId(userId, donProperty, donItem, donAmount);
        if(a>0){
            return 1;
        }
        else{
            return 0;
        }
    }
}
