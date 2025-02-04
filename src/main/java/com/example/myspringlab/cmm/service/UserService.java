package com.example.myspringlab.cmm.service;

import com.example.myspringlab.cmm.vo.UserVO;

import java.util.List;

public interface UserService {
    List<UserVO> getAllUsers();
    int addUser(UserVO user);
}
