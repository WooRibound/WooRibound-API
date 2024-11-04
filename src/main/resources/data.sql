-- Job 데이터
INSERT INTO job (job_id, job_name) VALUES (1, 'Developer');
INSERT INTO job (job_id, job_name) VALUES (2, 'Designer');

-- Enterprise 데이터
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr, created_at, is_deleted)
VALUES ('ENT001', 'CEO Kim', 'IT', 'MEDIUM', '1234567890', '100000000', 'Tech Corp', 'password123', 'Seoul, Korea', SYSTIMESTAMP, 'N');
INSERT INTO enterprise (ent_id, ceo_name, ent_field, ent_size, reg_num, revenue, ent_name, ent_pwd, ent_addr, created_at, is_deleted)
VALUES ('ENT002', 'CEO Lee', 'Finance', 'LARGE', '0987654321', '500000000', 'Finance Inc', 'securepwd', 'Busan, Korea', SYSTIMESTAMP, 'N');

-- Wb_User 데이터
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted)
VALUES ('USER001', 'M', 10, TO_TIMESTAMP('1985-05-20 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), SYSTIMESTAMP, 'Seoul', 'Seoul', 'John Doe', '010-1234-5678', 'johndoe@example.com', 'N', 'Y', 'N', 'N');
INSERT INTO wb_user (user_id, gender, job_point, birth, created_at, addr_city, addr_province, name, phone, email, exjob_chk, interest_chk, job_interest, is_deleted)
VALUES ('USER002', 'F', 20, TO_TIMESTAMP('1990-08-15 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), SYSTIMESTAMP, 'Busan', 'Busan', 'Jane Doe', '010-8765-4321', 'janedoe@example.com', 'Y', 'N', 'Y', 'N');

-- Employment 데이터 (외래 키로 wb_user와 enterprise 필요)
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id)
VALUES (1, SYSTIMESTAMP, 'Y', 'Y', 'ENT001', 'USER001');
INSERT INTO employment (emp_id, hire_date, emp_recomm, emp_state, ent_id, user_id)
VALUES (2, SYSTIMESTAMP, 'N', 'N', 'ENT002', 'USER002');

-- Job_Posting 데이터 (외래 키로 job과 enterprise 필요)
INSERT INTO job_posting (post_id, start_date, end_date, job_id, post_title, ent_id, post_img, post_state)
VALUES (1, SYSTIMESTAMP, SYSTIMESTAMP + INTERVAL '30' DAY, 1, 'Backend Developer', 'ENT001', 'img/backend.jpg', 'ACTIVE');
INSERT INTO job_posting (post_id, start_date, end_date, job_id, post_title, ent_id, post_img, post_state)
VALUES (2, SYSTIMESTAMP, SYSTIMESTAMP + INTERVAL '60' DAY, 2, 'UI/UX Designer', 'ENT002', 'img/designer.jpg', 'PENDING');
