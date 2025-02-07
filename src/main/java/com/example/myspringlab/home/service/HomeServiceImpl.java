package com.example.myspringlab.home.service;

import com.example.myspringlab.home.mapper.HomeMapper;
import com.example.myspringlab.home.vo.HomeVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class HomeServiceImpl implements HomeService {

    private final HomeMapper homeMapper;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public HomeServiceImpl(HomeMapper homeMapper) {
        this.homeMapper = homeMapper;
    }

    @Override
    public List<HomeVO> getHomes(String title, String location, Double minPrice, Double maxPrice) {
        return homeMapper.getHomes(title, location, minPrice, maxPrice);
    }

    @Override
    @Transactional
    public HomeVO saveHome(String title, String description, Double price, String location,
                           MultipartFile mainImage, List<MultipartFile> images) {
        // 매물 등록
        HomeVO home = new HomeVO();
        home.setTitle(title);
        home.setDescription(description);
        home.setPrice(price);
        home.setLocation(location);
        homeMapper.insertHome(home);

        // 대표 이미지
        if (mainImage != null && !mainImage.isEmpty()) {
            String mainImageFileName = saveFile(mainImage);
            homeMapper.insertHomeImage(home.getId(), mainImageFileName, "Y");
        }

        // 추가 이미지
        if (images != null && !images.isEmpty()) {
            for (MultipartFile image : images) {
                String savedFileName = saveFile(image);
                homeMapper.insertHomeImage(home.getId(), savedFileName, "N");
            }
        }

        return homeMapper.getHomeById(home.getId());
    }

    @Override
    public HomeVO getHomeById(Long id) {
        HomeVO home = homeMapper.getHomeById(id);
        if (home != null) {
            String mainImage = homeMapper.getMainImage(id);
            home.setMainImage(mainImage);

            List<String> subImages = homeMapper.getSubImages(id);
            home.setImages(subImages);
        }
        return home;
    }

    @Override
    @Transactional
    public HomeVO updateHome(Long id, String title, Double price, String location, String description,
                             MultipartFile mainImage, List<MultipartFile> images) {
        // 기본정보 수정
        homeMapper.updateHome(id, title, price, location, description);

        // 대표 이미지 변경
        if (mainImage != null && !mainImage.isEmpty()) {
            homeMapper.resetMainImage(id);
            String mainImageFileName = saveFile(mainImage);
            homeMapper.insertHomeImage(id, mainImageFileName, "Y");
        }

        // 추가 이미지
        if (images != null && !images.isEmpty()) {
            for (MultipartFile image : images) {
                String savedFileName = saveFile(image);
                homeMapper.insertHomeImage(id, savedFileName, "N");
            }
        }

        return getHomeById(id);
    }

    @Override
    @Transactional
    public void deleteImage(Long id, String imageUrl) {
        // property_images 삭제
        homeMapper.deleteImage(id, imageUrl);

        // file_storage 테이블에서도 삭제 (원한다면)
        homeMapper.deleteFileStorage(id, imageUrl);

        // 실제 파일 삭제 (원한다면)
        File file = new File(uploadDir, imageUrl);
        if (file.exists()) {
            file.delete();
        }
    }

    @Override
    @Transactional
    public void setMainImage(Long id, String imageUrl) {
        // 기존 대표 이미지 N으로
        homeMapper.resetMainImage(id);
        // 해당 이미지 Y로
        homeMapper.setMainImage(id, imageUrl);
    }

    // 파일 저장
    private String saveFile(MultipartFile file) {
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        File destination = new File(directory, fileName);

        try {
            Files.copy(file.getInputStream(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("파일 저장 중 오류 발생: " + fileName, e);
        }

        return fileName;
    }
}
