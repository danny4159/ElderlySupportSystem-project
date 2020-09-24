package com.example.elderly_support.model.network.request;

import com.example.elderly_support.model.entity1.Elderly;
import com.example.elderly_support.model.entity1.WelfareCenter;
import com.example.elderly_support.model.enumclass.E_hope_enum;
import com.example.elderly_support.model.enumclass.V_expertise_enum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VolunteerApiRequest {

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
