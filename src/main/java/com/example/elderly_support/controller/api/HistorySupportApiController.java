package com.example.elderly_support.controller.api;

import com.example.elderly_support.model.entity1.HistorySupport;
import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.request.ElderlyApiRequest;
import com.example.elderly_support.model.network.request.ElderlyWelfareApiRequest;
import com.example.elderly_support.model.network.request.HistorySupportApiRequest;
import com.example.elderly_support.model.network.response.HistorySupportApiResponse;
import com.example.elderly_support.service.HistorySupportApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/historySupport")
public class HistorySupportApiController {

    @Autowired
    HistorySupportApiLogicService historySupportApiLogicService;


    @GetMapping("/{id}/readHistorySupport")
    public Header<HistorySupportApiResponse> readHistorySupportByElderlyId(Long id){
        log.info("readHistorySupportByElderlyId : {}",id);
        return historySupportApiLogicService.readHistorySupportByElderlyId(id);
    }


    @PostMapping("/createHistorySupport")
    public Header<HistorySupportApiResponse> createHistorySupportByElderlyAndElderlyWelfare(@RequestBody Header<ElderlyApiRequest> e_request, @RequestBody Header<ElderlyWelfareApiRequest> ew_request){
        log.info("{}",e_request);
        log.info("{}",ew_request);
        return historySupportApiLogicService.createHistorySupportByElderlyAndElderlyWelfare(e_request,ew_request);
    }

}
