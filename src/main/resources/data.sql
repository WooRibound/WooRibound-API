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
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, is_deleted)
VALUES ('ENT001', '김철수', '기획-전략', 'MEDIUM', '1234567890', '100000000', 'CJ ENM', 'password123', '서울시 강남구', 'IT 타워', NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, is_deleted)
VALUES ('ENT002', '이영희', '금융-보험', 'LARGE', '0987654321', '500000000', '삼성화재', 'securepwd', '부산시 해운대구', '블루 스퀘어', NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, is_deleted)
VALUES ('ENT003', '최민수', 'IT개발-데이터', 'MEDIUM', '5678901234', '150000000', '네이버', 'naverpwd', '경기도 성남시', '분당구', NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, is_deleted)
VALUES ('ENT004', '박지영', '디자인', 'SMALL', '3456789012', '70000000', '카카오', 'kakaopwd', '제주시', '제주동', NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, is_deleted)
VALUES ('ENT005', '이준호', '영업-판매-무역', 'LARGE', '4567890123', '300000000', '롯데', 'lottepwd', '인천시 남구', '롯데타워', NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, is_deleted)
VALUES ('ENT006', '김유진', '교육', 'MEDIUM', '9876543210', '90000000', '한솔교육', 'hansolpwd', '광주시 북구', '한솔빌딩', NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, is_deleted)
VALUES ('ENT007', '장희원', '연구-R&D', 'LARGE', '8765432109', '400000000', 'LG', 'lgpwd', '대전시 서구', 'LG타워', NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, is_deleted)
VALUES ('ENT008', '박은빈', '건설-건축', 'LARGE', '7654321098', '800000000', '현대건설', 'hyundaipwd', '울산시 남구', '현대타워', NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, is_deleted)
VALUES ('ENT009', '김하늘', '서비스', 'SMALL', '6543210987', '60000000', '에버랜드', 'everlandpwd', '경기도 용인시', '에버랜드', NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, is_deleted)
VALUES ('ENT010', '최영훈', '총무-법무·사무', 'MEDIUM', '5432109876', '110000000', '법무법인', 'lawfirmpwd', '서울시 서초구', '법조타운', NOW(), 'N');

-- Wb_User 데이터
INSERT INTO wb_user (
    user_id, gender, job_point, birth, created_at, data_sharing_consent,
    addr_city, addr_province, name, phone, email,
    exjob_chk, interest_chk, job_interest, is_deleted
) VALUES (
             'USER001', 'M', 10,
             STR_TO_DATE('1985-05-20 00:00:00', '%Y-%m-%d %H:%i:%s'),
             NOW(), 'Y',
             '서울', '서울시', '김철수', '010-1234-5678', 'kim@example.com',
             'Y', 'Y', 'Y', 'N'
         );
INSERT INTO wb_user (
    user_id, gender, job_point, birth, created_at, data_sharing_consent,
    addr_city, addr_province, name, phone, email,
    exjob_chk, interest_chk, job_interest, is_deleted
) VALUES (
             'USER002', 'F', 5,
             STR_TO_DATE('1990-03-15 00:00:00', '%Y-%m-%d %H:%i:%s'),
             NOW(), 'Y',
             '부산', '부산시', '이영희', '010-9876-5432', 'lee@example.com',
             'Y', 'Y', 'N', 'N'
         );
