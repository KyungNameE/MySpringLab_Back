package com.example.myspringlab.home.service;


import com.example.myspringlab.home.vo.HomeVO;

import java.util.List;

public interface HomeService {

    // 추천 매물 목록 조회 (검색 조건 포함)
    List<HomeVO> getHomes(String title, String location, Double minPrice, Double maxPrice);

    // 추천 매물 저장 (매물 + 이미지)
    void saveHome(HomeVO home);
}
