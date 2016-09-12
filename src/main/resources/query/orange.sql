DROP TABLE Exam CASCADE CONSTRAINT;
DROP TABLE Subject CASCADE CONSTRAINT;
DROP TABLE Member CASCADE CONSTRAINT;
DROP TABLE Grade CASCADE CONSTRAINT;
DROP TABLE Board CASCADE CONSTRAINT;
DROP TABLE Major CASCADE CONSTRAINT;

DROP SEQUENCE grade_seq;
DROP SEQUENCE art_seq;
DROP SEQUENCE subj_seq;
DROP SEQUENCE major_seq;
DROP SEQUENCE exam_seq;

CREATE TABLE Major(
   major_seq INT CONSTRAINT major_seq PRIMARY KEY,
   title VARCHAR2(20) NOT NULL
);
CREATE TABLE Member(
   mem_id VARCHAR2(20) PRIMARY KEY,
   pw VARCHAR2(20) NOT NULL,
   name VARCHAR2(20) NOT NULL,
   gender VARCHAR2(20) NOT NULL,
   reg_date VARCHAR2(20) NOT NULL,
   ssn VARCHAR2(10) NOT NULL,
   email VARCHAR2(30),
   profile_img VARCHAR2(100) DEFAULT 'default.jpg',
   role VARCHAR2(10) DEFAULT 'STUDENT',
   phone VARCHAR2(13) NOT NULL,
   major_seq INT,
   CONSTRAINT ck_gender CHECK (gender IN ('MALE','FEMALE')),
   CONSTRAINT fk_member_major FOREIGN KEY (major_seq) REFERENCES major(major_seq) ON DELETE CASCADE
);
CREATE TABLE Grade(
   grade_seq INT CONSTRAINT grade_pk PRIMARY KEY,
   grade VARCHAR2(5) NOT NULL,
   term VARCHAR2(10) NOT NULL,
   mem_id VARCHAR2(20) NOT NULL,
   CONSTRAINT fk_grade_member_id FOREIGN KEY (mem_id)   REFERENCES Member(mem_id) ON DELETE CASCADE
);
CREATE TABLE Board(
   art_seq INT CONSTRAINT board_pk PRIMARY KEY,
   category VARCHAR2(20) NOT NULL,
   title VARCHAR2(30) DEFAULT 'NO TITLE',
   reg_date VARCHAR2(20) NOT NULL,
   content VARCHAR2(100) DEFAULT 'NO CONTENT',
   mem_id VARCHAR2(20),
   CONSTRAINT fk_board_member_id FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
CREATE TABLE Subject(
   subj_seq INT CONSTRAINT subject_pk PRIMARY KEY,
   subj_name VARCHAR2(20) NOT NULL,
   mem_id VARCHAR2(20),
   CONSTRAINT fk_subject_mem_id FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
CREATE TABLE Exam(
   exam_seq INT CONSTRAINT exam_seq PRIMARY KEY,
   term VARCHAR2(10) NOT NULL,
   score INT DEFAULT 0,
   subj_seq INT,
   mem_id VARCHAR2(20),
   CONSTRAINT fk_exam_subj_seq FOREIGN KEY (subj_seq) REFERENCES Subject(subj_seq) ON DELETE CASCADE,
   CONSTRAINT fk_exam_mem_id FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);

CREATE SEQUENCE grade_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE art_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE subj_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE major_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
CREATE SEQUENCE exam_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;

CREATE VIEW Major_view
AS
SELECT 
	m.major_seq,
	title as major_title,
	mem_id,
	pw,
	name,
	gender,
	reg_date,
	ssn,
	email,
	profile_img,
	role,
	phone
FROM Major m,Member u
WHERE m.major_seq = u.major_seq;

CREATE VIEW Grade_view
AS SELECT u.mem_id,
	pw,
	name,
	gender,
	reg_date,
	ssn,
	email,
	profile_img,
	role,
	phone,
	g.grade_seq,
    grade,
    g.term as grade_term,
    s.subj_seq,
    subj_name,
    exam_seq,
    x.term as exam_term,
    score
from Member u, Grade g, Subject s, Exam x
WHERE u.mem_id = g.mem_id AND u.mem_id = s.mem_id AND u.mem_id = x.mem_id;

CREATE VIEW Board_view
AS
SELECT  
	u.mem_id,
	pw,
	name,
	gender,
	u.reg_date,
	ssn,
	email,
	profile_img,
	role,
	phone,
	art_seq,
    category,
    title,
    b.reg_date as write_date,
    content
FROM Member u,Board b
WHERE u.mem_id = b.mem_id;



SELECT * FROM TABS;
select view_name from user_views;
select * from user_sequences;
DROP TABLE TEST CASCADE CONSTRAINT;
DROP VIEW SUBJECT_MEMBER;
select sequence_owner, sequence_name from dba_sequences where sequence_owner='HANBIT';


CREATE OR REPLACE PROCEDURE InsertMajor(
	sp_title IN Major.title%TYPE
) AS
BEGIN
	INSERT INTO Major(major_seq,title)
	VALUES(major_seq.nextval,sp_title)
END InsertMajor;


CREATE OR REPLACE PROCEDURE InsertMember(
	sp_mem_id IN Member.mem_id%TYPE,
	sp_pw IN Member.pw%TYPE,
	sp_name IN Member.name%TYPE,
	sp_gender IN Member.gender%TYPE,
	sp_reg_date IN Member.reg_date%TYPE,
	sp_ssn IN Member.ssn%TYPE,
	sp_email IN Member.email%TYPE,
	sp_profile_img IN Member.profile_img%TYPE,
	sp_role IN Member.role%TYPE,
	sp_phone IN Member.phone%TYPE,
	sp_major_seq IN Member.major_seq%TYPE
) AS
BEGIN
	INSERT INTO Member(mem_id,pw,name,gender,reg_date,ssn,email,profile_img,role,phone)
	VALUES(sp_mem,sp_pw,sp_name,sp_gender,sp_reg_date,sp_ssn,sp_email,sp_profile_img,sp_role,sp_phone,sp_major_seq)
END; 




CREATE OR REPLACE PROCEDURE InsertGrade(
	sp_grade_seq IN Grade.grade_seq%TYPE,
	sp_grade IN Grade.grade%TYPE,
	sp_term IN Grade.term%TYPE,
	sp_mem_id IN Grade.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Grade(grade_seq,grade,term,mem_id)
	VALUES(sp_grade_seq,sp_grade,sp_term,sp_mem_id)
END;

CREATE OR REPLACE PROCEDURE InsertBoard(
	sp_art_seq IN Board.art_seq%TYPE,
	sp_category IN Board.category%TYPE,
	sp_title IN Board.title%TYPE,
	sp_reg_date IN Board.reg_date%TYPE,
	sp_content IN Board.content%TYPE,
	sp_mem_id IN Board.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Board(art_seq,category,title,reg_date,content,mem_id)
	VALUES(sp_art_seq,sp_category,sp_title,sp_reg_date,sp_content,sp_mem_id)
END;

CREATE OR REPLACE PROCEDURE InsertSubject(
   sp_subj_seq IN Subject.subj_seq%TYPE,
   sp_subj_name IN Subject.name%TYPE,
   sp_mem_id IN Subject.mem_id%TYPE,
) AS
BEGIN
	INSERT INTO Subject(subj_seq,subj_name,mem_id)
	VALUES(sp_subj_seq,sp_subj_name,sp_mem_id)
END; 

CREATE OR REPLACE PROCEDURE InsertExam(
   sp_exam_seq IN Exam.exam_seq%TYPE,
   sp_term IN Exam.term%TYPE,
   sp_score IN Exam.score%TYPE,
   sp_subj_seq IN Exam.subj_seq%TYPE,
   sp_mem_id IN Exam.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Exam(exam_seq,term,score,subj_seq,mem_id)
	VALUES(sp_exam_seq,sp_term,sp_score,sp_subj_seq,sp_mem_id)
END; 


