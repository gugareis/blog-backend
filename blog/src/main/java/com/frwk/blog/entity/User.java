package com.frwk.blog.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User{
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="frwk_blog_sequence")
	@SequenceGenerator(name="frwk_blog_sequence", sequenceName="blog_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
	private int id; 
	
	private	String name;
	@Column(unique=true)
	private String userName;
	private	String email;
	private	String password; 
	private LocalDateTime create_date;
//
//	@Column(name="grupo_acesso_id")
//	private int grupoAcessoId;
}