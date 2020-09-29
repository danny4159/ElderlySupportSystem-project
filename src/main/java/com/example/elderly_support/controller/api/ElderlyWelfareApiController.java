package com.example.elderly_support.controller.api;

import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.response.ElderlyWelfareApiResponse;
import com.example.elderly_support.service.ElderlyWelfareApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/elderlyWelfare")
public class ElderlyWelfareApiController {

    @Autowired
    ElderlyWelfareApiLogicService elderlyWelfareApiLogicService;


    @GetMapping("/{id}/matching")
    public Header<List<ElderlyWelfareApiResponse>> matchingElderlyAndElderlyWelfare(@PathVariable Long id) {
        log.info("read : {}",id);
        return elderlyWelfareApiLogicService.matchingElderlyAndElderlyWelfare(id);
    }
}
