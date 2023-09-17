INSERT INTO public.grade_dict(grade_id, grade_text, min_value, max_value)
VALUES
(2, 'неуд', 0, 2.99),
(3, 'уд',   3, 3.99),
(4, 'хор',  4, 4.99),
(5, 'отл',  5, 5);

INSERT INTO public.students(student_id, full_name, date_birth, student_grade)
VALUES
(1, 'Сидоров Алексей Владимирович',     '2004-02-29', 3),
(2, 'Иванов Илья Петрович',             '2002-02-22', 2),
(3, 'Черепова Анастасия Александровна', '2008-08-08', 5),
(4, 'Прекрасная Жанна Николаевна',      null,         null);
