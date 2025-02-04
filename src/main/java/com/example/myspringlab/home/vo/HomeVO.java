package com.example.myspringlab.home.vo;

import lombok.Data;
import java.util.List;

@Data
public class HomeVO {
    private Long id;
    private String title;
    private Double price;
    private String description; // 상세 설명
    private String location;
    private List<String> images; // 이미지 리스트
    private List<FileVO> files;  // 파일 정보 리스트
}