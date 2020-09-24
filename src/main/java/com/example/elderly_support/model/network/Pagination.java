package com.example.elderly_support.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
public class Pagination {

    private Integer totalPages;         //전체 페이지
    private Long totalElements;         //전체 자료수
    private Integer currentPage;        //현재 페이지
    private Integer currentElements;    //현재 페이지 자료수
                                        //이정도 넘기면 FE에서 처리 가능해
}
