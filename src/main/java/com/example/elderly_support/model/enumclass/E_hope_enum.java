package com.example.elderly_support.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum E_hope_enum {

    COOKING(0,"요리","특기:요리"),
    ART_THERAPY(1,"미술치료","특기:미술치료"),
    BEAUTY(2,"미용","특기:미용"),
    HEALTHCARE(3,"건강관리","특기:건강관리"),
    CONVERSATION(4,"말동무","특기:말동무");

    private Integer id;
    private String title;
    private String description;
}

//    # enum 지정
//    - 정해진 값이 들어와야하는데 오타가 들어올 수 있는 경우에 enum으로 지정해줘야해.
//    - 이건 DB 설계 초창기에 정해야해. 실컷 데이터 모으고 만들면 수정할게 많아.
//      1.1. model 패키지 안에 enumclass 패키지 만들기
//      1.2. 그 안에 enum을 시킬 변수를 클래스로 만들어줘
//      1.3. entity에서 enum 시킬 변수에 enum 어노테이션과 변수형을 수정
//      1.4. network에 request,response 에서 enum시킬 변수의 변수형 수정 (어노테이션X)
//      1.5. service 에서 오류 뜬 것들 몇개 수정해주면 돼.
