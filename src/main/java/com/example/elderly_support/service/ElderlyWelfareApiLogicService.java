package com.example.elderly_support.service;

import com.example.elderly_support.model.entity1.Elderly;
import com.example.elderly_support.model.entity1.ElderlyWelfare;
import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.request.ElderlyWelfareApiRequest;
import com.example.elderly_support.model.network.response.ElderlyWelfareApiResponse;
import com.example.elderly_support.repository.ElderlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ElderlyWelfareApiLogicService extends BaseService<ElderlyWelfareApiRequest, ElderlyWelfareApiResponse, ElderlyWelfare> {

    @Autowired
    ElderlyRepository elderlyRepository;

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


    public Header<ElderlyWelfareApiResponse> elderlyElderlyWelfareMatching(Long e_id) {
        //1. id로 노인 객체 가져오기
        //2. 노인제도 모두 가져오기(List)
        //3. 노인제도에서 각각 노인의 나이/소득/거주지 를 비교해서 filter하기
        //4. 결과 Header에 담아서 return
        Optional<Elderly> optional = elderlyRepository.findById(e_id);
            int optionalAge = optional.get().getE_birth_date().until(LocalDate.now()).getYears(); //만 나이 계산
            String optionalAddress = optional.get().getE_address();
            int optionalIncome = optional.get().getE_income();

        List<ElderlyWelfare> elderlyWelfareList = baseRepository.findAll();

        elderlyWelfareList.stream()
                .filter(elderlyWelfare -> elderlyWelfare.getEw_age() == (optionalAge))              // 나이 제한에 맞는 제도
                .filter(elderlyWelfare -> elderlyWelfare.getEw_residence().equals(optionalAddress)) // 주소지가 맞는 제도
                .filter(elderlyWelfare -> elderlyWelfare.getEw_family_income() >= optionalIncome)   // 소득구간이 맞는 제도
                .collect(Collectors.toList());



        return Header.OK();
    }
}
