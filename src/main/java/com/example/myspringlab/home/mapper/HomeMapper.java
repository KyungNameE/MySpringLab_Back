package com.example.myspringlab.home.mapper;

import com.example.myspringlab.home.vo.HomeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomeMapper {

    // 매물 목록 (검색)
    List<HomeVO> getHomes(@Param("title") String title,
                          @Param("location") String location,
                          @Param("minPrice") Double minPrice,
                          @Param("maxPrice") Double maxPrice);

    // 매물 상세
    HomeVO getHomeById(@Param("id") Long id);

    // 대표 이미지 조회
    String getMainImage(@Param("propertyId") Long propertyId);

    // 추가 이미지 조회
    List<String> getSubImages(@Param("propertyId") Long propertyId);

    // 매물 등록
    void insertHome(HomeVO home);

    // 매물 수정
    void updateHome(@Param("id") Long id,
                    @Param("title") String title,
                    @Param("price") Double price,
                    @Param("location") String location,
                    @Param("description") String description);

    // 대표 이미지 리셋
    void resetMainImage(@Param("propertyId") Long propertyId);

    // 대표 이미지/추가 이미지 삽입
    void insertHomeImage(@Param("propertyId") Long propertyId,
                         @Param("imageUrl") String imageUrl,
                         @Param("isMain") String isMain);

    // 이미지 삭제
    void deleteImage(@Param("propertyId") Long propertyId,
                     @Param("imageUrl") String imageUrl);

    // file_storage 삭제 (선택)
    void deleteFileStorage(@Param("propertyId") Long propertyId,
                           @Param("fileName") String fileName);

    // 특정 이미지Url을 대표 이미지로
    void setMainImage(@Param("propertyId") Long propertyId,
                      @Param("imageUrl") String imageUrl);
}
