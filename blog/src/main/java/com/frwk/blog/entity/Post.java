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
@Table(name = "post")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="frwk_blog_post_sequence")
	@SequenceGenerator(name="frwk_blog_post_sequence", sequenceName="post_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
	private int id; 
	
	private String post;
	private String link;
	@Column(name = "user_id")
	private int userId;
	
	private String fileName;

    private String fileType;

    @Lob
    private byte[] data;
	private LocalDateTime create_date;
	
	
}
