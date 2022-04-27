package com.hs.service;

import com.hs.entity.TeslaActivity;

import java.util.List;

public interface teslaActivityService {

    List<TeslaActivity> findAllActivity();

    TeslaActivity findActivityById(String id);
}
