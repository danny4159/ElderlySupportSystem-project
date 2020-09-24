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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)  // jpa config와 관련. 감시해서
@Builder                                        // create 할때 주로 써
@Accessors(chain = true)                        // update 할때 주로 써
@ToString(exclude = {"welfareCenter"})
public class SocialWorker { // 사회복지사 (개체)

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long s_id;

	private String s_password; //설계에 없던 속성

	private String s_name;

	private String s_tel_no;

	private String s_position;

	@CreatedDate
	private LocalDateTime createdAt;

	@CreatedBy
	private String createdBy;

	@LastModifiedDate
	private LocalDateTime updatedAt;

	@LastModifiedBy
	private String updatedBy;

	@ManyToOne
	private WelfareCenter welfareCenter;

}
