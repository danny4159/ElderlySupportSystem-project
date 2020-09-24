package com.example.elderly_support.controller.api;

import com.example.elderly_support.model.entity1.Volunteer;
import com.example.elderly_support.model.network.request.VolunteerApiRequest;
import com.example.elderly_support.model.network.response.VolunteerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/volunteer")
public class VolunteerApiController extends CrudController<VolunteerApiRequest, VolunteerApiResponse, Volunteer>{
}
