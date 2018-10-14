package com.missile.sample.service.impl;

import com.github.pagehelper.PageHelper;
import com.missile.sample.mapper.UserBallMapper;
import com.missile.sample.model.UserBall;
import com.missile.sample.service.UserBallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserBallServiceImpl implements UserBallService {

    @Autowired
    private UserBallMapper userBallMapper;

    @Override
    public UserBall getUserBallById(Integer id) {
        return userBallMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserBall> getAllUserBall(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userBallMapper.selectAllUserBall();
    }

    @Override
    public int addUserBall(UserBall user) {
        return userBallMapper.insertSelective(user);
    }

    @Override
    public long getCount() {
        return userBallMapper.getCount();
    }

}
