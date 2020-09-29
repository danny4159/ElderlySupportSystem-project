package com.example.elderly_support.service;

import com.example.elderly_support.model.entity1.HistorySupport;
import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.request.ElderlyApiRequest;
import com.example.elderly_support.model.network.request.ElderlyWelfareApiRequest;
import com.example.elderly_support.model.network.request.HistorySupportApiRequest;
import com.example.elderly_support.model.network.response.HistorySupportApiResponse;
import com.example.elderly_support.repository.ElderlyRepository;
import com.example.elderly_support.repository.ElderlyWelfareRepository;
import com.example.elderly_support.repository.HistorySupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HistorySupportApiLogicService {

    @Autowired
    HistorySupportRepository historySupportRepository;

    @Autowired
    ElderlyRepository elderlyRepository;

    @Autowired
    ElderlyWelfareRepository elderlyWelfareRepository;


    public Header<HistorySupportApiResponse> readHistorySupportByElderlyId(Long id) { //지원내역 조회
        if(elderlyRepository.findById(id).isPresent()){
            Optional<HistorySupport> optional = historySupportRepository.findByElderly(elderlyRepository.findById(id));
            return optional
                    .map(historySupport -> response(historySupport))
                    .orElseGet(() -> Header.ERROR("데이터 없음"));
        }else return Header.ERROR("존재하지 않는 아이디입니다.");
    }


    //제도 매칭 UI 에서 ElderlyApiRequest와 ElderlyWelfareApiRequest로 create 하는 코드
    public Header<HistorySupportApiResponse> createHistorySupportByElderlyAndElderlyWelfare(Header<ElderlyApiRequest> e_request, Header<ElderlyWelfareApiRequest> ew_request) {
        ElderlyWelfareApiRequest elderlyWelfareApiRequest = ew_request.getData();
        ElderlyApiRequest elderlyApiRequest = e_request.getData();
        HistorySupport historySupport = HistorySupport.builder()
                .hs_support_fund(elderlyWelfareApiRequest.getEw_support_max()) // TODO: 2020-09-25  이 부분 개선 필요. 항상 max가 전달되는건 아니야.
                .hs_support_date(LocalDate.now())
                .elderly(elderlyRepository.findById(elderlyApiRequest.getE_id()).get())
                .elderlyWelfare(elderlyWelfareRepository.findById(elderlyWelfareApiRequest.getEw_code()).get())
                .build();

        historySupportRepository.save(historySupport);
        return response(historySupport);
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
