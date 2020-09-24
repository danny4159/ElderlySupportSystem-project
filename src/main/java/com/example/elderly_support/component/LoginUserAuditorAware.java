package com.example.elderly_support.component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
//로그인한 사용자를 감시하는 역할
public class LoginUserAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() { //createdBy, updatedBy를 자동으로 설정해줘

        return Optional.of("AdminServer"); //현재는 로그인 시스템이 없기때문에 'AdminServer'로 대체
    }
}
