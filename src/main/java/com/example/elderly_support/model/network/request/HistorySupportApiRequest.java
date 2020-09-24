package com.example.elderly_support.model.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistorySupportApiRequest {

    private Long hs_code;

    private Integer hs_support_fund;

    private LocalDateTime hs_support_date;

    private Long e_id;

    private Long ew_code;

}
