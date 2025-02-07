package com.example.myspringlab.cmm.service;

import com.example.myspringlab.cmm.mapper.CmmMapper;
import com.example.myspringlab.cmm.vo.OrgSdCodeVO;
import com.example.myspringlab.cmm.vo.OrgSggCodeVO;
import com.example.myspringlab.cmm.vo.OrgEmdCodeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmmServiceImpl implements CmmService {

    @Autowired
    private CmmMapper cmmMapper;

    @Override
    public List<OrgSdCodeVO> getSdCodes() {
        return cmmMapper.selectOrgSdCodeList();
    }

    @Override
    public List<OrgSggCodeVO> getSggCodes() {
        return cmmMapper.selectOrgSggCodeList();
    }

    @Override
    public List<OrgEmdCodeVO> getEmdCodes() {
        return cmmMapper.selectOrgEmdCodeList();
    }
}
