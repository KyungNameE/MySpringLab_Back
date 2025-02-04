package com.example.myspringlab.service;

import com.example.myspringlab.vo.UserVO;
import java.util.List;

public interface UserService {
    List<UserVO> getAllUsers();
    int addUser(UserVO user);
}
