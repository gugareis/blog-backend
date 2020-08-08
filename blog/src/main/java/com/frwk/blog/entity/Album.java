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
@Table(name = "album")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="frwk_blog_album_sequence")
	@SequenceGenerator(name="frwk_blog_album_sequence", sequenceName="album_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
	private int id; 
	
	private String fileName;

    private String fileType;
    @Lob
    private byte[] data;
    
	@Column(name = "user_id")
	private int userId;
}
