package com.missile.sample.controller;


import com.missile.sample.model.UserBall;
import com.missile.sample.service.UserBallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserBall> getAllUserBall(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return userBallService.getAllUserBall(pageNum, pageSize);
    }


    @ResponseBody
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long getCount() {
        return userBallService.getCount();
    }


}
