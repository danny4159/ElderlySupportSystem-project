package com.example.elderly_support.model.network.request;

import com.example.elderly_support.model.entity1.WelfareCenter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocialWorkerApiRequest {

    private Long s_id;

    private String s_password;

    private String s_name;

    private String s_tel_no;

    private String s_position;

    private Long wc_code;
}
