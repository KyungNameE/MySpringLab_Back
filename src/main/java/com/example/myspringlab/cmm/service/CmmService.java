package com.example.myspringlab.cmm.service;

import com.example.myspringlab.cmm.vo.OrgSdCodeVO;
import com.example.myspringlab.cmm.vo.OrgSggCodeVO;
import com.example.myspringlab.cmm.vo.OrgEmdCodeVO;
import java.util.List;

public interface CmmService {
    List<OrgSdCodeVO> getSdCodes();
    List<OrgSggCodeVO> getSggCodes();
    List<OrgEmdCodeVO> getEmdCodes();
}
