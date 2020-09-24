package com.example.elderly_support.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//감시자
@Configuration // 설정파일에 대한 것이 들어감을 선언
@EnableJpaAuditing //jpa 감시를 활성화 시키겠다
public class JpaConfig {
}
