package com.missile.sample.mapper;

import com.missile.sample.model.UserBall;

import java.util.List;

public interface UserBallMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserBall record);

    long getCount();

    int insertSelective(UserBall record);

    UserBall selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserBall record);

    int updateByPrimaryKey(UserBall record);

    List<UserBall> selectAllUserBall();
}