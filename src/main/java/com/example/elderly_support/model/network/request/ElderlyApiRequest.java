package com.example.elderly_support.model.network.request;

import com.example.elderly_support.model.entity1.HistorySupport;
import com.example.elderly_support.model.entity1.Volunteer;
import com.example.elderly_support.model.enumclass.E_hope_enum;
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
public class ElderlyApiRequest {

    private Long e_id;

    private Integer e_income;

    private Integer e_point;

    private String e_sex;

    private String e_tel_no;

    private String e_emergency_no;

    private LocalDateTime e_period;

    private String e_address;

    private LocalDateTime e_birth_date;

    private String e_name;

    private E_hope_enum e_hope1;

    private E_hope_enum e_hope2;

    private Long v_id;

}
