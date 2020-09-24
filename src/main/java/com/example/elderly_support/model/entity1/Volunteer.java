package com.example.elderly_support.model.entity1;

import com.example.elderly_support.model.enumclass.V_expertise_enum;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)  // jpa config와 관련. 감시해서
@Builder                                        // create 할때 주로 써
@Accessors(chain = true)                        // update 할때 주로 써
@ToString(exclude = {"e_id","welfareCenterList"})
public class Volunteer { // 자원봉사자 (개체)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long v_id;

	private LocalDateTime v_birth_date;

	private String v_name;

	private String v_address;

	private String v_tel_no;

	private String v_sex;

	private LocalDateTime v_period;

	@Enumerated(EnumType.STRING)
	private V_expertise_enum v_expertise1;

	@Enumerated(EnumType.STRING)
	private V_expertise_enum v_expertise2;

	@CreatedDate
	private LocalDateTime createdAt;

	@CreatedBy
	private String createdBy;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@LastModifiedBy
	private String updatedBy;

	@OneToOne
	private Elderly e_id;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "volunteer")
	private List<WelfareCenter> welfareCenterList;

}
