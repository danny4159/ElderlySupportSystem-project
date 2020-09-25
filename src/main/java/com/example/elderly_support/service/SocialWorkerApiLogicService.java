package com.example.elderly_support.service;

import com.example.elderly_support.model.entity1.SocialWorker;
import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.request.SocialWorkerApiRequest;
import com.example.elderly_support.model.network.response.SocialWorkerApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocialWorkerApiLogicService extends BaseService<SocialWorkerApiRequest, SocialWorkerApiResponse, SocialWorker> {

    @Override
    public Header<List<SocialWorkerApiResponse>> search(Pageable pageable) {
        return null;
    }

    @Override
    public Header<SocialWorkerApiResponse> create(Header<SocialWorkerApiRequest> request) {
        return null;
    }

    @Override
    public Header<SocialWorkerApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<SocialWorkerApiResponse> update(Header<SocialWorkerApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }


    public Header<SocialWorkerApiResponse> LogIn(Long id,String password) {
        Optional<SocialWorker> optional = baseRepository.findById(id);

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
