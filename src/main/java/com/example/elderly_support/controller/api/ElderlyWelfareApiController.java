package com.example.elderly_support.controller.api;

import com.example.elderly_support.model.entity1.ElderlyWelfare;
import com.example.elderly_support.model.network.request.ElderlyWelfareApiRequest;
import com.example.elderly_support.model.network.response.ElderlyWelfareApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/elderlyWelfare")
public class ElderlyWelfareApiController extends CrudController<ElderlyWelfareApiRequest, ElderlyWelfareApiResponse, ElderlyWelfare>{
}
