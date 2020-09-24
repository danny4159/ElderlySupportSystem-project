package com.example.elderly_support.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElderlyWelfareApiResponse {

    private Long ew_code;

    private String ew_name;

    private Integer ew_support_max;

    private Integer ew_age;

    private String ew_residence;

    private Integer ew_family_income;

    private Long wc_code;

    private Long lg_code;

}
