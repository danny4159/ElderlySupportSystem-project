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
@ToString(exclude = {"elderlyWelfareList","volunteer","localGovernmentList","socialWorkerList"})
public class WelfareCenter { // 복지관 (개체)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long wc_code;

	private String wc_name;

	private String wc_address;

	private String wc_tel_no;

	@CreatedDate
	private LocalDateTime createdAt;

	@CreatedBy
	private String createdBy;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@LastModifiedBy
	private String updatedBy;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "welfareCenter")
	private List<ElderlyWelfare> elderlyWelfareList;

	@ManyToOne
	private Volunteer volunteer;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "welfareCenter")
	private List<LocalGovernment> localGovernmentList;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "welfareCenter")
	private List<SocialWorker> socialWorkerList;

}
