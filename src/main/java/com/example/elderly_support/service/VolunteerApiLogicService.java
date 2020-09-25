package com.example.elderly_support.service;

import com.example.elderly_support.model.entity1.Volunteer;
import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.request.VolunteerApiRequest;
import com.example.elderly_support.model.network.response.VolunteerApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class VolunteerApiLogicService extends BaseService<VolunteerApiRequest, VolunteerApiResponse, Volunteer> {

    @Override
    public Header<List<VolunteerApiResponse>> search(Pageable pageable) {
        return null;
    }

    @Override
    public Header<VolunteerApiResponse> create(Header<VolunteerApiRequest> request) {
        return null;
    }

    @Override
    public Header<VolunteerApiResponse> read(Long id) { return null; }

    @Override
    public Header<VolunteerApiResponse> update(Header<VolunteerApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    public Header<VolunteerApiResponse> response(Volunteer volunteer) {
        // volunteer -> volunteerApiResponse
        VolunteerApiResponse elderlyApiResponse = VolunteerApiResponse.builder()
                .v_id(volunteer.getV_id())
                .v_name(volunteer.getV_name())
                .build();

        return Header.OK(elderlyApiResponse);
    }

    public Header<List<VolunteerApiResponse>> read_all() { // 봉사자 전체 조회
        List<Volunteer> volunteerList = baseRepository.findAll();
        List<VolunteerApiResponse> volunteerApiResponseList = volunteerList.stream()
                .map(volunteer -> response(volunteer).getData())
                .collect(Collectors.toList());
        return Header.OK(volunteerApiResponseList);
    }
}