package com.example.elderly_support.model.network.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocialWorkerApiResponse {

    private Long s_id;

    private String s_password;

    private String s_name;

    private String s_tel_no;

    private String s_position;

    private Long wc_code;
}
