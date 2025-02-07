package com.example.myspringlab.home.controller;

import com.example.myspringlab.home.service.HomeService;
import com.example.myspringlab.home.vo.HomeVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/homes")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    /**
     * 매물 목록 (검색 가능)
     * GET /api/homes?title=...&location=...&minPrice=...&maxPrice=...
     */
    @GetMapping
    public List<HomeVO> getHomes(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice
    ) {
        return homeService.getHomes(title, location, minPrice, maxPrice);
    }

    /**
     * 매물 등록
     * POST /api/homes + multipart/form-data
     */
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<HomeVO> saveHome(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String location,
            @RequestParam(required = false) MultipartFile mainImage,
            @RequestParam(required = false) List<MultipartFile> images
    ) {
        HomeVO saved = homeService.saveHome(title, description, price, location, mainImage, images);
        return ResponseEntity.ok(saved);
    }

    /**
     * 매물 상세
     */
    @GetMapping("/{id}")
    public HomeVO getHome(@PathVariable Long id) {
        return homeService.getHomeById(id);
    }

    /**
     * 매물 수정
     */
    @PutMapping("/{id}")
    public ResponseEntity<HomeVO> updateHome(
            @PathVariable Long id,
            @RequestParam String title,
            @RequestParam Double price,
            @RequestParam String location,
            @RequestParam String description,
            @RequestParam(required = false) MultipartFile mainImage,
            @RequestParam(required = false) List<MultipartFile> images
    ) {
        HomeVO updated = homeService.updateHome(id, title, price, location, description, mainImage, images);
        return ResponseEntity.ok(updated);
    }

    /**
     * 이미지 삭제
     */
    @DeleteMapping("/{id}/images")
    public ResponseEntity<String> deleteImage(
            @PathVariable Long id,
            @RequestParam String imageUrl
    ) {
        homeService.deleteImage(id, imageUrl);
        return ResponseEntity.ok("이미지가 삭제되었습니다.");
    }

    /**
     * 대표 이미지 설정
     */
    @PutMapping("/{id}/images/main")
    public ResponseEntity<Void> setMainImage(
            @PathVariable Long id,
            @RequestParam String imageUrl
    ) {
        homeService.setMainImage(id, imageUrl);
        return ResponseEntity.ok().build();
    }
}
