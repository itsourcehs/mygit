package com.hs.service.Impl;

import com.hs.dao.TeslaApplyMapper;
import com.hs.entity.TeslaApply;
import com.hs.service.teslaApplyDriveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class teslaApplyDriveServiceImpl implements teslaApplyDriveService {

    @Resource
    private TeslaApplyMapper mapper;

    @Override
    public int addDrive(TeslaApply teslaApply) {
        return mapper.insert(teslaApply);
    }
}
