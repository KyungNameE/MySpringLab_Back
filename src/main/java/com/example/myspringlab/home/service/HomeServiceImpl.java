package com.example.myspringlab.home.service;


import com.example.myspringlab.home.mapper.HomeMapper;
import com.example.myspringlab.home.vo.HomeVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    private final HomeMapper homeMapper;

    // 파일 저장 경로 설정 (application.properties에서 가져오기)
    @Value("${file.upload-dir}")
    private String uploadDir;

    public HomeServiceImpl(HomeMapper homeMapper) {
        this.homeMapper = homeMapper;
    }

    @Override
    public List<HomeVO> getHomes(String title, String location, Double minPrice, Double maxPrice) {
        return homeMapper.getHomes(
                (title == null || title.trim().isEmpty()) ? null : title,
                (location == null || location.trim().isEmpty()) ? null : location,
                minPrice,
                maxPrice
        );
    }


    @Override
    @Transactional // ✅ 매물 + 이미지 + 파일 저장을 하나의 트랜잭션으로 처리
    public void saveHome(HomeVO home) {
        // 1. 추천 매물 저장 (ID 자동 생성됨)
        homeMapper.insertHome(home);

        // 2. 이미지가 존재하면 property_images 테이블에 저장
        if (home.getImages() != null && !home.getImages().isEmpty()) {
            homeMapper.insertHomeImages(home.getId(), home.getImages());

            // 3. 파일 저장 경로 설정 및 파일 저장 처리
            for (String imageName : home.getImages()) {
                String filePath = uploadDir + "/" + imageName;
                // 실제 파일 저장 (예제: 빈 파일 생성)
                saveFile(filePath);
                // 4. 파일 저장 테이블(file_storage)에 저장
                homeMapper.insertFileStorage(home.getId(), filePath, home.getImages());
            }
        }
    }

    // ✅ 파일 저장 메서드 (실제 파일 생성)
    private void saveFile(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs(); // 디렉토리 생성
            }
            if (!file.exists()) {
                file.createNewFile(); // 빈 파일 생성
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("파일 저장 중 오류 발생: " + filePath);
        }
    }

}
