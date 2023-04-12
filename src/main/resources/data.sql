INSERT INTO roles (id, `role`)
VALUES (1, 'CLIENT');

INSERT INTO users(id, username, email, password, role_id, attempts, right_answers)
values (1, 'Endeville', 'victor.popdonchev@gmail.com', '4f6f88770e803a755c6e6c89f1899efa62d24db9bf8a5e69b76fd7006020774c2975036a871380343ea0c7f8297cf43c', 1, 3, 2);

insert into question_types(id, question_type)
values (1, 'ONE_ANSWER'),
       (2, 'MULTIPLE_CHOICE');

insert into questions(id, description, question_type_id)
values (1, 'What is your favourite number? (there is only one correct answer)', 1),
       (2, 'Which of the numbers below are prime?', 2),
       (3, 'Which movie was given an Oscar this year(2023)?', 1);

insert into answers(id, answer, correct, question_id)
values (1, '42', 1, 1),
       (2, '0', 0, 2),
       (3, '19', 1, 2),
       (4, '1', 0, 2),
       (5, '2', 1, 2),
       (6, 'Titanic', 0, 3),
       (7, 'La la land', 0, 3),
       (8, 'CODA', 0, 3),
       (9, 'Everything Everywhere All at Once', 1, 3),
       (10, '56', 1, 1),
       (11, '73', 1, 1),
       (12, '9', 1, 1);