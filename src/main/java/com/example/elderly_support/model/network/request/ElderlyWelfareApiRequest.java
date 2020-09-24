package com.example.elderly_support.model.network.request;

import com.example.elderly_support.model.entity1.HistorySupport;
import com.example.elderly_support.model.entity1.LocalGovernment;
import com.example.elderly_support.model.entity1.WelfareCenter;
import com.example.elderly_support.model.enumclass.V_expertise_enum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ElderlyWelfareApiRequest {

    private Long ew_code;

    private String ew_name;

    private Integer ew_support_max;

    private Integer ew_age;

    private String ew_residence;

    private Integer ew_family_income;

    private Long wc_code;

    private Long lg_code;

}
