package com.example.myspringlab.mapper;

import com.example.myspringlab.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 모든 사용자 조회
    List<UserVO> selectAllUsers();

    // 사용자 삽입
    int insertUser(UserVO user);
}
