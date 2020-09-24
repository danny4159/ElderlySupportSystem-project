package com.example.elderly_support.service;

import com.example.elderly_support.model.entity1.ElderlyWelfare;
import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.request.ElderlyWelfareApiRequest;
import com.example.elderly_support.model.network.response.ElderlyWelfareApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElderlyWelfareApiLogicService extends BaseService<ElderlyWelfareApiRequest, ElderlyWelfareApiResponse, ElderlyWelfare> {

    @Override
    public Header<List<ElderlyWelfareApiResponse>> search(Pageable pageable) {
        return null;
    }

    @Override
    public Header<ElderlyWelfareApiResponse> create(Header<ElderlyWelfareApiRequest> request) {
        return null;
    }

    @Override
    public Header<ElderlyWelfareApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<ElderlyWelfareApiResponse> update(Header<ElderlyWelfareApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }
}
