CREATE TABLE jt_mentor
(
    user_id BIGINT NOT NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (user_id)
);

CREATE TABLE jt_student
(
    user_id BIGINT NOT NULL,
    psp DOUBLE NOT NULL,
    attendance DOUBLE NOT NULL,
    CONSTRAINT pk_jt_student PRIMARY KEY (user_id)
);

CREATE TABLE jt_ta
(
    user_id BIGINT NOT NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_jt_ta PRIMARY KEY (user_id)
);

CREATE TABLE jt_user
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_jt_user PRIMARY KEY (id)
);

CREATE TABLE ms_mentor
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_ms_mentor PRIMARY KEY (id)
);

CREATE TABLE ms_student
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    attendance DOUBLE NOT NULL,
    CONSTRAINT pk_ms_student PRIMARY KEY (id)
);

CREATE TABLE ms_ta
(
    id    BIGINT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_ms_ta PRIMARY KEY (id)
);

CREATE TABLE st_user
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    user_type INT NULL,
    name      VARCHAR(255) NULL,
    email     VARCHAR(255) NULL,
    average_rating DOUBLE NOT NULL,
    psp DOUBLE NOT NULL,
    attendance DOUBLE NOT NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (id)
);

CREATE TABLE tpc_mentor
(
    id    BINARY(16) NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE tpc_student
(
    id    BINARY(16) NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    psp DOUBLE NOT NULL,
    attendance DOUBLE NOT NULL,
    CONSTRAINT pk_tpc_student PRIMARY KEY (id)
);

CREATE TABLE tpc_ta
(
    id    BINARY(16) NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    average_rating DOUBLE NOT NULL,
    CONSTRAINT pk_tpc_ta PRIMARY KEY (id)
);

CREATE TABLE tpc_user
(
    id    BINARY(16) NOT NULL,
    name  VARCHAR(255) NULL,
    email VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE jt_mentor
    ADD CONSTRAINT FK_JT_MENTOR_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE jt_student
    ADD CONSTRAINT FK_JT_STUDENT_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);

ALTER TABLE jt_ta
    ADD CONSTRAINT FK_JT_TA_ON_USER FOREIGN KEY (user_id) REFERENCES jt_user (id);