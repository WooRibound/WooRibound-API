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
VALUES ('ENT002', '이영희', '의료업', 'SMALL', '0987654321', '70000000', '대한보건의료정보관리사협회', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 종로구', '보건타워', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT003', '최민수', '예술/문화', 'SMALL', '5678901234', '50000000', '제주특별자치도', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '제주시', '관광문화센터', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT004', '박지영', '관광/레저', 'LARGE', '3456789012', '500000000', '대한항공', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 강서구', '대한항공본사', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT005', '이준호', '교육업', 'MEDIUM', '4567890123', '90000000', '동부여성발전센터', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 동대문구', '여성발전센터', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT006', '김유진', '교육업', 'MEDIUM', '9876543210', '85000000', 'MIRI GROUP', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 강남구', 'MIRI타워', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT007', '장희원', '의료업', 'MEDIUM', '8765432109', '100000000', '보험심사간호사회', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 중구', '의료상담센터', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT008', '박은빈', '기타', 'LARGE', '7654321098', '400000000', '한국사회적기업진흥원', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '서울시 성동구', '사회적기업지원센터', NOW(), NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, updated_at, is_deleted)
VALUES ('ENT009', '김하늘', '예술/문화', 'SMALL', '6543210987', '75000000', '금오종합사회복지관', '$2a$12$xsgxi5yRyUNfdlW9xQs9z.3Y68ssLjCfRWg81wMCax1S02uOOmyn6', '경상북도 구미시', '금오복지관', NOW(), NOW(), 'N');
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
(1, '교육', 'IT 강사로서의 역량',
' 1. IT 강사로 30년 동안 근무했습니다. 주로 학생들과 재직자들을 대상으로 수업을 진행했는데, 수강생들의 수준에 맞게 수업을 구성하고 진행하는 것이 제 역할이었습니다.\n\n
2. 예를 들어, 수업 중 학생들의 이해도가 낮아 수업 내용을 이해하지 못하는 경우가 있었는데, 이때는 다양한 예시와 비유를 활용하여 개념을 명확하게 설명해주어 학생들이 이해할 수 있도록 도와주었습니다. 또한, 학생들의 피드백을 수용하여 수업 방식을 조정하고 보완하는 데 주력했습니다.\n\n
3. IT 기술을 가르치는 과정에서 사용되는 전문 용어나 개념들을 학생들이 쉽게 이해할 수 있도록 쉽고 명확하게 설명하는 것이 중요했습니다.\n\n
4. 항상 최신 기술 동향을 파악하고 학습하여, 학생들에게 최신 기술 및 트렌드에 대한 정보를 제공해주어 학생들이 실무에서 더 유용하게 활용할 수 있도록 돕는 것이 중요했습니다.\n\n
5. IT 강사로서의 경험을 통해, 학생들이 이해하기 쉽도록 설명하는 능력과 피드백을 통해 수업을 지속적으로 개선하는 능력을 키웠습니다.\n\n
**필수 자격 요건:**\n
1. IT 분야 전문 지식\n
2. 교육 또는 교육학 관련 학위 또는 자격증\n
3. 커뮤니케이션 및 피드백 수용 능력',
STR_TO_DATE('2024-12-04', '%Y-%m-%d'), 'USER001'),
(2, '금융-보험', '보험 상품 개발 및 리스크 관리의 핵심 전략',
'1. 저는 금융-보험 분야에서 12년 동안 일했습니다. 주로 보험 상품 개발과 리스크 관리를 담당했습니다.\n\n
2. 또한, 리스크 관리 업무를 맡아 고객의 위험 프로파일을 분석하고, 적절한 리스크 관리 전략을 제안했습니다. 이를 통해 고객들의 리스크를 10% 이상 감소시키는 데 기여했습니다.\n\n
3. 프로젝트 관리 및 팀 리더로서, 효율적인 업무 진행을 위해 팀원들 간의 협업을 조율하고, 일정 및 예산을 관리했습니다. 또한, 고객의 요구를 분석하여 맞춤형 보험 솔루션을 제공하여 고객 만족도를 높였습니다.\n\n
4. 금융-보험 분야에서 일할 때 중요한 것은 보험 상품 개발과 리스크 관리 능력입니다. 또한, 프로젝트 관리와 팀 리더십 능력도 필요합니다.\n\n
**필수 자격 요건:**\n
1. 금융-보험 분야에서의 근무 경험\n
2. 보험 상품 개발 및 리스크 관리 능력\n
3. 프로젝트 관리 및 팀 리더십 경험',
STR_TO_DATE('2024-11-04', '%Y-%m-%d'), 'USER002'),
(3, '서비스', '한식집 운영의 핵심, 위생과 친절한 서비스',
'1. 10년간 한식집을 운영하면서 주로 위생과 친절한 서비스를 담당했습니다.\n\n
2. 위생 측면에서는 주방과 음식 관련 공간을 깨끗하게 유지하고, 식재료의 유통기한을 철저히 관리하여 음식 안전을 유지했습니다. 또한 직원들에게 위생 교육을 실시하여 안심하고 음식을 즐길 수 있는 환경을 조성했습니다. 서비스 측면에서는 손님들을 항상 웃으면서 환영하고, 주문 및 음식 제공 과정에서 신속하고 정확한 서비스를 제공하여 손님들의 만족도를 높였습니다.\n\n
3. 위생은 주방과 음식 관련 공간을 깨끗하게 유지하고, 식재료 관리를 통해 음식 안전을 지키는 것을 말합니다. 친절한 서비스는 손님들을 환영하고 응대하는 것뿐만 아니라, 주문 및 음식 제공 과정에서 손님들에게 신속하고 정확한 서비스를 제공하는 것을 의미합니다.\n\n
4. 10년간 한식집을 운영하면서 위생과 친절한 서비스를 중요하게 생각하고 이를 실천하여 손님들로부터 긍정적인 평가를 받았습니다.\n\n
5. 이 경험은 한식음식점 운영에 관심이 있는 사람들에게 위생과 서비스 중요성을 강조하고, 손님들과의 소통과 서비스 제공의 중요성을 알려줄 수 있습니다.\n\n
**추가 정보:**\n
1. 위생 및 식품안전에 대한 이해\n
2. 고객 응대 및 서비스 경험\n
3. 식당 운영에 대한 지식 및 경험',
STR_TO_DATE('2024-12-02', '%Y-%m-%d'), 'USER003'),
(4, 'IT개발-데이터', '자바 개발자 경험을 통한 금융 차세대 프로젝트 PM 노하우',
'1. 저는 15년 동안 자바 개발자로 근무했습니다. 주로 금융 분야의 차세대 프로젝트에 참여하여 소프트웨어를 개발하고 유지보수를 진행했습니다.\n\n
2. PM 경험을 통해 인력 및 일정 관리 능력을 향상시켰습니다. 예를 들어, 프로젝트 팀원들 간의 업무 분담을 효율적으로 조정하여 프로젝트 완료 기간을 단축시키고 성과를 극대화했습니다.\n\n
3. 금융 분야의 차세대 프로젝트에 참여하면서 쌓은 경험과 PM 역할을 수행하면서 얻은 노하우를 통해 효율적인 인력 및 일정 관리를 실천했습니다.\n\n
4. 자바 개발자로서의 경험을 바탕으로 금융 분야의 차세대 프로젝트에 대한 이해와 PM 역할을 수행하는 경험을 통해 팀원들과의 협업을 강화하고 프로젝트 성과를 극대화했습니다.\n\n
**추가 정보:**\n
1. 자바 개발 경력 15년\n
2. 금융 분야 차세대 프로젝트 참여 경험\n
3. PM 경험을 통한 인력 및 일정 관리 능력\n
4. 소프트웨어 개발 관련 자격증 (선택사항)',
STR_TO_DATE('2024-12-04', '%Y-%m-%d'), 'USER004'),
(5, '마케팅-홍보·조사', '효과적인 디지털 마케팅 전략 구축 방법',
'1. 저는 디지털 마케팅 분야에서 8년 동안 일해왔습니다. 주로 소셜 미디어 마케팅, 검색 엔진 최적화(SEO), 콘텐츠 마케팅 전략을 개발하고 실행했습니다.\n\n
2. SEO와 콘텐츠 마케팅 전략을 결합하여 검색 엔진 결과에서 사이트의 순위를 40% 이상 향상시켰습니다.\n\n
3. 소셜 미디어 캠페인을 통해 브랜드 인지도를 높이고, 6개월 만에 팔로워 수를 25% 증가시킨 경험이 있습니다.\n\n
4. 디지털 마케팅에서 중요한 것은 데이터 분석을 통한 전략적 접근입니다. 고객의 행동을 분석하고, 그에 맞춰 캠페인을 조정하는 능력이 필요합니다.\n\n
5. 향후 디지털 마케팅의 트렌드 변화에 발맞춰 새로운 기술들을 학습하고 실무에 적용하여 더 나은 마케팅 성과를 추구하고 있습니다.\n\n
**추가 정보:**\n
1. 디지털 마케팅 관련 툴 사용 경험\n
2. 콘텐츠 전략 개발 능력\n
3. 소셜 미디어 광고 캠페인 경험',
STR_TO_DATE('2024-12-04', '%Y-%m-%d'), 'USER005'),
(6, '마케팅-홍보·조사', '마케팅 직무의 핵심, 고객 중심 전략과 데이터 분석',
'1. 마케터로서 저는 주로 마케팅 캠페인 기획과 브랜드 홍보 활동을 담당했습니다.\n\n
2. 프로젝트에서는 특정 제품의 소비자 인지도를 높이기 위한 캠페인을 기획하고 실행했습니다. 이를 통해 브랜드 인지도를 높이고, 소비자 참여율을 극대화했습니다.\n\n
3. 마케팅 전략을 수립하고 소비자에게 브랜드나 제품을 효과적으로 알렸으며, 다양한 미디어 채널을 활용하여 브랜드 이미지를 구축하고 유지했습니다.\n\n
4. 시장 조사와 소비자 분석을 통해 타겟 고객의 요구를 파악하고, 이를 바탕으로 마케팅 캠페인을 기획했습니다. 또한, 캠페인 결과를 분석하여 전략을 개선하는 역할도 합니다.\n\n
5. 이 경험은 마케팅 및 홍보 분야에 관심이 있는 사람들에게 많은 인사이트를 제공할 수 있습니다.\n\n
**추가 정보:**\n
1. 마케팅, 광고, 또는 관련 학위\n
2. 마케팅 도구와 데이터 분석에 대한 숙련된 지식 (예: Google Analytics, Excel 등)\n
3. 다양한 마케팅 채널에 대한 이해 (예: 디지털 마케팅, 소셜 미디어 등)',
STR_TO_DATE('2024-12-02', '%Y-%m-%d'), 'USER006'),
(7, '회계-세무·재무', '회계 직무의 핵심, 정확한 재무 데이터와 규정 준수',
'1. 회계 담당자로서 저는 주로 기업의 재무제표 작성과 세무 신고를 담당했습니다.\n\n
2. 회사의 연간 결산을 진행하고, 법인세 신고 절차를 수행했습니다. 이를 통해 회사의 재무 건전성을 높이고, 법적 규제에 준수하도록 도왔습니다.\n\n
3. 회계 담당자는 주로 기업의 재무 기록을 정확하게 관리하고, 세금 신고와 관련된 업무를 수행하는 역할을 합니다. 재무 담당자는 자금 흐름을 분석하고 예산을 수립하여 기업의 재정 상태를 최적화합니다.\n\n
4. 정확한 재무 데이터를 기반으로 기업의 재정 상태를 평가하고, 경영진이 전략적 결정을 내릴 수 있도록 지원합니다. 또한, 세무 계획을 수립하고 법규 준수를 보장하는 역할도 합니다.\n\n
5. 이 경험은 회계, 세무 및 재무 분야에 관심이 있는 사람들에게 많은 인사이트를 제공할 수 있습니다.\n\n
**추가 정보:**\n
1. 경영학, 경제학 또는 관련 학위\n
2. 회계 소프트웨어와 데이터 분석에 대한 숙련된 지식 (예: SAP, Excel, QuickBooks 등)\n
3. 회계 및 세무 법규에 대한 이해 (예: 법인세, 부가가치세 등)',
STR_TO_DATE('2024-12-01', '%Y-%m-%d'), 'USER007'),
(8, '디자인', '디자인의 핵심, 창의적 시각적 표현과 사용자 경험 개선',
'1. 디자이너로서 저는 주로 브랜드 아이덴티티와 사용자 경험(UX) 디자인을 담당했습니다.\n\n
2. 새로운 제품의 런칭을 위해 전체적인 비주얼 콘셉트를 설계하고, 이를 바탕으로 마케팅 자료와 웹 디자인을 개발했습니다. 이를 통해 브랜드 이미지가 소비자에게 효과적으로 전달되도록 했습니다.\n\n
3. 시각적 요소를 활용하여 브랜드의 메시지를 효과적으로 전달하는 역할을 합니다. UX 디자이너는 사용자의 편의성을 고려한 인터페이스를 설계하여 사용자 경험을 향상시키는 데 중점을 둡니다.\n\n
4. 디자이너는 클라이언트의 요구사항을 분석하고, 이를 시각적으로 표현하는 디자인을 개발합니다. 또한, 사용성 테스트를 통해 디자인의 효율성을 평가하고 개선하는 역할도 합니다.\n\n
5. 이 경험은 디자인 분야에 관심이 있는 사람들에게 많은 인사이트를 제공할 수 있습니다.\n\n
**추가 정보:**\n
1. 디자인, 시각 예술 전공 또는 관련 학위\n
2. 디자인 도구에 대한 숙련된 지식 (예: Adobe Creative Suite, Figma 등)\n
3. 사용자 경험 및 인터페이스 디자인에 대한 이해 (예: UX 리서치, 프로토타이핑 등)',
STR_TO_DATE('2024-12-01', '%Y-%m-%d'), 'USER008'),
(9, '영업-판매-무역', '영업판매의 핵심, 고객 관계 관리와 시장 확대',
'1. 영업 담당자로서 저는 주로 고객 관리와 신규 거래처 발굴을 담당했습니다.\n\n
2. 프로젝트에서는 특정 제품의 시장 점유율을 확대하기 위해 신규 고객을 발굴하고 기존 고객과의 관계를 강화하는 전략을 수립했습니다. 이를 통해 매출 증가와 고객 만족도를 높일 수 있었습니다.\n\n
3. 제품이나 서비스를 효과적으로 판매하는 역할을 합니다. 무역 담당자는 해외 고객과의 소통을 통해 수출입 절차를 관리하고 무역 거래를 원활하게 수행합니다.\n\n
4. 시장 조사와 고객의 요구를 분석하여 판매 전략을 수립하고, 이를 통해 회사의 매출을 증대시키는 역할을 합니다. 또한, 거래 후 고객 지원을 통해 지속적인 관계를 유지하는 것도 중요한 역할입니다.\n\n
5. 이 경험은 영업, 판매 및 무역 분야에 관심이 있는 사람들에게 많은 인사이트를 제공할 수 있습니다.\n\n
**추가 정보:**\n
1. 경영, 마케팅 전공 또는 관련 학위\n
2. 커뮤니케이션 및 협상 기술에 대한 숙련된 지식\n
3. 무역 절차와 관련된 이해 (예: 수출입 문서 작성, 관세 등)',
STR_TO_DATE('2024-12-01', '%Y-%m-%d'), 'USER009'),
(10, '건설-건축', '건축의 핵심, 프로젝트 관리와 품질 보증',
'1. 건설 프로젝트 관리자로서 저는 주로 건설 현장의 일정 관리와 품질 관리를 담당했습니다.\n\n
2. 대형 건축물의 공사 일정을 계획하고, 현장 작업이 원활하게 진행되도록 다양한 이해 관계자와 조율했습니다. 이를 통해 프로젝트가 예산과 일정 내에 완료될 수 있도록 기여했습니다.\n\n
3. 건설 현장 관리자는 주로 공사 현장의 작업을 감독하고, 품질과 안전 기준을 준수하는 역할을 합니다. 또한, 건축 담당자는 설계 도면을 바탕으로 건축물의 구조적 완성도를 관리하며, 프로젝트가 계획대로 진행되도록 지원합니다.\n\n
4. 프로젝트 초기 단계에서부터 완공 단계까지 모든 과정에 관여하며, 현장 인력과 자재 관리, 그리고 이해 관계자와의 커뮤니케이션을 통해 프로젝트의 성공적인 완료를 돕습니다. 또한, 안전 관리와 품질 보증을 통해 건설물의 안정성을 보장하는 역할도 수행합니다.\n\n
5. 이 경험은 건설 및 건축 분야에 관심이 있는 사람들에게 많은 인사이트를 제공할 수 있습니다.\n\n
**추가 정보:**\n
1. 건축학, 건축공학 또는 관련 학위\n
2. 건설 프로젝트 관리 도구에 대한 숙련된 지식 (예: AutoCAD, MS Project 등)\n
3. 건설 안전 기준 및 품질 관리에 대한 이해 (예: 안전 규정, 품질 보증 절차 등)',
STR_TO_DATE('2024-12-04', '%Y-%m-%d'), 'USER010'),
(11, '미디어-문화-스포츠', '미디어-문화-스포츠의 핵심, 창의적인 콘텐츠 기획과 커뮤니케이션',
'1. 미디어 콘텐츠 기획자로서 저는 주로 다양한 미디어 콘텐츠의 기획과 제작을 담당했습니다.\n\n
2. 프로젝트에서는 스포츠 이벤트의 라이브 스트리밍을 기획하고, 관련 마케팅 콘텐츠를 제작하여 시청자 참여를 극대화했습니다. 이를 통해 콘텐츠의 도달 범위를 넓히고, 브랜드의 가치를 효과적으로 전달했습니다.\n\n
3. 창의적인 아이디어를 바탕으로 콘텐츠를 제작하고, 다양한 플랫폼을 활용해 이를 배포하는 역할을 합니다. 스포츠 및 문화 관련 직무에서는 이벤트 기획과 참여자의 경험을 개선하는 데 중점을 둡니다.\n\n
4. 다양한 미디어 채널을 통해 콘텐츠를 배포하고, 시청자와의 소통을 통해 브랜드 이미지를 구축합니다. 또한, 문화적 요소를 반영하여 콘텐츠를 기획하고, 이벤트의 성과를 평가하여 전략을 개선하는 역할도 수행합니다.\n\n
5. 이 경험은 미디어, 문화 및 스포츠 분야에 관심이 있는 사람들에게 많은 인사이트를 제공할 수 있습니다. \n\n
**추가 정보:**\n
1. 건축학, 건축공학 또는 관련 학위\n
2. 건설 프로젝트 관리 도구에 대한 숙련된 지식 (예: AutoCAD, MS Project 등)\n
3. 건설 안전 기준 및 품질 관리에 대한 이해 (예: 안전 규정, 품질 보증 절차 등)',
STR_TO_DATE('2024-12-04', '%Y-%m-%d'), 'USER011'),
(12, '의료', '의료의 핵심, 환자 중심의 진료와 의료 서비스 개선',
'1. 의료 담당자로서 저는 주로 환자 진료 지원과 병원 운영 관리 업무를 담당했습니다. \n\n
2. 환자 관리 시스템을 개선하여 진료 대기 시간을 줄이고, 환자 만족도를 높이기 위한 프로세스를 개발했습니다. 이를 통해 환자들이 더 나은 의료 서비스를 받을 수 있도록 기여했습니다. \n\n
3. 주로 환자와 의료진 간의 원활한 소통을 돕고, 병원의 다양한 운영 절차를 지원하는 역할을 합니다. 또한, 환자 기록 관리와 같은 행정 업무를 수행하며 의료 서비스의 질을 유지합니다. \n\n
4. 환자의 요구사항을 파악하고 의료진과 협력하여 최적의 진료 환경을 조성합니다. 또한, 병원의 운영 효율성을 높이기 위해 내부 프로세스를 분석하고 개선하는 역할도 수행합니다. \n\n
5. 이 경험은 의료 및 병원 운영 분야에 관심이 있는 사람들에게 많은 인사이트를 제공할 수 있습니다. \n\n
**추가 정보:**\n
1. 의료 행정, 간호학 또는 관련 학위\n
2. 의료 정보 시스템과 데이터 관리에 대한 숙련된 지식 (예: EMR, Excel 등)\n
3. 의료 서비스 표준 및 환자 관리에 대한 이해 (예: 의료법, 환자 권리 등)',
STR_TO_DATE('2024-12-04', '%Y-%m-%d'), 'USER012'),
(13, '연구,R&D', '연구와 개발의 핵심, 혁신적인 솔루션과 기술 개발',
'1. 연구원으로서 저는 주로 신기술 개발과 제품 개선을 위한 연구 업무를 담당했습니다. \n\n
2. 새로운 소재를 활용한 제품 개선 연구를 진행하여 기존 제품의 성능을 크게 향상시켰습니다. 이를 통해 시장에서의 경쟁력을 높이는 데 기여했습니다. \n\n
3. 프로젝트의 목표를 설정하고, 연구 결과를 분석하여 최적의 솔루션을 도출합니다. 또한, 다른 팀과의 협업을 통해 연구 성과를 제품에 적용하고, 지속적인 개선을 위해 노력합니다. \n\n
4. 데이터 분석과 실험을 통해 새로운 아이디어를 검증하고, 기술적 문제를 해결하는 역할을 합니다. 또한, 연구 결과를 토대로 기술 개발 계획을 수립하여 제품화 과정에 기여합니다. \n\n
5. 이 경험은 연구 및 개발 분야에 관심이 있는 사람들에게 많은 인사이트를 제공할 수 있습니다. \n\n
**추가 정보:**\n
1. 공학, 과학 또는 관련 학위\n
2. 실험 설계와 데이터 분석에 대한 숙련된 지식 (예: MATLAB, R 등)\n
3. 기술 개발 및 연구 방법론에 대한 이해 (예: 프로토타이핑, 실험 분석 등)',
STR_TO_DATE('2024-12-04', '%Y-%m-%d'), 'USER013'),
(14, '서비스', '서비스의 핵심, 고객 만족과 품질 개선',
'1. 서비스 담당자로서 저는 주로 고객 만족을 높이기 위한 서비스 개선 업무를 담당했습니다. \n\n
2. 고객 피드백을 분석하여 서비스 절차를 개선하고, 이를 통해 고객 만족도를 크게 향상시켰습니다. 이를 통해 서비스 품질을 높이고 고객 충성도를 강화하는 데 기여했습니다. \n\n
3. 고객의 요구를 파악하고, 이를 기반으로 서비스 절차를 개선하며 문제를 해결하는 역할을 합니다. 또한, 고객 경험을 분석하여 개선 방안을 도출하고, 고객 만족을 극대화하기 위해 노력합니다. \n\n
4. 팀 내 다른 부서와 협력하여 고객의 요구에 신속히 대응하고, 지속적인 서비스 개선을 위해 노력합니다. 또한, 고객과의 소통을 통해 서비스의 질을 높이고, 긍정적인 고객 경험을 제공합니다. \n\n
5. 이 경험은 서비스 분야에 관심이 있는 사람들에게 많은 인사이트를 제공할 수 있습니다. \n\n
**추가 정보:**\n
1. 서비스 관리, 경영학 또는 관련 학위\n
2. 고객 관리 및 서비스 개선에 대한 숙련된 지식 (예: CRM, 고객 응대 기술 등)\n
3. 서비스 품질 관리와 고객 만족도 향상에 대한 이해 (예: 서비스 설계, 고객 피드백 분석 등)',
STR_TO_DATE('2024-12-04', '%Y-%m-%d'), 'USER014');



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

