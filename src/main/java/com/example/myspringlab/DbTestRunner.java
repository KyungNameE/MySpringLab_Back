package com.example.myspringlab;

import com.example.myspringlab.cmm.service.UserService;
import com.example.myspringlab.cmm.vo.UserVO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbTestRunner implements CommandLineRunner {

    private final UserService userService;

    public DbTestRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=== DB 연결 테스트 시작 ===");

        // 1. 초기 사용자 목록 조회
        List<UserVO> users = userService.getAllUsers();
        System.out.println("초기 사용자 목록: " + users);

        // 2. 새 사용자 추가
        /*UserVO newUser = new UserVO();
        newUser.setName("Test User");
        newUser.setEmail("test@example.com");
        int inserted = userService.addUser(newUser);
        System.out.println("추가된 사용자 수: " + inserted);*/

        // 3. 업데이트된 사용자 목록 조회
        List<UserVO> updatedUsers = userService.getAllUsers();
        System.out.println("업데이트된 사용자 목록: " + updatedUsers);

        System.out.println("=== DB 연결 테스트 완료 ===");
    }
}