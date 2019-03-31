package com.winterchen.controller;

import com.winterchen.conf.MyWebAppConfigurer;
import com.winterchen.model.Manager;
import com.winterchen.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @Author: liuzipan
 * @Description
 * @Date :15:15 2019/3/31
 * @Modefied By:
 */
@Controller
@RequestMapping(value = "/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    /*
    *
    * 用户登陆
    */
    @ResponseBody
    @RequestMapping(value = "/login")
    public Object login(
            @RequestParam(value = "managerName") String managerName,
            @RequestParam(value = "managerPassword") String managerPassword,
            HttpSession session
    ){
        Manager i = managerService.login(managerName, managerPassword);
        if (i == null) {
            //查询没有结果
            return 0;
        } else {
            //数据库中有该用户
            // 设置session
            session.setAttribute(MyWebAppConfigurer.SESSION_KEY, i.getManagerId());
            session.setAttribute("managerName", i.getManagerName());
            session.setAttribute("managerPassword", i.getManagerPassword());
            session.setAttribute("managerGender", i.getManagerGender());
            session.setAttribute("managerIdentity", i.getManagerIdentity());
            HashMap<Object, Object> objectMap = new HashMap<>();
            objectMap.put("managerName", i.getManagerName());
            objectMap.put("managerPassword", i.getManagerPassword());
            objectMap.put("managerIdentity", i.getManagerIdentity());
            System.out.println(i.getManagerName());
            System.out.println(i.getManagerPassword());
            System.out.println(i.getManagerIdentity());
            return objectMap;
        }
    }

    /*
     * 状态检测
     * */
    @ResponseBody
    @PostMapping("/detectState")
    public Object detectState(
            @SessionAttribute(MyWebAppConfigurer.SESSION_KEY) String account,
            @SessionAttribute("managerName") String managerName,
            @SessionAttribute("managerPassword") String managerPassword,
            @SessionAttribute("managerIdentity") String managerIdentity,
            Model model) {
        model.addAttribute("name", account);
        System.out.println(managerName);
        System.out.println(managerPassword);
        System.out.println(managerIdentity);
        HashMap<Object, Object> objectMap = new HashMap<>();
        if (managerName == "尚未登陆") {
            objectMap.put("managerName", managerName);
            objectMap.put("managerPassword", "尚未登陆");
            objectMap.put("managerIdentity", "尚未登陆");
        } else {
            objectMap.put("managerName", managerName);
            objectMap.put("managerPassword", managerPassword);
            objectMap.put("managerIdentity", managerIdentity);
        }
        return objectMap;
    }


    /*
     * 退出登陆状态，注销
     *
     * */
    @ResponseBody
    @PostMapping("/logout")
    public Object logout(HttpSession session) {
        // 移除session
        session.removeAttribute(MyWebAppConfigurer.SESSION_KEY);
        return 1;
    }
}
