package com.example.elderly_support.service;

import com.example.elderly_support.model.entity1.Elderly;
import com.example.elderly_support.model.entity1.Volunteer;
import com.example.elderly_support.model.network.Header;
import com.example.elderly_support.model.network.request.ElderlyApiRequest;
import com.example.elderly_support.model.network.response.ElderlyApiResponse;
import com.example.elderly_support.repository.ElderlyRepository;
import com.example.elderly_support.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ElderlyApiLogicService{

    @Autowired
    ElderlyRepository elderlyRepository;
    @Autowired
    VolunteerRepository volunteerRepository;


    public Header<ElderlyApiResponse> createElderly(Header<ElderlyApiRequest> request) {

        ElderlyApiRequest elderlyApiRequest = request.getData();
        Elderly elderly = Elderly.builder()
                .e_income(elderlyApiRequest.getE_income())
                .e_sex(elderlyApiRequest.getE_sex())
                .e_tel_no(elderlyApiRequest.getE_tel_no())
                .e_emergency_no(elderlyApiRequest.getE_emergency_no())
                .e_period(elderlyApiRequest.getE_period())
                .e_address(elderlyApiRequest.getE_address())
                .e_birth_date(elderlyApiRequest.getE_birth_date())
                .e_name(elderlyApiRequest.getE_name())
                .e_hope1(elderlyApiRequest.getE_hope1())
                .e_hope2(elderlyApiRequest.getE_hope2())
                .e_point(0) //초기값 = 0
                .build();

        elderlyRepository.save(elderly);
        return response(elderly);
    }


    public Header<ElderlyApiResponse> updateElderly(Header<ElderlyApiRequest> request) {

        ElderlyApiRequest elderlyApiRequest = request.getData();

        Optional<Elderly> optional = elderlyRepository.findById(elderlyApiRequest.getE_id());

        optional.map(elderly -> {
            elderly.setE_income(elderlyApiRequest.getE_income())
                    .setE_sex(elderlyApiRequest.getE_sex())
                    .setE_tel_no(elderlyApiRequest.getE_tel_no())
                    .setE_emergency_no(elderlyApiRequest.getE_emergency_no())
                    .setE_period(elderlyApiRequest.getE_period())
                    .setE_address(elderlyApiRequest.getE_address())
                    .setE_birth_date(elderlyApiRequest.getE_birth_date())
                    .setE_name(elderlyApiRequest.getE_name())
                    .setE_hope1(elderlyApiRequest.getE_hope1())
                    .setE_hope2(elderlyApiRequest.getE_hope2());
            return elderly;
        });
        return optional
                .map(elderly -> {return elderlyRepository.save(elderly);})
                .map(elderly -> response(elderly))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }


    public Header<List<ElderlyApiResponse>> matchingElderlyAndVolunteer(Long v_id) {
        //1.봉사자 아이디로 개체를 가져와
        //2.모든 노인들을 가져와 (list)
        //3.각 노인들의 hope와 봉사자의 특기를 비교해서 같으면 point 오르도록 논리설계
        //4.노인 repository에 변화된 point는 update 되지 않도록.
        //5.return 노인 api response list

        //1.
        Optional<Volunteer> optional = volunteerRepository.findById(v_id);
        //2.
        List<Elderly> elderlyList = elderlyRepository.findAll();

        //3.
        List<ElderlyApiResponse> elderlyApiResponseList = elderlyList.stream().map(elderly -> {
            if (elderly.getE_hope1().getTitle().equals(optional.get().getV_expertise1().getTitle())) { // 1지망과 1지망이 동일하면
                elderly.setE_point(elderly.getE_point() + 3); // 3점 부여
            } else if (elderly.getE_hope1().getTitle().equals(optional.get().getV_expertise2().getTitle())) { // 1지망과 2지망이 동일하면
                elderly.setE_point(elderly.getE_point() + 2); // 2점 부여
            } else if (elderly.getE_hope2().getTitle().equals(optional.get().getV_expertise1().getTitle())) { // 2지망과 1지망이 동일하면
                elderly.setE_point(elderly.getE_point() + 2); // 2점 부여
            } else if (elderly.getE_hope2().getTitle().equals(optional.get().getV_expertise2().getTitle())) { // 2지망과 2지망이 동일하면
                elderly.setE_point(elderly.getE_point() + 1); // 1점 부여
            }
        //4.baseRepository.save(elderly);  point 변화를 repository에 update하지는 않는다.
            return response(elderly).getData();
        }).sorted(Comparator.comparing(ElderlyApiResponse::getE_point).reversed()) // point 내림차순으로 정렬
          .collect(Collectors.toList());
        //5.
        return Header.OK(elderlyApiResponseList);
    }


    public Header<ElderlyApiResponse> response(Elderly elderly){
        // elderly -> elderlyApiResponse
        ElderlyApiResponse elderlyApiResponse = ElderlyApiResponse.builder()
                .e_id(elderly.getE_id())
                .e_income(elderly.getE_income())
                .e_sex(elderly.getE_sex())
                .e_tel_no(elderly.getE_tel_no())
                .e_emergency_no(elderly.getE_emergency_no())
                .e_period(elderly.getE_period())
                .e_address(elderly.getE_address())
                .e_birth_date(elderly.getE_birth_date())
                .e_name(elderly.getE_name())
                .e_hope1(elderly.getE_hope1())
                .e_hope2(elderly.getE_hope2())
                .e_point(elderly.getE_point())
                .build();
        return Header.OK(elderlyApiResponse);
    }

}

