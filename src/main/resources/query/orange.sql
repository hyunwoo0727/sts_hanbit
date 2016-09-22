/* =========================META_PROCEDURE=================== */
/*
===========MAJOR GROUP============ 
@QUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-09-09
@UPDATE DATE : 2016-09-09
@DESC : 전공
============================ 
*/
-- DROP_SEQUENCE
DROP SEQUENCE major_seq;
-- CREATE_SEQUENCE
CREATE SEQUENCE major_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
-- DROP_TABLE
DROP TABLE Grade CASCADE CONSTRAINT;
-- CREATE_TABLE ORDER 1
CREATE TABLE Major(
   major_seq INT CONSTRAINT major_seq PRIMARY KEY,
   title VARCHAR2(20) NOT NULL
);
-- CREATE_VIEW
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
-- SP_INSERT_MAJOR
CREATE OR REPLACE PROCEDURE insert_major(
	sp_title IN Major.title%TYPE
) AS
BEGIN
	INSERT INTO Major(major_seq,title)
	VALUES(major_seq.nextval,sp_title);
END insert_major;
-- EXE_INSERT_MAJOR
EXEC hanbit.insert_major('영문학과');
-- SP_UPDATE_MAJOR
CREATE OR REPLACE PROCEDURE update_major(
    sp_title     IN major.title%TYPE,
    sp_major_seq IN major.major_seq%TYPE
)
AS
BEGIN    
    UPDATE Major SET title = sp_title WHERE major_seq = sp_major_seq;
END update_major;
-- EXE_UPDATE_MAJOR
EXEC hanbit.update_major('국어국문학과',1011);
-- SP_DELETE_MAJOR
CREATE OR REPLACE PROCEDURE delete_major(
    sp_major_seq IN Major.major_seq%TYPE
)
AS
BEGIN    
    DELETE FROM Major WHERE major_seq = sp_major_seq;
