package com.missile.sample.controller;


import com.missile.sample.model.UserBall;
import com.missile.sample.service.UserBallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserBallController {

    @Autowired
    private UserBallService userBallService;

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public int addUserBall(UserBall userBall) {
        return userBallService.addUserBall(userBall);
    }

    @ResponseBody
    @RequestMapping(value = "/query/{userId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public UserBall getUserBallById(@PathVariable("userId") Integer id) {
        return userBallService.getUserBallById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public List<UserBall> getAllUserBall(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return userBallService.getAllUserBall(pageNum, pageSize);
    }


}
