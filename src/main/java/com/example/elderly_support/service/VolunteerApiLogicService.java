package com.example.elderly_support.service;

import com.example.elderly_support.model.entity1.Volunteer;
import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.response.VolunteerApiResponse;
import com.example.elderly_support.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class VolunteerApiLogicService {

    @Autowired
    VolunteerRepository volunteerRepository;


    public Header<List<VolunteerApiResponse>> readAllVolunteer() { // 봉사자 전체 조회
        List<Volunteer> volunteerList = volunteerRepository.findAll();
        List<VolunteerApiResponse> volunteerApiResponseList = volunteerList.stream()
                .map(volunteer -> response(volunteer).getData())
                .collect(Collectors.toList());
        return Header.OK(volunteerApiResponseList);
    }


    public Header<VolunteerApiResponse> response(Volunteer volunteer) {
        // volunteer -> volunteerApiResponse
        VolunteerApiResponse volunteerApiResponse = VolunteerApiResponse.builder()
                .v_id(volunteer.getV_id())
                .v_name(volunteer.getV_name())
                .build();

        return Header.OK(volunteerApiResponse);
    }
}