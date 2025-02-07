package com.example.myspringlab.cmm.controller;

import com.example.myspringlab.cmm.service.CmmService;
import com.example.myspringlab.cmm.vo.OrgSdCodeVO;
import com.example.myspringlab.cmm.vo.OrgSggCodeVO;
import com.example.myspringlab.cmm.vo.OrgEmdCodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cmm")
public class CmmController {

    @Autowired
    private CmmService cmmService;

    // 시도 코드 조회
    @GetMapping("/sdCodes")
    public List<OrgSdCodeVO> getSdCodes() {
        return cmmService.getSdCodes();
    }

    // 시군구 코드 조회
    @GetMapping("/sggCodes")
    public List<OrgSggCodeVO> getSggCodes() {
        return cmmService.getSggCodes();
    }

    // 읍면동 코드 조회
    @GetMapping("/emdCodes")
    public List<OrgEmdCodeVO> getEmdCodes() {
        return cmmService.getEmdCodes();
    }
}
