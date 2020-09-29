package com.example.elderly_support.service;

import com.example.elderly_support.model.entity1.Elderly;
import com.example.elderly_support.model.entity1.ElderlyWelfare;
import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.request.ElderlyWelfareApiRequest;
import com.example.elderly_support.model.network.response.ElderlyWelfareApiResponse;
import com.example.elderly_support.repository.ElderlyRepository;
import com.example.elderly_support.repository.ElderlyWelfareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ElderlyWelfareApiLogicService {

    @Autowired
    ElderlyWelfareRepository elderlyWelfareRepository;

    @Autowired
    ElderlyRepository elderlyRepository;


    public Header<List<ElderlyWelfareApiResponse>> matchingElderlyAndElderlyWelfare(Long e_id) {
        //1. id로 노인 객체 가져오기
        //2. 노인제도 모두 가져오기(List)
        //3. 노인제도에서 각각 노인의 나이/소득/거주지 를 비교해서 filter하기
        //4. 결과 Header에 담아서 return

        //1.
        Optional<Elderly> optional = elderlyRepository.findById(e_id);
            int optionalAge = optional.get().getE_birth_date().until(LocalDate.now()).getYears(); //만 나이 계산
            String optionalAddress = optional.get().getE_address();
            int optionalIncome = optional.get().getE_income();

        //2.
        List<ElderlyWelfare> elderlyWelfareList = elderlyWelfareRepository.findAll();

        //3.
        List<ElderlyWelfareApiResponse> elderlyWelfareApiResponseList = elderlyWelfareList.stream()
                .filter(elderlyWelfare -> elderlyWelfare.getEw_age() == optionalAge)              // 나이 제한에 맞는 제도
                .filter(elderlyWelfare -> elderlyWelfare.getEw_residence().equals(optionalAddress)) // 주소지가 맞는 제도
                .filter(elderlyWelfare -> elderlyWelfare.getEw_family_income() >= optionalIncome)   // 소득구간이 맞는 제도
                .map(elderlyWelfare -> response(elderlyWelfare).getData())
                .collect(Collectors.toList());

        //4.
        return Header.OK(elderlyWelfareApiResponseList);
    }


    public Header<ElderlyWelfareApiResponse> response(ElderlyWelfare elderlyWelfare) {
        // elderlyWelfare -> elderlyWelfareApiResponse
        ElderlyWelfareApiResponse elderlyWelfareApiResponse = ElderlyWelfareApiResponse.builder()
                .ew_code(elderlyWelfare.getEw_code())
                .ew_name(elderlyWelfare.getEw_name())
                .ew_support_max(elderlyWelfare.getEw_support_max())
                .ew_age(elderlyWelfare.getEw_age())
                .ew_family_income(elderlyWelfare.getEw_family_income())
                .ew_residence(elderlyWelfare.getEw_residence())
                .build();

        return Header.OK(elderlyWelfareApiResponse);
    }
}
