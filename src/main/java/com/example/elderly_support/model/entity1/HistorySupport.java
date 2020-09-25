package com.example.elderly_support.model.entity1;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)  // jpa config와 관련. 감시해서
@Builder                                        // create 할때 주로 써
@Accessors(chain = true)                        // update 할때 주로 써
@ToString(exclude = {"elderly","elderlyWelfare"})
public class HistorySupport { // 지원내역 (개체)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hs_code;

	private Integer hs_support_fund;

	private LocalDate hs_support_date;

	@CreatedDate
	private LocalDateTime createdAt;

	@CreatedBy
	private String createdBy;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@LastModifiedBy
	private String updatedBy;

	@ManyToOne
	private Elderly elderly;

	@ManyToOne
	private ElderlyWelfare elderlyWelfare;

}