INSERT INTO wb_user (
    user_id, gender, job_point, birth, created_at, data_sharing_consent,
    addr_city, addr_province, name, phone, email,
    exjob_chk, interest_chk, job_interest, is_deleted
) VALUES (
             'USER003', 'M', 15,
             STR_TO_DATE('1988-08-05 00:00:00', '%Y-%m-%d %H:%i:%s'),
             NOW(), 'Y',
             '성남', '경기도', '최민수', '010-3456-7890', 'choi@example.com',
             'N', 'Y', 'Y', 'N'
         );
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted, data_sharing_consent)
VALUES ('USER004', 'F', 25, STR_TO_DATE('1992-11-10 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), '대전', '대전시', '박지영', '010-1234-5679', 'park@example.com', 'N', 'N', 'N', 'N', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted, data_sharing_consent)
VALUES ('USER005', 'M', 10, STR_TO_DATE('1983-09-12 00:00:00', '%Y-%m-%d %H:%i:%s'), NOW(), '대구', '대구시', '장희원', '010-1234-5680', 'jang@example.com', 'Y', 'Y', 'N', 'N', 'Y');

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

-- Job_Posting 데이터 (외래 키로 job과 enterprise 필요)
INSERT INTO job_posting (post_id, start_date, end_date, job_id, post_title, ent_id, post_img, posting_cnt, created_at)
VALUES
    (1, NOW() - INTERVAL '10' DAY, NOW() + INTERVAL '20' DAY, 1, '전략 기획 전문가 모집', 'ENT001', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 0, NOW() - INTERVAL '10' DAY),
    (2, NOW() - INTERVAL '30' DAY, NOW() + INTERVAL '60' DAY, 2, '마케팅·홍보 담당자 채용', 'ENT002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 5, NOW() - INTERVAL '30' DAY),
    (3, NOW() - INTERVAL '45' DAY, NOW() + INTERVAL '15' DAY, 3, '회계·세무 경력자 구인', 'ENT003', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 12, NOW() - INTERVAL '45' DAY),
    (4, NOW() - INTERVAL '60' DAY, NOW() + INTERVAL '90' DAY, 4, 'HRD 인사·노무 담당자 채용', 'ENT004', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 8, NOW() - INTERVAL '60' DAY),
    (5, NOW() - INTERVAL '5' DAY, NOW() + INTERVAL '10' DAY, 5, '총무·법무 사무관리자 모집', 'ENT005', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 23, NOW() - INTERVAL '5' DAY),
    (6, NOW() + INTERVAL '10' DAY, NOW() + INTERVAL '60' DAY, 6, '데이터 엔지니어 및 개발자 채용', 'ENT006', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 5, NOW() + INTERVAL '10' DAY),
    (7, NOW() + INTERVAL '30' DAY, NOW() + INTERVAL '120' DAY, 7, '그래픽 디자이너 모집', 'ENT007', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 10, NOW() + INTERVAL '30' DAY),
    (8, NOW() - INTERVAL '5' DAY, NOW() + INTERVAL '30' DAY, 8, '영업·판매 전문 인재 구인', 'ENT008', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 3, NOW() - INTERVAL '5' DAY),
    (9, NOW() - INTERVAL '20' DAY, NOW() + INTERVAL '60' DAY, 9, '고객 상담·TM 경력자 모집', 'ENT009', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 18, NOW() - INTERVAL '20' DAY),
    (10, NOW() - INTERVAL '10' DAY, NOW() + INTERVAL '45' DAY, 10, '구매·자재 물류 담당자 채용', 'ENT010', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 27, NOW() - INTERVAL '10' DAY),
    (11, NOW() + INTERVAL '15' DAY, NOW() + INTERVAL '60' DAY, 11, 'MD 상품기획 전문가 모집', 'ENT009', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 6, NOW() + INTERVAL '15' DAY),
    (12, NOW() + INTERVAL '30' DAY, NOW() + INTERVAL '90' DAY, 12, '운전·운송·배송 직원 채용', 'ENT008', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 20, NOW() + INTERVAL '30' DAY),
    (13, NOW() - INTERVAL '60' DAY, NOW() + INTERVAL '75' DAY, 13, '서비스 관리 담당자 모집', 'ENT007', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 15, NOW() - INTERVAL '60' DAY),
    (14, NOW() + INTERVAL '45' DAY, NOW() + INTERVAL '90' DAY, 14, '생산 현장 기술자 구인', 'ENT006', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 4, NOW() + INTERVAL '45' DAY),
    (15, NOW() - INTERVAL '5' DAY, NOW() + INTERVAL '60' DAY, 15, '건설·건축 전문 엔지니어 채용', 'ENT005', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 25, NOW() - INTERVAL '5' DAY),
    (16, NOW() + INTERVAL '20' DAY, NOW() + INTERVAL '30' DAY, 16, '의료 전문직 구인', 'ENT004', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 2, NOW() + INTERVAL '20' DAY),
    (17, NOW() + INTERVAL '5' DAY, NOW() + INTERVAL '120' DAY, 17, 'R&D 연구개발 전문가 모집', 'ENT003', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 9, NOW() + INTERVAL '5' DAY),
    (18, NOW() - INTERVAL '30' DAY, NOW() + INTERVAL '45' DAY, 18, '교육 컨설턴트 채용', 'ENT002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 30, NOW() - INTERVAL '30' DAY);


-- 지원현황
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date)
VALUES (1, '1', 'USER001', 'PENDING', STR_TO_DATE('2024-11-01', '%Y-%m-%d'));

INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date)
VALUES (2, '2', 'USER002', 'PENDING', STR_TO_DATE('2024-11-01', '%Y-%m-%d'));

-- 노하우
INSERT INTO knowhow (knowhow_id, knowhow_job, knowhow_title, knowhow_content, upload_date, user_id)
VALUES
    (1, 'IT개발-데이터', '효율적인 디버깅 기술', '시간을 절약하고 생산성을 높이는 디버깅 기술을 배워보세요.', STR_TO_DATE('2024-11-05', '%Y-%m-%d'), 'USER001'),
    (2, 'IT개발-데이터', '예측 모델 구축 가이드', '머신러닝을 활용한 예측 모델 구축의 단계별 가이드입니다.', STR_TO_DATE('2024-11-04', '%Y-%m-%d'), 'USER001'),
    (3, '기획-전략', '효율적인 이해관계자 커뮤니케이션', '프로젝트 이해관계자와 효과적으로 소통하는 전략을 소개합니다.', STR_TO_DATE('2024-11-03', '%Y-%m-%d'), 'USER001'),
    (4, '디자인', '사용자 중심 디자인 원칙', '더 나은 사용자 경험을 위한 사용자 중심 디자인 원칙에 대해 알아보세요.', STR_TO_DATE('2024-11-02', '%Y-%m-%d'), 'USER002'),
    (5, 'IT개발-데이터', '서버 성능 최적화', '서버 성능을 최적화하고 안정성을 보장하는 팁과 기술을 공유합니다.', STR_TO_DATE('2024-11-01', '%Y-%m-%d'), 'USER002');

--- 이력서
INSERT INTO resume (resume_id, user_id, user_img, resume_email, user_intro) VALUES
    (1, 'USER001', 'https://example.com/image1.jpg', 'kim@example.com', '전략 기획 경력이 풍부한 전문가로서 데이터 기반 분석에 강점을 가지고 있습니다.'),
    (2, 'USER002', 'https://example.com/image2.jpg', 'lee@example.com', '고객 중심 마케팅과 데이터 분석을 통해 성과를 낸 마케팅 전문가입니다.');

-- 알림
-- INSERT INTO notification (noti_id, user_id, apply_id, notice, is_confirmed, created_at)
-- VALUES (1, 'USER001', 1, '축하합니다. 지원하신 공고에 합격하셨습니다.', 'N', CURRENT_DATE);

-- INSERT INTO notification (noti_id, user_id, apply_id, notice, is_confirmed, created_at)
-- VALUES (2, 'USER002', 2, '지원하신 공고가 삭제되었습니다.', 'N', CURRENT_DATE);

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
INSERT INTO work_history (exjob_id, job_id, user_id)
VALUES (1, 1, 'USER001');
INSERT INTO work_history (exjob_id, job_id, user_id)
VALUES (2, 1, 'USER002');
INSERT INTO work_history (exjob_id, job_id, user_id)
VALUES (3, 3, 'USER003');
INSERT INTO work_history (exjob_id, job_id, user_id)
VALUES (4, 4, 'USER004');
INSERT INTO work_history (exjob_id, job_id, user_id)
VALUES (5, 5, 'USER005');