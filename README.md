# blog-backend
api para blog em java

pasta blog\target
Executar o comando java -jar blog-0.0.1-SNAPSHOT.jar
configurado para porta 8080

configuração de banco de dados

	spring.jpa.database=POSTGRESQL
	spring.datasource.platform=postgres
	#spring.jpa.show-sql=true
	spring.jpa.hibernate.ddl-auto=validate
	hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
	spring.database.driverClassName=org.postgresql.Driver
	spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
	spring.datasource.username=postgres
	spring.datasource.password=postgres

script de criação de tabelas

	-- Table: public.album

	-- DROP TABLE public.album;

	CREATE TABLE public.album
	(
		id integer NOT NULL,
		data oid,
		file_name character varying(255) COLLATE pg_catalog."default",
		file_type character varying(255) COLLATE pg_catalog."default",
		user_id integer,
		CONSTRAINT album_pkey PRIMARY KEY (id)
	)

	TABLESPACE pg_default;

	ALTER TABLE public.album
		OWNER to postgres;
		
	-- Table: public.comments

	-- DROP TABLE public.comments;

	CREATE TABLE public.comments
	(
		id integer NOT NULL,
		comments character varying(255) COLLATE pg_catalog."default",
		create_date timestamp without time zone,
		post_id integer,
		user_id integer NOT NULL,
		CONSTRAINT comments_pkey PRIMARY KEY (id)
	)

	TABLESPACE pg_default;

	ALTER TABLE public.comments
		OWNER to postgres;
	
	-- Table: public.post

	-- DROP TABLE public.post;

	CREATE TABLE public.post
	(
		id integer NOT NULL,
		create_date timestamp without time zone,
		data oid,
		file_name character varying(255) COLLATE pg_catalog."default",
		file_type character varying(255) COLLATE pg_catalog."default",
		link character varying(255) COLLATE pg_catalog."default",
		post character varying(255) COLLATE pg_catalog."default",
		user_id integer,
		CONSTRAINT post_pkey PRIMARY KEY (id)
	)

	TABLESPACE pg_default;

	ALTER TABLE public.post
		OWNER to postgres;
	
	-- Table: public.usuarios

	-- DROP TABLE public.usuarios;

	CREATE TABLE public.usuarios
	(
		id integer NOT NULL,
		create_date timestamp without time zone,
		email character varying(255) COLLATE pg_catalog."default",
		name character varying(255) COLLATE pg_catalog."default",
		password character varying(255) COLLATE pg_catalog."default",
		user_name character varying(255) COLLATE pg_catalog."default",
		CONSTRAINT usuarios_pkey PRIMARY KEY (id),
		CONSTRAINT uk_r9ksbmgwvokav9vgydstfdmws UNIQUE (user_name)
	)

	TABLESPACE pg_default;

	ALTER TABLE public.usuarios
		OWNER to postgres;