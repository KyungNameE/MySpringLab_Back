package com.example.myspringlab.service;

import com.example.myspringlab.mapper.UserMapper;
import com.example.myspringlab.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserVO> getAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public int addUser(UserVO user) {
        return userMapper.insertUser(user);
    }
}
