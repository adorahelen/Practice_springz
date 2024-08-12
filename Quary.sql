USE testdb;
CREATE TABLE training (
    id VARCHAR(20) PRIMARY KEY,
    title VARCHAR(50) DEFAULT NULL,
    start_date_time DATETIME DEFAULT NULL,
    end_date_time DATETIME DEFAULT NULL,
    reserved INT DEFAULT NULL,
    capacity INT DEFAULT NULL
);
INSERT INTO training (id, title, start_date_time, end_date_time, reserved, capacity) VALUES
('t01', '비즈니스 예절 교육', '2023-08-01 09:30:00', '2023-08-03 17:00:00', 1, 10),
('t02', '자바 교육', '2023-09-01 09:30:00', '2023-09-03 17:00:00', 1, 5),
('t03', '마케팅 교육', '2023-10-01 09:30:00', '2023-10-03 17:00:00', 5, 5);

select * from training

use testdb;

CREATE TABLE StudentType (
    id VARCHAR(255) PRIMARY KEY,
    code VARCHAR(50) NOT NULL,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Reservation (
    id VARCHAR(255) PRIMARY KEY,
    trainingId VARCHAR(255) NOT NULL,
    studentTypeId VARCHAR(255) NOT NULL,
    reservationDateTime DATETIME NOT NULL,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    emailAddress VARCHAR(255),
    FOREIGN KEY (trainingId) REFERENCES Training(id),
    FOREIGN KEY (studentTypeId) REFERENCES StudentType(id)
);
