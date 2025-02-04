package com.example.myspringlab.home.controller;


import com.example.myspringlab.home.service.HomeService;
import com.example.myspringlab.home.vo.HomeVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homes")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    // ✅ 추천 매물 목록 조회 (검색 조건 포함)
    // ✅ 추천 매물 목록 조회 (검색 조건 포함)
    @GetMapping("/search")
    public List<HomeVO> getHomes(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {
        return homeService.getHomes(title, location, minPrice, maxPrice);
    }

    // ✅ 검색어 없이 전체 목록 조회
    @GetMapping
    public List<HomeVO> getAllHomes() {
        return homeService.getHomes(null, null, null, null);
    }

    // 추천 매물 저장 API
    @PostMapping
    public ResponseEntity<String> saveHome(@RequestBody HomeVO home) {
        homeService.saveHome(home);
        return ResponseEntity.ok("매물이 성공적으로 저장되었습니다.");
    }

}
