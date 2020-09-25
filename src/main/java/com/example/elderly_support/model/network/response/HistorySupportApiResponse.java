package com.example.elderly_support.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistorySupportApiResponse {

    private Long hs_code;

    private Integer hs_support_fund;

    private LocalDate hs_support_date;

    private Long e_id;

    private Long ew_code;

}
