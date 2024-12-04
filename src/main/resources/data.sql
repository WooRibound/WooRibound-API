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
INSERT INTO job (job_id, job_name) VALUES (22, '기타');

-- Enterprise 데이터
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT001', '김철수', 'IT', 'MEDIUM', '1234567890', '150000000', '포스코DX', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 강남구', '포스코타워', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT002', '이영희', '의료/보건', 'SMALL', '0987654321', '70000000', '대한보건의료정보관리사협회', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 종로구', '보건타워', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT003', '최민수', '문화/예술', 'SMALL', '5678901234', '50000000', '제주특별자치도', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '제주시', '관광문화센터', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT004', '박지영', '항공업', 'LARGE', '3456789012', '500000000', '대한항공', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 강서구', '대한항공본사', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT005', '이준호', '교육업', 'MEDIUM', '4567890123', '90000000', '동부여성발전센터', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 동대문구', '여성발전센터', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT006', '김유진', '교육업', 'MEDIUM', '9876543210', '85000000', 'MIRI GROUP', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 강남구', 'MIRI타워', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT007', '장희원', '의료/보건', 'MEDIUM', '8765432109', '100000000', '보험심사간호사회', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 중구', '의료상담센터', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT008', '박은빈', '공공기관', 'LARGE', '7654321098', '400000000', '한국사회적기업진흥원', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 성동구', '사회적기업지원센터', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT009', '김하늘', '문화/예술', 'SMALL', '6543210987', '75000000', '금오종합사회복지관', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '경상북도 구미시', '금오복지관', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT010', '최영훈', 'IT', 'SMALL', '5432109876', '70000000', 'LINE', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 강남구', 'MIRI타워', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT011', '김유진', '제약/생명과학', 'LARGE', '1234567890', '900000000', '푸른밀', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 강남구', '헬스케어타운', NOW(), NOW(), 'N'),
       ('ENT012', '이도현', 'IT', 'MEDIUM', '2345678901', '500000000', '푸른IT', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 구로구', 'IT센터', NOW(), NOW(), 'N'),
       ('ENT013', '정수연', '교육업', 'LARGE', '3456789012', '800000000', '천재교육', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 양천구', '천재교육타운', NOW(), NOW(), 'N'),
       ('ENT014', '박찬호', '서비스업', 'LARGE', '4567890123', '700000000', 'GS리테일', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 강서구', 'GS타워', NOW(), NOW(), 'N'),
       ('ENT015', '송예지', '예술/문화', 'MEDIUM', '5678901234', '200000000', '강남구청', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '경기도 성남시', '레저타운', NOW(), NOW(), 'N'),
       ('ENT016', '이수정', '예술/문화', 'SMALL', '6789012345', '100000000', '예쁜마음(주)', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 종로구', '공예타운', NOW(), NOW(), 'N'),
       ('ENT017', '김민수', '관광/레저', 'MEDIUM', '7890123456', '300000000', '전주지자체', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '경상남도 진주시', '문화센터', NOW(), NOW(), 'N'),
       ('ENT018', '이재훈', '요식업', 'LARGE', '8901234567', '600000000', 'SK하이닉스', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '경기도 이천시', 'SK타운', NOW(), NOW(), 'N'),
       ('ENT019', '최현우', 'IT', 'SMALL', '9012345678', '150000000', '감동물산', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 금천구', '데이터타운', NOW(), NOW(), 'N'),
       ('ENT020', '유지은', '예술/문화', 'MEDIUM', '0123456789', '700000000', '금천구청', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '대전광역시 유성구', '바이오타운', NOW(), NOW(), 'N');


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
    (1, NOW() - INTERVAL '10' DAY, NOW() + INTERVAL '20' DAY, 1, 'Oracle ERP 전문가 모집', 'ENT001', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/OracleERP.png', 0, NOW() - INTERVAL '10' DAY),
    (2, NOW() - INTERVAL '30' DAY, NOW() + INTERVAL '60' DAY, 9, '금연상담사 기간제 계약직 모집', 'ENT002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/금연상담사.png', 5, NOW() - INTERVAL '30' DAY),
    (3, NOW() - INTERVAL '45' DAY, NOW() + INTERVAL '15' DAY, 19, '지역 역사 및 문화 해설사 모집', 'ENT003', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/문화해설사.png', 12, NOW() - INTERVAL '45' DAY),
    (4, NOW() - INTERVAL '60' DAY, NOW() + INTERVAL '90' DAY, 9, '국제선 예약 전문 상담원 모집', 'ENT004', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/상담원.png', 8, NOW() - INTERVAL '60' DAY),
    (5, NOW() - INTERVAL '5' DAY, NOW() + INTERVAL '10' DAY, 19, '셔플댄스 강사 모집', 'ENT005', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/셔플댄스강사.png', 23, NOW() - INTERVAL '5' DAY),
    (6, NOW() + INTERVAL '10' DAY, NOW() + INTERVAL '60' DAY, 1, '스케줄 관리 전문가 모집', 'ENT006', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/스케줄관리사.png', 5, NOW() + INTERVAL '10' DAY),
    (7, NOW() + INTERVAL '30' DAY, NOW() + INTERVAL '120' DAY, 19, '2024 원예교실 강사 모집', 'ENT009', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/원예강사.png', 10, NOW() + INTERVAL '30' DAY),
    (8, NOW() - INTERVAL '5' DAY, NOW() + INTERVAL '30' DAY, 13, '인사팀 보조직원 모집', 'ENT010', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/인사팀보조.png', 3, NOW() - INTERVAL '5' DAY),
    (9, NOW() - INTERVAL '20' DAY, NOW() + INTERVAL '60' DAY, 16, '의료자문 담당 간호사 모집', 'ENT007', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/자문간호사.png', 18, NOW() - INTERVAL '20' DAY),
    (10, NOW() - INTERVAL '10' DAY, NOW() + INTERVAL '45' DAY, 17, '사회적기업진흥원 외부전문가 모집', 'ENT008', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/자문위원.png', 27, NOW() - INTERVAL '10' DAY),
    (11, NOW() + INTERVAL '15' DAY, NOW() + INTERVAL '60' DAY, 11, '건강기능식품 개발 전문가 모집', 'ENT011', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/health.png', 6, NOW() + INTERVAL '15' DAY),
    (12, NOW() + INTERVAL '30' DAY, NOW() + INTERVAL '90' DAY, 6, '데이터 입력 및 정리 사무직 모집', 'ENT019', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/data.png', 20, NOW() + INTERVAL '30' DAY),
    (13, NOW() - INTERVAL '60' DAY, NOW() + INTERVAL '75' DAY, 22, '구내식당 단체 조리사 모집', 'ENT018', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/restrant.png', 15, NOW() - INTERVAL '60' DAY),
    (14, NOW() + INTERVAL '45' DAY, NOW() + INTERVAL '90' DAY, 19, '지역 역사 해설사 모집', 'ENT017', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/dosent.png', 4, NOW() + INTERVAL '45' DAY),
    (15, NOW() - INTERVAL '5' DAY, NOW() + INTERVAL '60' DAY, 19, '수공예 상품 제작자 모집', 'ENT016', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/create.png', 25, NOW() - INTERVAL '5' DAY),
    (16, NOW() + INTERVAL '20' DAY, NOW() + INTERVAL '30' DAY, 13, '노인·중장년층 대상 건강 및 취미 활동 지도', 'ENT015', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/hobby.png', 2, NOW() + INTERVAL '20' DAY),
    (17, NOW() + INTERVAL '5' DAY, NOW() + INTERVAL '120' DAY, 8, '점포 관리자 모집', 'ENT014', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/magagement.png', 9, NOW() + INTERVAL '5' DAY),
    (18, NOW() - INTERVAL '30' DAY, NOW() + INTERVAL '45' DAY, 9, '자녀교육 상담사 모집', 'ENT013', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/education.png', 30, NOW() - INTERVAL '30' DAY),
    (19, NOW() - INTERVAL '20' DAY, NOW() + INTERVAL '30' DAY, 19, '라디오 프로그램을 통해 만나는 새로운 기회!', 'ENT020', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/radio.png', 12, NOW() - INTERVAL '20' DAY),
    (20, NOW() - INTERVAL '10' DAY, NOW() + INTERVAL '60' DAY, 6, '델파이 개발자 모집', 'ENT012', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/developer.png', 5, NOW() - INTERVAL '10' DAY);
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
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (4, 2, 'USER006');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (5, 1, 'USER008');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (6, 3, 'USER012');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (7, 2, 'USER013');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (8, 1, 'USER015');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (9, 1, 'USER001');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (10, 2, 'USER002');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (11, 3, 'USER005');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (12, 3, 'USER002');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (13, 2, 'USER001');
INSERT INTO work_history (exjob_id, job_id, user_id) VALUES (14, 3, 'USER013');

-- interest jobs
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (1, 6, 'USER001'); -- IT개발-데이터
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (2, 1, 'USER001'); -- 기획-전략
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (3, 3, 'USER001'); -- 회계-세무·재무
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (4, 8, 'USER002'); -- 영업-판매-무역
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (5, 2, 'USER002'); -- 마케팅-홍보·조사
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (6, 5, 'USER002'); -- 총무-법무·사무
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (7, 6, 'USER005'); -- IT개발-데이터
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (8, 17, 'USER005'); -- 연구-R&D
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (9, 20, 'USER005'); -- 금융-보험
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (10, 7, 'USER008'); -- 디자인
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (11, 10, 'USER008'); -- 구매-자재-물류
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (12, 6, 'USER012'); -- IT개발-데이터
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (13, 1, 'USER013'); -- 기획-전략
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (14, 2, 'USER013'); -- 마케팅-홍보·조사
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (15, 6, 'USER016'); -- IT개발-데이터
INSERT INTO wb.interest_job (interest_id, job_id, user_id) VALUES (16, 8, 'USER017'); -- 영업-판매-무역

