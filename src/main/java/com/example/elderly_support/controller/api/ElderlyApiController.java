package com.example.elderly_support.controller.api;

import com.example.elderly_support.model.entity1.Elderly;
import com.example.elderly_support.model.network.request.ElderlyApiRequest;
import com.example.elderly_support.model.network.response.ElderlyApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/elderly")
public class ElderlyApiController extends CrudController<ElderlyApiRequest, ElderlyApiResponse, Elderly>{
}
