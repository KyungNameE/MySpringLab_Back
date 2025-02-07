package com.example.myspringlab.home.service;

import com.example.myspringlab.home.vo.HomeVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface HomeService {
    List<HomeVO> getHomes(String title, String location, Double minPrice, Double maxPrice);

    HomeVO saveHome(String title, String description, Double price, String location,
                    MultipartFile mainImage, List<MultipartFile> images);

    HomeVO getHomeById(Long id);

    HomeVO updateHome(Long id, String title, Double price, String location, String description,
                      MultipartFile mainImage, List<MultipartFile> images);

    void deleteImage(Long id, String imageUrl);

    void setMainImage(Long id, String imageUrl);
}
