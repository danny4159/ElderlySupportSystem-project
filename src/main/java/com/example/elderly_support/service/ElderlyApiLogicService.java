package com.example.elderly_support.service;

import com.example.elderly_support.model.entity1.Elderly;
import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.request.ElderlyApiRequest;
import com.example.elderly_support.model.network.response.ElderlyApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElderlyApiLogicService extends BaseService<ElderlyApiRequest, ElderlyApiResponse, Elderly> {

    @Override
    public Header<List<ElderlyApiResponse>> search(Pageable pageable) {
        return null;
    }

    @Override
    public Header<ElderlyApiResponse> create(Header<ElderlyApiRequest> request) {
        return null;
    }

    @Override
    public Header<ElderlyApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<ElderlyApiResponse> update(Header<ElderlyApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }
}
