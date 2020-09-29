package com.example.elderly_support.controller.api;

import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.request.ElderlyApiRequest;
import com.example.elderly_support.model.network.response.ElderlyApiResponse;
import com.example.elderly_support.service.ElderlyApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/elderly")
public class ElderlyApiController {

    @Autowired
    ElderlyApiLogicService elderlyApiLogicService;


    @PostMapping("")
    public Header<ElderlyApiResponse> createElderly(@RequestBody Header<ElderlyApiRequest> request) {
        log.info("{}",request);
        return elderlyApiLogicService.createElderly(request);
    }


    @PutMapping("")
    public Header<ElderlyApiResponse> updateElderly(@RequestBody Header<ElderlyApiRequest> request) {
        return elderlyApiLogicService.updateElderly(request);
    }

}
