-- Job 데이터
INSERT INTO job (job_id, job_name) VALUES (1, 'Developer');
INSERT INTO job (job_id, job_name) VALUES (2, 'Designer');

-- Enterprise 데이터
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr, created_at, is_deleted)
VALUES ('ENT001', 'CEO Kim', 'IT', 'MEDIUM', '1234567890', '100000000', 'Tech Corp', 'password123', 'Seoul, Korea', SYSTIMESTAMP, 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr, created_at, is_deleted)
VALUES ('ENT002', 'CEO Lee', 'Finance', 'LARGE', '0987654321', '500000000', 'Finance Inc', 'securepwd', 'Busan, Korea', SYSTIMESTAMP, 'N');

-- Education 데이터
INSERT INTO education (edu_id, end_date, start_date, edu_city, edu_job, edu_host, edu_name, edu_img)
VALUES (1, TO_TIMESTAMP('2024-12-31 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Seoul', 'Programming', 'Tech Academy', 'Java Bootcamp', 'img/java.jpg');
INSERT INTO education (edu_id, end_date, start_date, edu_city, edu_job, edu_host, edu_name, edu_img)
VALUES (2, TO_TIMESTAMP('2025-12-31 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-01-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), 'Busan', 'Design', 'Creative Hub', 'UI/UX Design', 'img/design.jpg');

-- Wb_User 데이터
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, addr_city, addr_province, name, phone, provider_id, exjob_chk, interest_chk, job_interest, is_deleted)
VALUES ('USER001', 'M', 10, TO_TIMESTAMP('1985-05-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), SYSTIMESTAMP, 'Seoul', 'Seoul', 'John Doe', '010-1234-5678', 'provider01', 'N', 'Y', 'N', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, addr_city, addr_province, name, phone, provider_id, exjob_chk, interest_chk, job_interest, is_deleted)
VALUES ('USER002', 'F', 20, TO_TIMESTAMP('1990-08-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), SYSTIMESTAMP, 'Busan', 'Busan', 'Jane Doe', '010-8765-4321', 'provider02', 'Y', 'N', 'Y', 'N');

-- Employment 데이터 (외래 키로 wb_user와 enterprise 필요)
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id)
VALUES (1, SYSTIMESTAMP, 'Y', 'Y', 'ENT001', 'USER001');
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id)
VALUES (2, SYSTIMESTAMP, 'N', 'N', 'ENT002', 'USER002');

-- Job_Posting 데이터 (외래 키로 job과 enterprise 필요)
INSERT INTO job_posting (post_id, start_date, end_date, job_id, post_title, ent_id, post_img, post_state)
VALUES (1, SYSTIMESTAMP, SYSTIMESTAMP + INTERVAL '30' DAY, 1, 'Backend Developer', 'ENT001', 'img/backend.jpg', 'ACTIVE');
INSERT INTO job_posting (post_id, start_date, end_date, job_id, post_title, ent_id, post_img, post_state)
VALUES (2, SYSTIMESTAMP, SYSTIMESTAMP + INTERVAL '30' DAY, 2, 'UI/UX Designer', 'ENT002', 'img/designer.jpg', 'PENDING');

-- Resume 데이터 (외래 키로 wb_user 필요)
INSERT INTO resume (resume_id, user_email, user_img, user_intro, user_id)
VALUES (1, 'john.doe@example.com', 'img/john.jpg', 'Experienced Java Developer', 'USER001');
INSERT INTO resume (resume_id, user_email, user_img, user_intro, user_id)
VALUES (2, 'jane.doe@example.com', 'img/jane.jpg', 'Creative Designer with a flair for UI/UX', 'USER002');

-- Notification 데이터 (외래 키로 wb_user 필요)
INSERT INTO notification (noti_id, notice, user_id)
VALUES (1, 'Job application approved', 'USER001');
INSERT INTO notification (noti_id, notice, user_id)
VALUES (2, 'New job posting available', 'USER002');

-- User_Apply 데이터 (외래 키로 wb_user와 job_posting 필요)
INSERT INTO user_apply (apply_id, apply_date, post_id, result, user_id)
VALUES (1, SYSTIMESTAMP, 1, 'PENDING', 'USER001');
INSERT INTO user_apply (apply_id, apply_date, post_id, result, user_id)
VALUES (2, SYSTIMESTAMP, 2, 'PENDING', 'USER002');

-- User_Edu 데이터 (외래 키로 wb_user와 education 필요)
INSERT INTO user_edu (useredu_id, regist_date, edu_id, comp_state, user_id)
VALUES (1, SYSTIMESTAMP, 1, 'Y', 'USER001');
INSERT INTO user_edu (useredu_id, regist_date, edu_id, comp_state, user_id)
VALUES (2, SYSTIMESTAMP, 2, 'N', 'USER002');

-- Work_History 데이터 (외래 키로 wb_user와 job 필요)
INSERT INTO work_history (exjob_id, job_id, user_id)
VALUES (1, 1, 'USER001');
INSERT INTO work_history (exjob_id, job_id, user_id)
VALUES (2, 2, 'USER002');

-- Interest_Job 데이터 (외래 키로 wb_user와 job 필요)
INSERT INTO interest_job (interest_id, job_id, user_id)
VALUES (1, 1, 'USER001');
INSERT INTO interest_job (interest_id, job_id, user_id)
VALUES (2, 2, 'USER002');
