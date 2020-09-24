package com.example.elderly_support.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {
    //Header는 기본 틀이다. 이런 틀로 작성하게 될거야.
    //위에 3가지는 고정. 밑에 data는 들어오는거에 따라 바뀐다.
    //<>이건 제네릭 어떤 제네릭으로 생성할지.

    //api 통신시간
    private LocalDateTime transactionTime;
//    private String transactionTime;

    //api 응답 코드
    private String resultCode;

    //api 부가 설명
    private String description;

    private T data; // data 부분에는 T 제네릭으로 설정한게 들어가.

    private Pagination pagination;



    //<결과에 따른 출력 세가지>

    //1. OK
    public static <T> Header<T> OK(){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    //2. DATA OK : data가 들어오는 ok
    public static <T> Header<T> OK(T data){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

    //3. ERROR : 에러. description 에러 설명
    public static <T> Header<T> ERROR(String description){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }

    //페이징 처리
    public static <T> Header<T> OK(T data, Pagination pagination){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .pagination(pagination)
                .build();
    }

}
