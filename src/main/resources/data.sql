-- Job 데이터
INSERT INTO job (job_id, job_name) VALUES (1, '기획-전략');
INSERT INTO job (job_id, job_name) VALUES (2, '마케팅-홍보·조사');
INSERT INTO job (job_id, job_name) VALUES (3, '회계-세무·재무');
INSERT INTO job (job_id, job_name) VALUES (4, '인사-노무·HRD');
INSERT INTO job (job_id, job_name) VALUES (5, '총무-법무·사무');
INSERT INTO job (job_id, job_name) VALUES (6, 'IT개발-데이터');
INSERT INTO job (job_id, job_name) VALUES (7, '디자인');
INSERT INTO job (job_id, job_name) VALUES (8, '영업-판매-무역');
INSERT INTO job (job_id, job_name) VALUES (9, '고객상담-TM');
INSERT INTO job (job_id, job_name) VALUES (10, '구매-자재-물류');
INSERT INTO job (job_id, job_name) VALUES (11, '상품기획-MD');
INSERT INTO job (job_id, job_name) VALUES (12, '운전-운송-배송');
INSERT INTO job (job_id, job_name) VALUES (13, '서비스');
INSERT INTO job (job_id, job_name) VALUES (14, '생산');
INSERT INTO job (job_id, job_name) VALUES (15, '건설-건축');
INSERT INTO job (job_id, job_name) VALUES (16, '의료');
INSERT INTO job (job_id, job_name) VALUES (17, '연구-R&D');
INSERT INTO job (job_id, job_name) VALUES (18, '교육');
INSERT INTO job (job_id, job_name) VALUES (19, '미디어-문화-스포츠');
INSERT INTO job (job_id, job_name) VALUES (20, '금융-보험');
INSERT INTO job (job_id, job_name) VALUES (21, '공공-복지');


-- Enterprise 데이터
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT001', '김철수', '서비스업', 'MEDIUM', '1234567890', '100000000', 'CJ ENM', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 강남구', 'IT 타워', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT002', '이영희', '금융업', 'LARGE', '0987654321', '500000000', '삼성화재', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '부산시 해운대구', '블루 스퀘어', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT003', '최민수', 'IT', 'MEDIUM', '5678901234', '150000000', '네이버', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '경기도 성남시', '분당구', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT004', '박지영', '예술/문화', 'SMALL', '3456789012', '70000000', '카카오', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '제주시', '제주동', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT005', '이준호', '유통', 'LARGE', '4567890123', '300000000', '롯데', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '인천시 남구', '롯데타워', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT006', '김유진', '교육업', 'MEDIUM', '9876543210', '90000000', '한솔교육', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '광주시 북구', '한솔빌딩', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT007', '장희원', '제약/생명과학', 'LARGE', '8765432109', '400000000', 'LG', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '대전시 서구', 'LG타워', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT008', '박은빈', '건설업', 'LARGE', '7654321098', '800000000', '현대건설', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '울산시 남구', '현대타워', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT009', '김하늘', '서비스업', 'SMALL', '6543210987', '60000000', '에버랜드', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '경기도 용인시', '에버랜드', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT010', '최영훈', '운수업', 'MEDIUM', '5432109876', '110000000', '우바법무법인', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 서초구', '법조타운', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT011', '한승호', '의료업', 'LARGE', '4321098765', '750000000', '녹십자', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '경기도 화성시', '녹십자타운', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT012', '이서연', '마케팅-홍보', 'MEDIUM', '3210987654', '120000000', '더존', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 마포구', '더존빌딩', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT013', '최민지', '법률', 'SMALL', '2109876543', '50000000', '태희법률사무소', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '부산시 연제구', '연제동 사무소', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT014', '박준영', '유통', 'LARGE', '1098765432', '650000000', 'GS리테일', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 강서구', 'GS타워', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT015', '정하나', '엔터테인먼트', 'MEDIUM', '0198765432', '200000000', 'SM엔터테인먼트', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 송파구', '코엑스', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT016', '강철민', '자동차-기계', 'LARGE', '0987654321', '850000000', '기아자동차', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '경기도 광명시', '기아타워', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT017', '윤정수', '패션-뷰티', 'MEDIUM', '8765432101', '95000000', '아모레퍼시픽', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 용산구', '아모레타운', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT018', '김도연', '스포츠', 'SMALL', '7654321012', '70000000', '아디다스코리아', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 중구', '스포츠타운', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT019', '정혜린', '환경-에너지', 'LARGE', '6543210123', '770000000', 'SK에너지', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 영등포구', 'SK타워', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT020', '오승재', '농업/어업', 'MEDIUM', '5432101234', '130000000', '팜프렌즈', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '전라남도 나주시', '팜프라자', NOW(), NOW(), 'N');


