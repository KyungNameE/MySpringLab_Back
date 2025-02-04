package com.example.myspringlab.cmm.controller;

import com.example.myspringlab.cmm.service.UserService;
import com.example.myspringlab.cmm.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET /users : 모든 사용자 조회
    @GetMapping
    public List<UserVO> getUsers() {
        return userService.getAllUsers();
    }

    // POST /users : 새로운 사용자 추가
    @PostMapping
    public String addUser(@RequestBody UserVO user) {
        int result = userService.addUser(user);
        return result > 0 ? "User added successfully" : "Error adding user";
    }
}
