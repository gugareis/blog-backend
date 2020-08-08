package com.frwk.blog.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="frwk_blog_coments_sequence")
	@SequenceGenerator(name="frwk_blog_coments_sequence", sequenceName="coments_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
	private int id; 
	
	private String comments;
	private int userId;
	@Column(name = "post_id")
	private int postId;

	private LocalDateTime create_date;
}
