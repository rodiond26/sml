ALTER TABLE IF EXISTS public.students
  DROP CONSTRAINT IF EXISTS students_fkey;

DROP TABLE IF EXISTS public.students;
DROP TABLE IF EXISTS public.grade_dict;

CREATE TABLE IF NOT EXISTS public.grade_dict
(
    grade_id serial NOT NULL,
    grade_text character varying(255),
    min_value double precision,
    max_value double precision,
    CONSTRAINT grade_dict_pkey PRIMARY KEY (grade_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.grade_dict
    OWNER to postgres;

CREATE TABLE IF NOT EXISTS public.students
(
    student_id serial NOT NULL,
    full_name character varying(255),
    date_birth date,
    student_grade bigint,
    CONSTRAINT students_pkey PRIMARY KEY (student_id),
    CONSTRAINT students_fkey FOREIGN KEY (student_grade)
        REFERENCES public.grade_dict (grade_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE SET NULL
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.students
    OWNER to postgres;
