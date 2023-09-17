-- Table: public.grade_dict

DROP TABLE IF EXISTS public.grade_dict;

CREATE TABLE IF NOT EXISTS public.grade_dict
(
    grade_id bigint NOT NULL,
    grade_text character varying(255),
    min_value double precision,
    max_value double precision,
    CONSTRAINT grade_dict_pkey PRIMARY KEY (grade_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.grade_dict
    OWNER to postgres;
