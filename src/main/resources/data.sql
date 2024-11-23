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
VALUES ('ENT001', 'CEO Kim', 'IT', 'MEDIUM', '1234567890', '100000000', 'Tech Corp', 'password123', 'Seoul, Korea', 'IT Tower', NOW(), 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr1, ent_addr2, created_at, is_deleted)
VALUES ('ENT002', 'CEO Lee', 'Finance', 'LARGE', '0987654321', '500000000', 'Finance Inc', 'securepwd', 'Busan, Korea', 'Blue Square',NOW(), 'N');

-- Wb_User 데이터
INSERT INTO wb_user (
    user_id, gender, job_point, birth, created_at,
    addr_city, addr_province, name, phone, email,
    exjob_chk, interest_chk, job_interest, is_deleted
) VALUES (
             'USER001', 'M', 10,
             STR_TO_DATE('1985-05-20 00:00:00', '%Y-%m-%d %H:%i:%s'),
             NOW(),
             'Seoul', 'Seoul', 'John Doe', '010-1234-5678', 'johndoe@example.com',
             'N', 'Y', 'N', 'N'
         );

-- 먼저 USER002 데이터 삽입
INSERT INTO wb_user (
    user_id, gender, job_point, birth, created_at,
    addr_city, addr_province, name, phone, email,
    exjob_chk, interest_chk, job_interest, is_deleted
) VALUES (
             'USER002', 'F', 5,
             STR_TO_DATE('1990-03-15 00:00:00', '%Y-%m-%d %H:%i:%s'),
             NOW(),
             'Busan', 'Busan', 'Jane Doe', '010-9876-5432', 'janedoe@example.com',
             'N', 'Y', 'N', 'N'
         );
-- Employment 데이터 (외래 키로 wb_user와 enterprise 필요)
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (1, NOW(), 'Y', 'Y', 'ENT001', 'USER001', 1);
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id, job_id)
VALUES (2, NOW(), 'N', 'N', 'ENT002', 'USER002', 2);

