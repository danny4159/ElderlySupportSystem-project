package com.example.elderly_support.model.entity1;

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
@ToString(exclude = {"historySupportList","welfareCenter","localGovernment"})
public class ElderlyWelfare { // 노인복지제도 (개체)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ew_code;

	private String ew_name;

	private Integer ew_support_max;

	private Integer ew_age;

	private String ew_residence;

	private Integer ew_family_income;

	@CreatedDate
	private LocalDateTime createdAt;

	@CreatedBy
	private String createdBy;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@LastModifiedBy
	private String updatedBy;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "elderlyWelfare")
	private List<HistorySupport> historySupportList;

	@ManyToOne
	private WelfareCenter welfareCenter;

	@ManyToOne
	private LocalGovernment localGovernment;


}
