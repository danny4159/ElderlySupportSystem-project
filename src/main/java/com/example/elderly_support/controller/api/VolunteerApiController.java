package com.example.elderly_support.controller.api;

import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.response.VolunteerApiResponse;
import com.example.elderly_support.service.VolunteerApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/volunteer")
public class VolunteerApiController {

    @Autowired
    VolunteerApiLogicService volunteerApiLogicService;


    @GetMapping("/readAllVolunteer")
    public Header<List<VolunteerApiResponse>> readAllVolunteer(){
        return volunteerApiLogicService.readAllVolunteer();
    }
}
