package com.example.myspringlab.home.vo;

import lombok.Data;

import java.util.List;

@Data
public class HomeVO {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String location;

    // 대표 이미지 경로
    private String mainImage;

    // 추가 이미지 목록
    private List<String> images;

    // 파일 관련 정보 (사용한다면)
    private List<FileVO> files;
}
