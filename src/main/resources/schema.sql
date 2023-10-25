CREATE TABLE IF NOT EXISTS course (
                      course_id integer auto_increment NOT NULL,
                      title varchar(80) NOT NULL,         -- Course Title
                      description varchar(500) NOT NULL,  -- Course Description
                      link varchar(255) NOT NULL,         -- Course landing page link
                      CONSTRAINT pk_course_course_id PRIMARY KEY (course_id)
);