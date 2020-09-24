package com.example.elderly_support.model.entity1;


import com.example.elderly_support.model.entity.Item;
import com.example.elderly_support.model.enumclass.E_hope_enum;
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
@ToString(exclude = {"volunteer","historySupportList"})
public class Elderly { // 노인 (개체)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Enumerated(EnumType.STRING)
	private E_hope_enum e_hope1;

	@Enumerated(EnumType.STRING)
	private E_hope_enum e_hope2;

	@CreatedDate
	private LocalDateTime createdAt;

	@CreatedBy
	private String createdBy;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@LastModifiedBy
	private String updatedBy;

	@OneToOne
	private Volunteer volunteer;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "elderly")
	private List<HistorySupport> historySupportList;
}
