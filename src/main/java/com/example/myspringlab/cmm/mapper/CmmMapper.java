package com.example.myspringlab.cmm.mapper;

import com.example.myspringlab.cmm.vo.OrgSdCodeVO;
import com.example.myspringlab.cmm.vo.OrgSggCodeVO;
import com.example.myspringlab.cmm.vo.OrgEmdCodeVO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CmmMapper {
    List<OrgSdCodeVO> selectOrgSdCodeList();
    List<OrgSggCodeVO> selectOrgSggCodeList();
    List<OrgEmdCodeVO> selectOrgEmdCodeList();
}