-- Wb_User 데이터
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER001', 'M', 10, STR_TO_DATE('1985-05-20 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '서울', '서울시', '김철수', '010-1234-5678', 'kim@example.com', 'Y', 'Y', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER002', 'F', 5, STR_TO_DATE('1990-03-15 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '부산', '부산시', '이영희', '010-9876-5432', 'lee@example.com', 'Y', 'Y', 'N', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER003', 'M', 15, STR_TO_DATE('1988-08-05 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '성남', '경기도', '최민수', '010-3456-7890', 'choi@example.com', 'N', 'Y', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER004', 'F', 25, STR_TO_DATE('1992-11-10 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'N', '대전', '대전시', '박지영', '010-1234-5679', 'park@example.com', 'N', 'N', 'N', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER005', 'M', 10, STR_TO_DATE('1983-09-12 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '대구', '대구시', '장희원', '010-1234-5680', 'jang@example.com', 'Y', 'Y', 'N', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER006', 'F', 8, STR_TO_DATE('1987-02-10 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '광주', '광주시', '홍길순', '010-2345-6789', 'hong@example.com', 'Y', 'N', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER007', 'M', 20, STR_TO_DATE('1982-11-22 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'N', '인천', '인천시', '최동현', '010-3456-7891', 'choid@example.com', 'N', 'Y', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER008', 'F', 12, STR_TO_DATE('1995-06-30 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '대전', '대전시', '고수정', '010-4567-8910', 'go@example.com', 'Y', 'Y', 'N', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER009', 'M', 18, STR_TO_DATE('1989-04-25 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'N', '울산', '울산시', '이재훈', '010-5678-9101', 'leej@example.com', 'Y', 'N', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER010', 'F', 30, STR_TO_DATE('1990-09-17 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '수원', '경기도', '김하나', '010-6789-0123', 'kima@example.com', 'N', 'Y', 'N', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER011', 'M', 5, STR_TO_DATE('1993-01-05 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'N', '서울', '서울시', '박진수', '010-7890-1234', 'parkj@example.com', 'Y', 'N', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER012', 'F', 22, STR_TO_DATE('1991-07-12 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '대구', '대구시', '윤소희', '010-8901-2345', 'yoon@example.com', 'Y', 'Y', 'N', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER013', 'M', 16, STR_TO_DATE('1986-08-19 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'N', '부산', '부산시', '이강민', '010-9012-3456', 'leek@example.com', 'N', 'Y', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER014', 'F', 9, STR_TO_DATE('1994-03-22 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '광주', '광주시', '김은지', '010-0123-4567', 'kime@example.com', 'Y', 'N', 'N', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER015', 'M', 14, STR_TO_DATE('1984-12-10 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'N', '수원', '경기도', '최영수', '010-2345-6789', 'choiy@example.com', 'N', 'N', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER016', 'M', 12, STR_TO_DATE('1991-04-14 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '서울', '서울시', '이승민', '010-1111-2222', 'seungmin@example.com', 'Y', 'Y', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER017', 'F', 20, STR_TO_DATE('1988-02-18 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '부산', '부산시', '김지연', '010-3333-4444', 'jiyun@example.com', 'Y', 'Y', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER018', 'M', 18, STR_TO_DATE('1985-07-12 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '광주', '광주시', '박현우', '010-5555-6666', 'hyunwoo@example.com', 'Y', 'Y', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER019', 'F', 25, STR_TO_DATE('1992-11-23 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '대구', '대구시', '정수진', '010-7777-8888', 'sujin@example.com', 'Y', 'Y', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER020', 'M', 15, STR_TO_DATE('1983-03-30 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '울산', '울산시', '최기혁', '010-9999-1010', 'kihyuk@example.com', 'Y', 'Y', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER021', 'F', 22, STR_TO_DATE('1990-06-15 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '인천', '인천시', '조은혜', '010-1212-3434', 'eunhye@example.com', 'Y', 'Y', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER022', 'M', 10, STR_TO_DATE('1987-10-02 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '수원', '경기도', '임동혁', '010-1414-5656', 'donghyuk@example.com', 'Y', 'Y', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER023', 'F', 30, STR_TO_DATE('1995-01-28 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '성남', '경기도', '한지우', '010-1616-7878', 'jiwoo@example.com', 'Y', 'Y', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER024', 'M', 13, STR_TO_DATE('1989-12-09 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '대전', '대전시', '유현수', '010-1818-9090', 'hyunsu@example.com', 'Y', 'Y', 'Y', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, data_sharing_consent, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted) VALUES ('USER025', 'F', 27, STR_TO_DATE('1993-09-19 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), 'Y', '제주', '제주시', '송하늘', '010-2020-1212', 'haneul@example.com', 'Y', 'Y', 'Y', 'N');

-- Employment 데이터 (외래 키로 wb_user와 enterprise 필요)
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (1, NOW(), 'Y', 'Y', 'ENT001', 'USER001', 1);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (2, NOW(), 'N', 'Y', 'ENT002', 'USER002', 2);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (3, NOW(), 'Y', 'Y', 'ENT003', 'USER003', 3);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (4, NOW(), 'N', 'N', 'ENT004', 'USER004', 4);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (5, NOW(), 'Y', 'Y', 'ENT005', 'USER005', 5);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (6, '2024-09-01', 'Y', 'Y', 'ENT001', 'USER006', 1);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (7, '2024-09-12', 'N', 'Y', 'ENT001', 'USER007', 2);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (8, '2024-09-23', 'Y', 'Y', 'ENT002', 'USER008', 2);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (9, '2024-09-30', 'Y', 'Y', 'ENT002', 'USER009', 1);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (10, '2024-10-03', 'Y', 'N', 'ENT001', 'USER010', 3);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (11, '2024-10-10', 'Y', 'Y', 'ENT003', 'USER011', 1);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (12, '2024-10-15', 'N', 'Y', 'ENT001', 'USER012', 2);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (13, '2024-10-20', 'Y', 'Y', 'ENT002', 'USER013', 1);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (14, '2024-10-25', 'Y', 'N', 'ENT004', 'USER014', 3);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (15, '2024-10-30', 'Y', 'Y', 'ENT001', 'USER015', 1);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (16, '2024-09-05', 'Y', 'Y', 'ENT002', 'USER001', 2);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (17, '2024-09-10', 'N', 'Y', 'ENT003', 'USER002', 4);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (18, '2024-09-18', 'Y', 'Y', 'ENT001', 'USER003', 1);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (19, '2024-09-22', 'Y', 'Y', 'ENT002', 'USER004', 2);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (20, '2024-09-27', 'Y', 'N', 'ENT001', 'USER005', 5);


-- Job_Posting 데이터 (외래 키로 job과 enterprise 필요)
INSERT INTO job_posting (post_id, start_date, end_date, job_id, post_title, ent_id, post_img, posting_cnt, created_at)
VALUES
    (1, NOW() - INTERVAL '10' DAY, NOW() + INTERVAL '20' DAY, 1, '전략 기획 전문가 모집', 'ENT001', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/cj_enm.png', 0, NOW() - INTERVAL '10' DAY),
    (2, NOW() - INTERVAL '30' DAY, NOW() + INTERVAL '60' DAY, 2, '마케팅·홍보 담당자 채용', 'ENT002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/samsung_hwaje.jpeg', 5, NOW() - INTERVAL '30' DAY),
    (3, NOW() - INTERVAL '45' DAY, NOW() + INTERVAL '15' DAY, 3, '회계·세무 경력자 구인', 'ENT003', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/naver.jpg', 12, NOW() - INTERVAL '45' DAY),
    (4, NOW() - INTERVAL '60' DAY, NOW() + INTERVAL '90' DAY, 4, 'HRD 인사·노무 담당자 채용', 'ENT004', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/kakao.png', 8, NOW() - INTERVAL '60' DAY),
    (5, NOW() - INTERVAL '5' DAY, NOW() + INTERVAL '10' DAY, 5, '총무·법무 사무관리자 모집', 'ENT005', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/lotte.png', 23, NOW() - INTERVAL '5' DAY),
    (6, NOW() + INTERVAL '10' DAY, NOW() + INTERVAL '60' DAY, 6, '데이터 엔지니어 및 개발자 채용', 'ENT006', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/hansol_education.jpg', 5, NOW() + INTERVAL '10' DAY),
    (7, NOW() + INTERVAL '30' DAY, NOW() + INTERVAL '120' DAY, 7, '그래픽 디자이너 모집', 'ENT007', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/LG.png', 10, NOW() + INTERVAL '30' DAY),
    (8, NOW() - INTERVAL '5' DAY, NOW() + INTERVAL '30' DAY, 8, '영업·판매 전문 인재 구인', 'ENT008', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/hyundai.png', 3, NOW() - INTERVAL '5' DAY),
    (9, NOW() - INTERVAL '20' DAY, NOW() + INTERVAL '60' DAY, 9, '고객 상담·TM 경력자 모집', 'ENT009', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/everland.png', 18, NOW() - INTERVAL '20' DAY),
    (10, NOW() - INTERVAL '10' DAY, NOW() + INTERVAL '45' DAY, 10, '구매·자재 물류 담당자 채용', 'ENT010', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/wb_logo.png', 27, NOW() - INTERVAL '10' DAY),
    (11, NOW() + INTERVAL '15' DAY, NOW() + INTERVAL '60' DAY, 11, 'MD 상품기획 전문가 모집', 'ENT011', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/nocksibja.jpeg', 6, NOW() + INTERVAL '15' DAY),
    (12, NOW() + INTERVAL '30' DAY, NOW() + INTERVAL '90' DAY, 12, '운전·운송·배송 직원 채용', 'ENT012', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/douzone.png', 20, NOW() + INTERVAL '30' DAY),
    (13, NOW() - INTERVAL '60' DAY, NOW() + INTERVAL '75' DAY, 13, '서비스 관리 담당자 모집', 'ENT013', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/teahui.jpeg', 15, NOW() - INTERVAL '60' DAY),
    (14, NOW() + INTERVAL '45' DAY, NOW() + INTERVAL '90' DAY, 14, '생산 현장 기술자 구인', 'ENT014', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/gs_retail.png', 4, NOW() + INTERVAL '45' DAY),
    (15, NOW() - INTERVAL '5' DAY, NOW() + INTERVAL '60' DAY, 15, '건설·건축 전문 엔지니어 채용', 'ENT015', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/sm.png', 25, NOW() - INTERVAL '5' DAY),
    (16, NOW() + INTERVAL '20' DAY, NOW() + INTERVAL '30' DAY, 16, '의료 전문직 구인', 'ENT016', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/kia.png', 2, NOW() + INTERVAL '20' DAY),
    (17, NOW() + INTERVAL '5' DAY, NOW() + INTERVAL '120' DAY, 17, 'R&D 연구개발 전문가 모집', 'ENT017', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/amore_pacific.jpeg', 9, NOW() + INTERVAL '5' DAY),
    (18, NOW() - INTERVAL '30' DAY, NOW() + INTERVAL '45' DAY, 18, '교육 컨설턴트 채용', 'ENT018', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/adidas.png', 30, NOW() - INTERVAL '30' DAY),
    (19, NOW() - INTERVAL '20' DAY, NOW() + INTERVAL '30' DAY, 1, '신규 사업 전략 기획자 모집', 'ENT019', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/sk_energy.png', 12, NOW() - INTERVAL '20' DAY),
    (20, NOW() - INTERVAL '10' DAY, NOW() + INTERVAL '60' DAY, 2, '마케팅 전문가 채용', 'ENT020', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/pharm_friends.png', 5, NOW() - INTERVAL '10' DAY),
    (21, NOW() - INTERVAL '5' DAY, NOW() + INTERVAL '45' DAY, 1, '경영 전략 수립 전문가 모집', 'ENT001', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/cj_enm.png', 8, NOW() - INTERVAL '5' DAY),
    (22, NOW() - INTERVAL '15' DAY, NOW() + INTERVAL '30' DAY, 2, '브랜드 마케팅 전략가 모집', 'ENT002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/samsung_hwaje.jpeg', 20, NOW() - INTERVAL '15' DAY),
    (23, NOW() - INTERVAL '25' DAY, NOW() + INTERVAL '60' DAY, 1, '사업 기획 경력자 채용', 'ENT003', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/naver.jpg', 15, NOW() - INTERVAL '25' DAY);

-- 지원현황
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (1, '1', 'USER001', 'PENDING', STR_TO_DATE('2024-11-01', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (2, '2', 'USER002', 'PENDING', STR_TO_DATE('2024-11-01', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (3, '1', 'USER001', 'PENDING', STR_TO_DATE('2024-10-01', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (4, '2', 'USER002', 'PENDING', STR_TO_DATE('2024-10-03', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (5, '3', 'USER003', 'PENDING', STR_TO_DATE('2024-10-07', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (6, '1', 'USER001', 'ACCEPTED', STR_TO_DATE('2024-10-10', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (7, '2', 'USER003', 'PENDING', STR_TO_DATE('2024-10-12', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (8, '3', 'USER001', 'REJECTED', STR_TO_DATE('2024-10-15', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (9, '1', 'USER002', 'PENDING', STR_TO_DATE('2024-10-18', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (10, '4', 'USER004', 'PENDING', STR_TO_DATE('2024-10-20', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (11, '5', 'USER005', 'CANCELED', STR_TO_DATE('2024-10-22', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (12, '1', 'USER001', 'PENDING', STR_TO_DATE('2024-10-25', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (13, '2', 'USER003', 'PENDING', STR_TO_DATE('2024-10-28', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (14, '6', 'USER006', 'PENDING', STR_TO_DATE('2024-10-30', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (15, '1', 'USER002', 'PENDING', STR_TO_DATE('2024-11-01', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (16, '2', 'USER003', 'ACCEPTED', STR_TO_DATE('2024-11-05', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (17, '3', 'USER001', 'PENDING', STR_TO_DATE('2024-11-10', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (18, '7', 'USER007', 'PENDING', STR_TO_DATE('2024-11-12', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (19, '8', 'USER008', 'REJECTED', STR_TO_DATE('2024-11-15', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (20, '1', 'USER001', 'PENDING', STR_TO_DATE('2024-11-18', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (21, '2', 'USER002', 'CANCELED', STR_TO_DATE('2024-11-22', '%Y-%m-%d'));
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date) VALUES (22, '3', 'USER003', 'PENDING', STR_TO_DATE('2024-11-28', '%Y-%m-%d'));

-- 노하우
INSERT INTO knowhow (knowhow_id, knowhow_job, knowhow_title, knowhow_content, upload_date, user_id)
VALUES
    (1, 'IT개발-데이터', '효율적인 디버깅 기술', '시간을 절약하고 생산성을 높이는 디버깅 기술을 배워보세요.', STR_TO_DATE('2024-11-05', '%Y-%m-%d'), 'USER001'),
    (2, 'IT개발-데이터', '예측 모델 구축 가이드', '머신러닝을 활용한 예측 모델 구축의 단계별 가이드입니다.', STR_TO_DATE('2024-11-04', '%Y-%m-%d'), 'USER001'),
    (3, '기획-전략', '효율적인 이해관계자 커뮤니케이션', '프로젝트 이해관계자와 효과적으로 소통하는 전략을 소개합니다.', STR_TO_DATE('2024-11-03', '%Y-%m-%d'), 'USER001'),
    (4, '디자인', '사용자 중심 디자인 원칙', '더 나은 사용자 경험을 위한 사용자 중심 디자인 원칙에 대해 알아보세요.', STR_TO_DATE('2024-11-02', '%Y-%m-%d'), 'USER002'),
    (5, 'IT개발-데이터', '서버 성능 최적화', '서버 성능을 최적화하고 안정성을 보장하는 팁과 기술을 공유합니다.', STR_TO_DATE('2024-11-01', '%Y-%m-%d'), 'USER002');

-- 이력서
INSERT INTO resume (resume_id, user_id, user_img, resume_email, user_intro) VALUES
  (1, 'USER001', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user001.jpg', 'kim@example.com', '전략 기획 경력이 풍부한 전문가로서 데이터 기반 분석에 강점을 가지고 있습니다.'),
  (2, 'USER002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user002.jpg', 'lee@example.com', '고객 중심 마케팅과 데이터 분석을 통해 성과를 낸 마케팅 전문가입니다.'),
  (3, 'USER003', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user003.jpg', 'choi@example.com', 'IT 분야에서 15년 이상의 경험을 바탕으로 시스템 구축과 최적화 프로젝트를 성공적으로 이끌었습니다. 새로운 도전과 성장을 추구하고 있습니다.'),
  (4, 'USER004', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user004.jpg', 'park@example.com', '10년간 UI/UX 디자인 경험을 통해 사용자 친화적인 인터페이스를 설계하며 브랜드 가치를 높였습니다. 창의적인 문제 해결에 강점을 가지고 있습니다.'),
  (5, 'USER005', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user005.jpg', 'jang@example.com', '물류 및 유통 관리 전문가로서, 효율적인 재고 관리와 공급망 최적화 프로젝트를 성공적으로 수행했습니다. 데이터 기반 의사결정을 중시합니다.'),
  (6, 'USER006', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user006.jpg', 'hong@example.com', '교육 분야에서 12년 이상 경력을 쌓아온 전문가로, 학습 프로그램 개발과 교사 연수를 통해 성과를 이끌어냈습니다.'),
  (7, 'USER007', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user007.jpg', 'choid@example.com', 'R&D 부문에서 20년 이상 경력을 쌓으며 신기술 개발과 특허 출원 프로젝트를 성공적으로 이끌었습니다. 혁신과 팀워크를 중시합니다.'),
  (8, 'USER008', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user008.jpg', 'go@example.com', '5년간 공공 기관에서 기획 업무를 담당하며 정책 수립과 행정 업무 효율화를 주도했습니다. 조직 관리 경험이 풍부합니다.'),
  (9, 'USER009', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user009.jpg', 'leej@example.com', '제조업 분야에서 18년간 근무하며 생산 공정 개선과 품질 관리 프로젝트를 수행했습니다. Lean Manufacturing에 전문성을 보유하고 있습니다.'),
  (10, 'USER010', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user010jpg', 'kima@example.com', '30년간 의료기기 영업에서 연속 매출 성장을 이끌어내며 팀 리더로서 성과를 창출했습니다. 고객 중심의 솔루션 제공에 강점이 있습니다.'),
  (11, 'USER011', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user011.jpg', 'parkj@example.com', 'IT 기술 지원 전문가로서 클라우드 기반 시스템 구축과 고객 지원을 통해 높은 고객 만족도를 유지했습니다. 변화 관리 경험이 있습니다.'),
  (12, 'USER012', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user012.jpg', 'yoon@example.com', '20년간 금융 분석과 리스크 관리 분야에서 경력을 쌓았으며, 데이터 분석을 통한 성과 예측에 강점을 보유하고 있습니다.'),
  (13, 'USER013', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user013.jpg', 'leek@example.com', '영업 및 마케팅 전문가로서 25년간 글로벌 기업과 협업하며 매출 성장을 이뤄냈습니다. 데이터 기반 캠페인 설계에 전문성을 가지고 있습니다.'),
  (14, 'USER014', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user014.jpg', 'kime@example.com', '뷰티 산업에서 신제품 개발 프로젝트를 10년간 성공적으로 주도하며 트렌드를 반영한 제품 기획에 강점을 보유하고 있습니다.'),
  (15, 'USER015', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user015.jpg', 'choiy@example.com', '법무 전문가로서 30년 이상 기업 자문 및 계약 검토를 수행했습니다. 복잡한 문제를 해결하는 능력에 자신이 있습니다.'),
  (16, 'USER016', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user016.jpg', 'seungmin@example.com', '건설업 분야에서 프로젝트 관리자로서 대규모 건축 프로젝트를 성공적으로 완수하였습니다. 리더십과 예산 관리 경험이 풍부합니다.'),
  (17, 'USER017', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user017.jpg', 'jiyun@example.com', '마케팅 및 PR 전문가로서 15년간 브랜드 가치를 증대시키는 데 기여했습니다. 창의적인 콘텐츠 기획에 강점을 보유하고 있습니다.'),
  (18, 'USER018', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user018.jpg', 'hyunwoo@example.com', '국제 물류 전문가로서 수출입 프로세스 최적화와 비용 절감 프로젝트를 성공적으로 수행했습니다. 팀 협업과 의사소통이 뛰어납니다.'),
  (19, 'USER019', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user019.jpg', 'sujin@example.com', '환경 컨설팅 분야에서 지속 가능성을 고려한 프로젝트를 12년간 성공적으로 진행하였습니다. 데이터 분석과 정책 제안에 강점을 가지고 있습니다.'),
  (20, 'USER020', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user020.jpg', 'kihyuk@example.com', '자동차 산업에서 15년간 생산 관리 및 설비 유지보수 업무를 담당하며 가동률 개선 프로젝트를 성공적으로 이끌었습니다.'),
  (21, 'USER021', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user021.jpg', 'minho@example.com', 'IT 아키텍트로서 10년간 클라우드 인프라 설계와 최적화를 성공적으로 수행했습니다. 효율성과 안정성을 중시합니다.'),
  (22, 'USER022', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user022.jpg', 'eunji@example.com', '교육 콘텐츠 제작 전문가로서 온라인 학습 자료 개발과 혁신적인 교수법 도입에 기여했습니다. 창의성과 열정을 가지고 있습니다.'),
  (23, 'USER023', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user023.jpg', 'soohyun@example.com', 'HR 전문가로서 8년간 채용과 조직 개발 프로젝트를 이끌며 기업의 성장에 기여했습니다. 사람 중심의 접근 방식을 지향합니다.'),
  (24, 'USER024', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user024.jpg', 'junho@example.com', '그래픽 디자이너로서 7년간 창의적이고 효과적인 브랜드 아이덴티티 구축 프로젝트를 수행했습니다. 시각적 스토리텔링에 강점을 가지고 있습니다.'),
  (25, 'USER025', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/wbUserImage/user025.jpg', 'yuri@example.com', '의료 데이터 분석 전문가로서 6년간 연구 데이터를 통해 치료 효율성을 향상시키는 데 기여했습니다. 정확성과 세부사항에 강합니다.');

INSERT INTO admin (admin_id, admin_name, admin_pw, admin_type)
VALUES (
           'admin1',  -- ID는 20자 이내
           '김철수',     -- 이름은 10자 이내
           '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6',  -- 60자 비밀번호 (1234)
           'ROLE_SERVICE_ADMIN'     -- AdminType enum 값
       );

INSERT INTO admin (admin_id, admin_name, admin_pw, admin_type)
VALUES (
           'admin2',  -- ID는 20자 이내
           '김영희',     -- 이름은 10자 이내
           '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6',  -- 60자 비밀번호 (1234)
           'ROLE_INFRA_ADMIN'     -- AdminType enum 값
       );

-- WorkHistory Data
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (1, 1, 'USER001');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (2, 1, 'USER002');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (3, 5, 'USER005');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (4, 1, 'USER001');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (5, 2, 'USER002');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (6, 3, 'USER005');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (7, 2, 'USER006');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (8, 1, 'USER008');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (9, 3, 'USER012');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (10, 2, 'USER013');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (11, 1, 'USER015');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (12, 1, 'USER001');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (13, 3, 'USER002');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (14, 1, 'USER006');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (15, 2, 'USER008');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (16, 3, 'USER005');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (17, 2, 'USER013');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (18, 1, 'USER012');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (19, 2, 'USER001');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (20, 3, 'USER002');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (21, 1, 'USER015');
