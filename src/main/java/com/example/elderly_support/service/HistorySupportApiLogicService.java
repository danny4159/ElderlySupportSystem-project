package com.example.elderly_support.service;

import com.example.elderly_support.model.entity1.HistorySupport;
import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.request.HistorySupportApiRequest;
import com.example.elderly_support.model.network.response.HistorySupportApiResponse;
import com.example.elderly_support.repository.ElderlyRepository;
import com.example.elderly_support.repository.HistorySupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorySupportApiLogicService extends BaseService<HistorySupportApiRequest, HistorySupportApiResponse, HistorySupport> {

    @Autowired
    HistorySupportRepository historySupportRepository;

    @Autowired
    ElderlyRepository elderlyRepository;

    @Override
    public Header<List<HistorySupportApiResponse>> search(Pageable pageable) {
        return null;
    }

    @Override
    public Header<HistorySupportApiResponse> create(Header<HistorySupportApiRequest> request) {
        return null;
    }

    @Override
    public Header<HistorySupportApiResponse> read(Long id) { //지원내역 조회
        if(elderlyRepository.findById(id).isPresent()){
            Optional<HistorySupport> optional = historySupportRepository.findByElderly(elderlyRepository.findById(id));
            return optional
                    .map(historySupport -> response(historySupport))
                    .orElseGet(() -> Header.ERROR("데이터 없음"));
        }else return Header.ERROR("존재하지 않는 아이디입니다.");
    }

    @Override
    public Header<HistorySupportApiResponse> update(Header<HistorySupportApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    public Header<HistorySupportApiResponse> response(HistorySupport historySupport){
        // elderly -> elderlyApiResponse
        HistorySupportApiResponse historySupportApiResponse = HistorySupportApiResponse.builder()
                .hs_code(historySupport.getHs_code())
                .hs_support_fund(historySupport.getHs_support_fund())
                .hs_support_date(historySupport.getHs_support_date())
                .e_id(historySupport.getElderly().getE_id())
                .ew_code(historySupport.getElderlyWelfare().getEw_code())
                .build();

        return Header.OK(historySupportApiResponse);
    }
}
