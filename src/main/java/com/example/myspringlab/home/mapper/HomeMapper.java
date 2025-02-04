package com.example.myspringlab.home.mapper;
import com.example.myspringlab.home.vo.HomeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomeMapper {

    List<HomeVO> getHomes(@Param("title") String title,
                          @Param("location") String location,
                          @Param("minPrice") Double minPrice,
                          @Param("maxPrice") Double maxPrice);

    // 추천 매물 저장
    void insertHome(HomeVO home);

    // 추천 매물 이미지 저장
    void insertHomeImages(@Param("propertyId") Long propertyId, @Param("images") List<String> images);

    // 파일 저장 테이블에 이미지 정보 저장 (property_id 포함)
    void insertFileStorage(@Param("propertyId") Long propertyId, @Param("filePath") String filePath, @Param("images") List<String> images);
}