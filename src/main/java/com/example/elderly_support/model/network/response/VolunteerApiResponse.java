package com.example.elderly_support.model.network.response;

import com.example.elderly_support.model.enumclass.V_expertise_enum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VolunteerApiResponse {

    private Long v_id;

    private LocalDateTime v_birth_date;

    private String v_name;

    private String v_address;

    private String v_tel_no;

    private String v_sex;

    private LocalDateTime v_period;

    private V_expertise_enum v_expertise1;

    private V_expertise_enum v_expertise2;

    private Long e_id;

}