END delete_major;
-- EXE_DELETE_MAJOR
EXEC hanbit.delete_major(1011);
-- SP_SELECT_MAJOR(ALL)
CREATE OR REPLACE PROCEDURE select_major(
    major_cur OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN major_cur FOR
    SELECT major_seq,title FROM Major;
END select_major;
-- EXE_SELECT_MAJOR(ALL)
DECLARE
  sp_cursor  SYS_REFCURSOR;
  sp_major_seq   Major.major_seq%TYPE;
  sp_title   Major.title%TYPE;
BEGIN
  select_major (sp_cursor);         
  LOOP 
    FETCH sp_cursor
    INTO  sp_major_seq,sp_title;
    EXIT WHEN sp_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(sp_major_seq||','||sp_title);
  END LOOP;
  CLOSE sp_cursor;
END;
--SP_ALL_MAJOR(CLOB_VERSION)
CREATE OR REPLACE PROCEDURE all_major(
    sp_result OUT CLOB
) AS
    sp_temp CLOB;
    sp_cnt NUMBER := 0;
BEGIN
    FOR major_rec IN (SELECT m.major_seq,m.title FROM   Major m)
    LOOP
        sp_cnt := sp_cnt +1;
        IF sp_cnt =1 THEN
           sp_temp := major_rec.major_seq||','||major_rec.title;
        ELSE
           sp_temp := sp_temp || CHR(10) ||
                      major_rec.major_seq||','||major_rec.title;
        END IF;
    END LOOP;
    sp_result := sp_temp;
END all_major;
--EXE_ALL_MAJOR (CLOB_VERSION)
DECLARE 
    sp_result CLOB;
    BEGIN
        all_major(sp_result);
        DBMS_OUTPUT.PUT_LINE(sp_result);
END;
-- SP_SELECT_MAJOR_BY_TITLE
CREATE OR REPLACE PROCEDURE select_major_title(
    sp_title IN Major.title%TYPE,
    major_cur OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN major_cur FOR
    SELECT major_seq,title FROM major WHERE title=sp_title;
END select_major_title;
-- EXE_SELECT_MAJOR_BY_TITLE

--SP_FIND_BY_MAJOR_SEQ
CREATE OR REPLACE PROCEDURE find_by_major_seq(
   sp_major_seq IN Major.major_seq%TYPE,
   sp_major OUT Major%ROWTYPE
   )AS sp_temp_count NUMBER; BEGIN SELECT COUNT (*) INTO sp_temp_count FROM Major WHERE major_seq = sp_major_seq;
   IF (sp_temp_count >0) THEN SELECT * INTO sp_major FROM Major WHERE major_seq = sp_major_seq;
   ELSE DBMS_OUTPUT.PUT_LINE('전공 과목이 없습니다'); END IF; END find_by_major_seq;        
--EXE_FIND_BY_MAJOR_SEQ
DECLARE sp_major_seq NUMBER := 1010; sp_major Major%ROWTYPE;
BEGIN find_by_major_seq(sp_major_seq,sp_major); DBMS_OUTPUT.put_line (sp_major.title); END;

/*
===========STUDENT GROUP============ 
@QUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-09-09
@UPDATE DATE : 2016-09-09
@DESC : 학생
============================ 
*/
-- DROP_TABLE
DROP TABLE Member CASCADE CONSTRAINT;
-- CREATE_TABLE ORDER 2
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
-- SP_INSERT_STUDENT
CREATE OR REPLACE PROCEDURE insert_student(
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
	INSERT INTO Member(mem_id,pw,member.name,gender,reg_date,ssn,email,profile_img,member.role,phone,major_seq)
	VALUES(sp_mem_id,sp_pw,sp_name,sp_gender,sp_reg_date,sp_ssn,sp_email,sp_profile_img,sp_role,sp_phone,sp_major_seq);
END insert_student; 
-- EXE_INSERT_STUDENT
exec hanbit.insert_student('xornjseh1000','1','김동혁','MALE','2016-09-19','910202-1','xornjseh1000@naver.com','xornjseh1000.png','STUDENT','010-7350-5041',1010);
-- SP_EXIST_STUDENT_ID
CREATE OR REPLACE PROCEDURE exist_student_id(
    sp_stud_id IN Member.mem_id%TYPE,
    sp_cnt OUT NUMBER
) AS
BEGIN
    SELECT count(*) INTO sp_cnt FROM Member WHERE role='STUDENT' AND mem_id=sp_stud_id; 
END exist_student_id;
-- EXE_EXIST_STUDENT_ID
DECLARE
    sp_result NUMBER;
    sp_stud_id VARCHAR2(30);
BEGIN
    sp_stud_id := 'hong';
    hanbit.exist_student_id(sp_stud_id,sp_result);
    DBMS_OUTPUT.PUT_LINE('학수 수: '||sp_result);
END;
-- SP_FIND_BY_ID_STUDENT
CREATE OR REPLACE PROCEDURE find_by_id_student(
    sp_stu_id IN Member.mem_id%TYPE,
    sp_member OUT Member%ROWTYPE
) AS
BEGIN
    SELECT * INTO sp_member FROM MEMBER WHERE role='STUDENT' AND mem_id=sp_stu_id;
END find_by_id_student;
-- EXE_FIND_BY_ID_STUDENT
DECLARE
    sp_stu_id VARCHAR2(100) := 'hong';
    sp_student Member%ROWTYPE;
BEGIN
    hanbit.find_by_id_student(sp_stu_id,sp_student);
    DBMS_OUTPUT.PUT_LINE(sp_student.name);
END;
-- SP_MEMBER_COUNT
CREATE OR REPLACE PROCEDURE count_member(
    sp_mem_cnt OUT NUMBER
) AS
BEGIN
    SELECT COUNT(*) INTO sp_mem_cnt FROM MEMBER;
END count_member;
-- EXE_MEMBER_COUNT
DECLARE 
    sp_count NUMBER;
BEGIN
    count_member(sp_count);
    DBMS_OUTPUT.PUT_LINE('멤버 인원 '||sp_count);
END;
-- SP_COUNT_STUDENT
CREATE OR REPLACE PROCEDURE count_student(
    sp_mem_cnt OUT NUMBER
) AS
BEGIN
    SELECT COUNT(*) INTO sp_mem_cnt FROM MEMBER WHERE role='STUDENT';
END count_student;
-- EXE_COUNT_STUDENT
DECLARE 
    sp_count NUMBER;
BEGIN
    count_student(sp_count);
    DBMS_OUTPUT.PUT_LINE('학생 인원 '||sp_count);
END;

-- SP_ALL_STUDENT
CREATE OR REPLACE PROCEDURE all_student(
    prof_cur OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN prof_cur FOR
    SELECT * FROM Member WHERE role='STUDENT';
END all_student;
-- EXE_AALL_STUDENT
DECLARE
  sp_cursor  SYS_REFCURSOR;
  sp_student   Member%ROWTYPE;
BEGIN
  all_student (sp_cursor);         
  LOOP 
    FETCH sp_cursor
    INTO  sp_student;
    EXIT WHEN sp_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(sp_student.mem_id);
  END LOOP;
  CLOSE sp_cursor;
END;
/*
===========PROFESSOR  GROUP============ 
@QUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-09-09
@UPDATE DATE : 2016-09-09
@DESC : 교수
============================ 
*/
-- SP_INSERT_PROF
CREATE OR REPLACE PROCEDURE insert_prof(
	sp_mem_id IN Member.mem_id%TYPE,
	sp_pw IN Member.pw%TYPE,
	sp_name IN Member.name%TYPE,
	sp_gender IN Member.gender%TYPE,
	sp_reg_date IN Member.reg_date%TYPE,
	sp_ssn IN Member.ssn%TYPE,
	sp_email IN Member.email%TYPE,
	sp_profile_img IN Member.profile_img%TYPE,
	sp_role IN Member.role%TYPE,
	sp_phone IN Member.phone%TYPE
) AS
BEGIN
	INSERT INTO Member(mem_id,pw,member.name,gender,reg_date,ssn,email,profile_img,member.role,phone)
	VALUES(sp_mem_id,sp_pw,sp_name,sp_gender,sp_reg_date,sp_ssn,sp_email,sp_profile_img,sp_role,sp_phone);
END insert_prof;
-- EXE_INSERT_PROF
exec hanbit.insert_prof('kim','1','김유신','MALE','2007-02-04','600113-1','kims@naver.com','kimg.png','PROFESSOR','010-9992-5042');
-- SP_COUNT_PROF
CREATE OR REPLACE PROCEDURE count_prof(
    sp_cnt OUT NUMBER
) AS
BEGIN
    SELECT COUNT(*) INTO sp_cnt FROM MEMBER WHERE role='PROFESSOR';
END count_prof;
-- EXE_COUNT_PROF
DECLARE 
    sp_count NUMBER;
BEGIN
    count_prof(sp_count);
    DBMS_OUTPUT.PUT_LINE('교수 인원 '||sp_count);
END;
-- SP_EXIST_PROF_ID
CREATE OR REPLACE PROCEDURE exist_prof_id(
    sp_prof_id IN Member.mem_id%TYPE,
    sp_cnt OUT NUMBER
) AS
BEGIN
    SELECT count(*) INTO sp_cnt FROM Member WHERE role='PROFESSOR' AND mem_id=sp_prof_id; 
END exist_prof_id;
-- EXE_EXIST_PROF_ID
DECLARE
    sp_result NUMBER;
    sp_prof_id VARCHAR2(30);
BEGIN
    sp_prof_id := 'kim';
    hanbit.exist_prof_id(sp_prof_id,sp_result);
    DBMS_OUTPUT.PUT_LINE('교수 수: '||sp_result);
END;
-- SP_FIND_BY_ID_PROF
CREATE OR REPLACE PROCEDURE find_by_id_professor(
    sp_prof_id IN Member.mem_id%TYPE,
    sp_prof OUT Member%ROWTYPE
) AS
BEGIN
    SELECT * INTO sp_prof FROM MEMBER WHERE role='PROFESSOR' AND mem_id=sp_prof_id;
END find_by_id_professor;
-- EXE_FIND_BY_ID_PROFFESSOR
DECLARE
    sp_prof_id VARCHAR2(100) := 'kim';
    sp_prof Member%ROWTYPE;
BEGIN
    hanbit.find_by_id_professor(sp_prof_id,sp_prof);
    DBMS_OUTPUT.PUT_LINE(sp_prof.name);
END;
-- SP_ALL_PROF
CREATE OR REPLACE PROCEDURE all_prof(
    prof_cur OUT SYS_REFCURSOR
) IS
BEGIN
    OPEN prof_cur FOR
    SELECT * FROM Member WHERE role='PROFESSOR';
END all_prof;
-- EXE_ALL_PROF(ALL)
DECLARE
  sp_cursor  SYS_REFCURSOR;
  sp_prof   Member%ROWTYPE;
BEGIN
  all_prof (sp_cursor);         
  LOOP 
    FETCH sp_cursor
    INTO  sp_prof;
    EXIT WHEN sp_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(sp_prof.mem_id);
  END LOOP;
  CLOSE sp_cursor;
END;
-- SP_UPDATE_PROF
CREATE OR REPLACE PROCEDURE update_prof(
    sp_prof_id IN Member.mem_id%TYPE,
    sp_pw IN Member.pw%TYPE,
    sp_email IN Member.email%TYPE,
    sp_phone IN Member.phone%TYPE
) AS BEGIN UPDATE Member SET pw=sp_pw,email=sp_email,phone=sp_phone WHERE role='PROFESSOR' AND mem_id=sp_prof_id;END update_prof;
-- EXE_UPDATE_PROF
BEGIN update_prof('kim','1','change@test.com','010-1111-1111');END;
-- SP_DELETE_PROF
CREATE OR REPLACE PROCEDURE delete_prof(sp_prof_id IN Member.mem_id%TYPE) AS BEGIN DELETE FROM MEMBER WHERE role='PROFESSOR' AND mem_id = sp_prof_id; END delete_prof;
-- EXE_DELETE_PROF
BEGIN delete_prof('kim'); END;
/*
===========GRADE GROUP============ 
@QUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-09-09
@UPDATE DATE : 2016-09-09
@DESC : 성적
============================ 
*/
-- DROP_SEQUENCE
DROP SEQUENCE grade_seq;
-- CREATE_SEQUENCE
CREATE SEQUENCE grade_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
-- DROP TABLE
DROP TABLE Grade CASCADE CONSTRAINT;
-- CREATE TABLE ORDER 3
CREATE TABLE Grade(
   grade_seq INT CONSTRAINT grade_pk PRIMARY KEY,
   grade VARCHAR2(5) NOT NULL,
   term VARCHAR2(10) NOT NULL,
   mem_id VARCHAR2(20) NOT NULL,
   CONSTRAINT fk_grade_member_id FOREIGN KEY (mem_id)   REFERENCES Member(mem_id) ON DELETE CASCADE
);
-- CREATE VIEW
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
-- SP_INSERT_GRADE
CREATE OR REPLACE PROCEDURE insert_grade(
	sp_grade IN Grade.grade%TYPE,
	sp_term IN Grade.term%TYPE,
	sp_mem_id IN Grade.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Grade(grade_seq,grade,term,mem_id)
	VALUES(grade_seq.nextval,sp_grade,sp_term,sp_mem_id);
END insert_grade;
/*
===========BOARD_QNA GROUP============ 
@QUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-09-09
@UPDATE DATE : 2016-09-09
@DESC : 게시판
============================ 
*/
-- DROP_SEQUENCE
DROP SEQUENCE art_seq;
-- CREATE_SEQUENCE
CREATE SEQUENCE art_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
-- DROP_TABLE
DROP TABLE Board CASCADE CONSTRAINT;
-- CRATE_TABLE ORDER 4
CREATE TABLE Board(
   art_seq INT CONSTRAINT board_pk PRIMARY KEY,
   category VARCHAR2(20) NOT NULL,
   title VARCHAR2(30) DEFAULT 'NO TITLE',
   reg_date VARCHAR2(20) NOT NULL,
   content VARCHAR2(100) DEFAULT 'NO CONTENT',
   mem_id VARCHAR2(20),
   CONSTRAINT fk_board_member_id FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
-- CREATE VIEW
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
-- SP_INSERT_QNS
CREATE OR REPLACE PROCEDURE insert_qna(
	sp_category IN Board.category%TYPE,
	sp_title IN Board.title%TYPE,
	sp_reg_date IN Board.reg_date%TYPE,
	sp_content IN Board.content%TYPE,
	sp_mem_id IN Board.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Board(art_seq,Board.category,title,reg_date,Board.content,mem_id)
	VALUES(art_seq.nextval,sp_category,sp_title,sp_reg_date,sp_content,sp_mem_id);
END insert_qna;
/*
===========BOARD_NOTICE GROUP============ 
@QUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-09-09
@UPDATE DATE : 2016-09-09
@DESC : 공지
============================ 
*/
-- SP_INSERT_NOTICE
CREATE OR REPLACE PROCEDURE insert_notice(
	sp_category IN Board.category%TYPE,
	sp_title IN Board.title%TYPE,
	sp_reg_date IN Board.reg_date%TYPE,
	sp_content IN Board.content%TYPE
) AS
BEGIN
	INSERT INTO Board(art_seq,Board.category,title,reg_date,Board.content)
	VALUES(art_seq.nextval,sp_category,sp_title,sp_reg_date,sp_content);
END insert_notice;
/*
===========SUBJECT GROUP============ 
@QUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-09-09
@UPDATE DATE : 2016-09-09
@DESC : 과목
============================ 
*/
-- DROP_SEQUENCE
DROP SEQUENCE subj_seq;
-- CREATE_SEQUENCE
CREATE SEQUENCE subj_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
-- DROP_TABLE
DROP TABLE Subject CASCADE CONSTRAINT;
-- CREATE_TABLE ORDER 5
CREATE TABLE Subject(
   subj_seq INT CONSTRAINT subject_pk PRIMARY KEY,
   subj_name VARCHAR2(20) NOT NULL,
   mem_id VARCHAR2(20),
   CONSTRAINT fk_subject_mem_id FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
-- SP_INSERT_SUBJECT
CREATE OR REPLACE PROCEDURE insert_subject(
   sp_subj_name IN Subject.subj_name%TYPE,
   sp_mem_id IN Subject.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Subject(subj_seq,subj_name,mem_id)
	VALUES(subj_seq.nextval,sp_subj_name,sp_mem_id);
END insert_subject; 
/*
===========EXAM GROUP============ 
@QUTHOR : 2hwooo87@gmail.com
@CREATE DATE : 2016-09-09
@UPDATE DATE : 2016-09-09
@DESC : 시험
============================ 
*/
-- DROP_SEQUENCE
DROP SEQUENCE exam_seq;
-- CREATE_SEQUENCE
CREATE SEQUENCE exam_seq START WITH 1000 INCREMENT BY 1 NOCACHE NOCYCLE;
-- DROP_TABLE
DROP TABLE Exam CASCADE CONSTRAINT;
-- CREATE_TABLE ORDER 6
CREATE TABLE Exam(
   exam_seq INT CONSTRAINT exam_seq PRIMARY KEY,
   term VARCHAR2(10) NOT NULL,
   score INT DEFAULT 0,
   subj_seq INT,
   mem_id VARCHAR2(20),
   CONSTRAINT fk_exam_subj_seq FOREIGN KEY (subj_seq) REFERENCES Subject(subj_seq) ON DELETE CASCADE,
   CONSTRAINT fk_exam_mem_id FOREIGN KEY (mem_id) REFERENCES Member(mem_id) ON DELETE CASCADE
);
-- SP_INSERT_EXAM
CREATE OR REPLACE PROCEDURE insert_exam(
   sp_term IN Exam.term%TYPE,
   sp_score IN Exam.score%TYPE,
   sp_subj_seq IN Exam.subj_seq%TYPE,
   sp_mem_id IN Exam.mem_id%TYPE
) AS
BEGIN
	INSERT INTO Exam(exam_seq,term,score,subj_seq,mem_id)
	VALUES(exam_seq.nextval,sp_term,sp_score,sp_subj_seq,sp_mem_id);
END insert_exam; 