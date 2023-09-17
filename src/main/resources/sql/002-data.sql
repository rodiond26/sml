INSERT INTO public.grade_dict(grade_text, min_value, max_value)
VALUES
('кол', 0, 0.99),
('неуд', 1, 2.99),
('уд',   3, 3.99),
('хор',  4, 4.99),
('отл',  5, 5);

INSERT INTO public.students(full_name, date_birth, student_grade)
VALUES
('Сидоров Алексей Владимирович',     '2004-02-29', 3),
('Иванов Илья Петрович',             '2002-02-22', 2),
('Черепова Анастасия Александровна', '2008-08-08', 5),
('Прекрасная Жанна Николаевна',      null,         null);
