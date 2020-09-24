package com.example.elderly_support.service;

import com.example.elderly_support.model.entity1.HistorySupport;
import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.request.HistorySupportApiRequest;
import com.example.elderly_support.model.network.response.HistorySupportApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorySupportApiLogicService extends BaseService<HistorySupportApiRequest, HistorySupportApiResponse, HistorySupport> {

    @Override
    public Header<List<HistorySupportApiResponse>> search(Pageable pageable) {
        return null;
    }

    @Override
    public Header<HistorySupportApiResponse> create(Header<HistorySupportApiRequest> request) {
        return null;
    }

    @Override
    public Header<HistorySupportApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<HistorySupportApiResponse> update(Header<HistorySupportApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }
}
