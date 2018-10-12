package com.missile.sample.service;

import com.missile.sample.model.UserBall;

import java.util.List;


public interface UserBallService {


    int addUserBall(UserBall user);

    UserBall getUserBallById(Integer id);

    List<UserBall> getAllUserBall(int pageNum, int pageSize);


}
