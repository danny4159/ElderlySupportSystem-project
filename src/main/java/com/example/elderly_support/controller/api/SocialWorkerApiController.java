package com.example.elderly_support.controller.api;

import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.response.SocialWorkerApiResponse;
import com.example.elderly_support.service.SocialWorkerApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/socialWorker")
public class SocialWorkerApiController {

    @Autowired
    private SocialWorkerApiLogicService socialWorkerApiLogicService;


    @GetMapping("/{id}/logIn")
    public Header<SocialWorkerApiResponse> logIn(@PathVariable Long id, @PathVariable String password) {
        return socialWorkerApiLogicService.LogIn(id,password);
    }
}