-- Job_Posting 데이터 (외래 키로 job과 enterprise 필요)
INSERT INTO job_posting (post_id, start_date, end_date, job_id, post_title, ent_id, post_img, posting_cnt)
VALUES
    (1, NOW() - INTERVAL '10' DAY, NOW() + INTERVAL '20' DAY, 1, '전략 기획 전문가 모집', 'ENT001', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 0),
    (2, NOW() - INTERVAL '30' DAY, NOW() + INTERVAL '60' DAY, 2, '마케팅·홍보 담당자 채용', 'ENT001', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 5),
    (3, NOW() - INTERVAL '45' DAY, NOW() + INTERVAL '15' DAY, 3, '회계·세무 경력자 구인', 'ENT001', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 12),
    (4, NOW() - INTERVAL '60' DAY, NOW() + INTERVAL '90' DAY, 4, 'HRD 인사·노무 담당자 채용', 'ENT001', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 8),
    (5, NOW() - INTERVAL '5' DAY, NOW() + INTERVAL '10' DAY, 5, '총무·법무 사무관리자 모집', 'ENT001', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 23),
    (6, NOW() + INTERVAL '10' DAY, NOW() + INTERVAL '60' DAY, 6, '데이터 엔지니어 및 개발자 채용', 'ENT001', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 5),
    (7, NOW() + INTERVAL '30' DAY, NOW() + INTERVAL '120' DAY, 7, '그래픽 디자이너 모집', 'ENT001', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 10),
    (8, NOW() - INTERVAL '5' DAY, NOW() + INTERVAL '30' DAY, 8, '영업·판매 전문 인재 구인', 'ENT001', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 3),
    (9, NOW() - INTERVAL '20' DAY, NOW() + INTERVAL '60' DAY, 9, '고객 상담·TM 경력자 모집', 'ENT001', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 18),
    (10, NOW() - INTERVAL '10' DAY, NOW() + INTERVAL '45' DAY, 10, '구매·자재 물류 담당자 채용', 'ENT002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 27),
    (11, NOW() + INTERVAL '15' DAY, NOW() + INTERVAL '60' DAY, 11, 'MD 상품기획 전문가 모집', 'ENT002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 6),
    (12, NOW() + INTERVAL '30' DAY, NOW() + INTERVAL '90' DAY, 12, '운전·운송·배송 직원 채용', 'ENT002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 20),
    (13, NOW() - INTERVAL '60' DAY, NOW() + INTERVAL '75' DAY, 13, '서비스 관리 담당자 모집', 'ENT002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 15),
    (14, NOW() + INTERVAL '45' DAY, NOW() + INTERVAL '90' DAY, 14, '생산 현장 기술자 구인', 'ENT002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 4),
    (15, NOW() - INTERVAL '5' DAY, NOW() + INTERVAL '60' DAY, 15, '건설·건축 전문 엔지니어 채용', 'ENT002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 25),
    (16, NOW() + INTERVAL '20' DAY, NOW() + INTERVAL '30' DAY, 16, '의료 전문직 구인', 'ENT002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 2),
    (17, NOW() + INTERVAL '5' DAY, NOW() + INTERVAL '120' DAY, 17, 'R&D 연구개발 전문가 모집', 'ENT002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/2b6a988f-ddb7-44e8-8146-3aca5e3091f4KakaoTalk_20241005_000811157_01.jpg', 9),
    (18, NOW() - INTERVAL '30' DAY, NOW() + INTERVAL '45' DAY, 18, '교육 컨설턴트 채용', 'ENT002', 'https://wb-bucket-01.s3.ap-northeast-2.amazonaws.com/jobPostingImage/148f67a6-da70-4145-8028-d629cf4b2575KakaoTalk_20241014_212417080.jpg', 30);

-- 지원현황
INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date)
VALUES (1, '1', 'USER001', 'PENDING', STR_TO_DATE('2024-11-01', '%Y-%m-%d'));

INSERT INTO user_apply (apply_id, post_id, user_id, result, apply_date)
VALUES (2, '2', 'USER002', 'PENDING', STR_TO_DATE('2024-11-01', '%Y-%m-%d'));

-- 노하우
INSERT INTO knowhow (knowhow_id, knowhow_job, knowhow_title, knowhow_content, upload_date, user_id)
VALUES (1, 'Software Developer', 'Effective Debugging Techniques', 'Learn how to debug effectively to save time and increase productivity.', STR_TO_DATE('2024-11-05', '%Y-%m-%d'), 'USER001');

INSERT INTO knowhow (knowhow_id, knowhow_job, knowhow_title, knowhow_content, upload_date, user_id)
VALUES (2, 'Data Scientist', 'Building a Predictive Model', 'Step-by-step guide to building a predictive model using machine learning.', STR_TO_DATE('2024-11-04', '%Y-%m-%d'), 'USER001');

INSERT INTO knowhow (knowhow_id, knowhow_job, knowhow_title, knowhow_content, upload_date, user_id)
VALUES (3, 'Product Manager', 'Effective Communication with Stakeholders', 'Strategies for effective communication with project stakeholders.', STR_TO_DATE('2024-11-03', '%Y-%m-%d'), 'USER001');

INSERT INTO knowhow (knowhow_id, knowhow_job, knowhow_title, knowhow_content, upload_date, user_id)
VALUES (4, 'UI/UX Designer', 'User-Centered Design Principles', 'Introduction to user-centered design principles for better user experiences.', STR_TO_DATE('2024-11-02', '%Y-%m-%d'), 'USER002');

INSERT INTO knowhow (knowhow_id, knowhow_job, knowhow_title, knowhow_content, upload_date, user_id)
VALUES (5, 'Software Developer', 'Optimizing Server Performance', 'Tips and techniques for optimizing server performance and ensuring stability.', STR_TO_DATE('2024-11-01', '%Y-%m-%d'), 'USER002');

INSERT INTO resume (resume_id, user_id, user_img, resume_email, user_intro) VALUES
    (1, 'USER001', 'https://example.com/image1.jpg', 'user1@example.com', 'Experienced software developer with a strong background in Java and Spring.');

-- 알림
INSERT INTO notification (noti_id, user_id, apply_id, notice, is_confirmed, created_at)
VALUES (1, 'USER001', 1, '축하합니다. 지원하신 공고에 합격하셨습니다.', 'N', CURRENT_DATE);

INSERT INTO notification (noti_id, user_id, apply_id, notice, is_confirmed, created_at)
VALUES (2, 'USER002', 2, '지원하신 공고가 삭제되었습니다.', 'N', CURRENT_DATE);

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