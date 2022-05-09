package com.hs.controller;

import com.hs.entity.TeslaApply;
import com.hs.service.teslaApplyDriveService;
import com.hs.utils.JsonResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class teslaApplyDriveController {

    @Autowired
    @Qualifier("teslaApplyDriveServiceImpl")
    private teslaApplyDriveService service;

    @RequestMapping(value = "/apply/add")
    @ApiOperation("添加预约试驾信息")
    public JsonResult addApplyDrive(@RequestBody TeslaApply apply){
        service.addDrive(apply);
        return new JsonResult<>("0","新增成功");
    }
}
