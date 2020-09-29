package com.example.elderly_support.service;

import com.example.elderly_support.model.entity1.SocialWorker;
import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.request.SocialWorkerApiRequest;
import com.example.elderly_support.model.network.response.SocialWorkerApiResponse;
import com.example.elderly_support.repository.SocialWorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocialWorkerApiLogicService {

    @Autowired
    SocialWorkerRepository socialWorkerRepository;


    public Header<SocialWorkerApiResponse> LogIn(Long id,String password) {
        Optional<SocialWorker> optional = socialWorkerRepository.findById(id);

        if(password == optional.get().getS_password()) {
            return optional
                    .map(socialWorker -> response(socialWorker))
                    .orElseGet(() -> Header.ERROR("데이터 없음"));
        }else{
            return Header.ERROR("패스워드 오류");
        }
    }


    public Header<SocialWorkerApiResponse> response(SocialWorker socialWorker){

        SocialWorkerApiResponse socialWorkerApiResponse = SocialWorkerApiResponse.builder()
                .s_id(socialWorker.getS_id())
                .s_password(socialWorker.getS_password())
                .s_name(socialWorker.getS_name())
                .s_position(socialWorker.getS_position())
                .s_tel_no(socialWorker.getS_tel_no())
                .wc_code(socialWorker.getWelfareCenter().getWc_code())
                .build();

        return Header.OK(socialWorkerApiResponse);
    }
}
