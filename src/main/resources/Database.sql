-- Tạo DB
CREATE DATABASE QLSV;
-- Sử dụng DB vừa tạo
USE QLSV;

-- Tạo bảng sinh viên
CREATE TABLE students (
    -- MSV là khóa chính
  student_id VARCHAR(10) PRIMARY KEY,
  student_name VARCHAR(100),
  birthdate DATE,
  course_year VARCHAR(3),
  hometown VARCHAR(100),
  address VARCHAR(255)
);

-- Tạo bảng accounts
CREATE TABLE accounts (
  account_id INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(50) UNIQUE,
  password VARCHAR(255),
  role ENUM('student', 'admin'),-- 2 vai trò: sinh viên và admin, foreign key is student id--
  student_id VARCHAR(10),
  FOREIGN KEY (student_id) REFERENCES students(student_id)-- foreign key reference to student id--
    -- admin ? == null ? --
);

-- Tạo bảng môn học
CREATE TABLE courses (
    course_id VARCHAR(10) PRIMARY KEY,
    course_name VARCHAR(50),
    credit INT,
    semester INT
);

-- Tạo bảng môn học tiên quyết
CREATE TABLE prerequisite_courses (
    id INT PRIMARY KEY AUTO_INCREMENT,
    course_id VARCHAR(10),
    prerequisite_course_id VARCHAR(10),
    FOREIGN KEY (course_id) REFERENCES courses(course_id),
    FOREIGN KEY (prerequisite_course_id) REFERENCES courses(course_id)

);

-- Tạo bảng lớp học
CREATE TABLE classes (
  class_id VARCHAR(20) PRIMARY KEY,
  course_id VARCHAR(20),
  class_name VARCHAR(100),
  max_student INT,
  room VARCHAR(50),
  day_of_week VARCHAR(20),
  time_range VARCHAR(20),
  FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

-- Tạo bảng đăng ký
CREATE TABLE registrations (
  student_id VARCHAR(10),
  class_id VARCHAR(20),
  grade1 DECIMAL(5,2),
  grade1_weight DECIMAL(5,2),
  grade2 DECIMAL(5,2),
  grade2_weight DECIMAL(5,2),
  grade3 DECIMAL(5,2),
  grade3_weight DECIMAL(5,2),
  final_exam DECIMAL(5,2),
  final_exam_weight DECIMAL(5,2),
  final_grade DECIMAL(5,2),
  PRIMARY KEY (student_id, class_id),
  FOREIGN KEY (student_id) REFERENCES students(student_id),
  FOREIGN KEY (class_id) REFERENCES classes(class_id)
);

-- Nhập Data cho bảng students
INSERT INTO students(student_id, student_name, birthdate, course_year, hometown, address)
VALUES
    ('D22VT01','Nguyễn Văn An','2003-01-01','D22','Hà Nội', 'Đường Láng'),
    ('D22VT02','Nguyễn Vân Anh','2003-02-15','D22','Bắc Ninh','Ao Sen'),
    ('D22VT03','Trần Văn Bình','2003-02-14','D22','Hà Nam','Vạn Phúc'),
    ('D22VT04','Vũ Thị Hải Yến','2003-09-19','D22','Ninh Bình','Yên Xá'),
    ('D22VT05','Đỗ Mạnh Tùng','2003-04-14','D22','Thái Bình','Mậu Lương');

-- Nhập Data cho bảng accounts
INSERT INTO accounts
VALUES
    ('1','admin','admin','admin',NULL),
    ('2','D22VT01','D22VT01','student','D22VT01'),
    ('3','D22VT02','D22VT02','student','D22VT02'),
    ('4','D22VT03','D22VT03','student','D22VT03'),
    ('5','D22VT04','D22VT04','student','D22VT04'),
    ('6','D22VT05','D22VT05','student','D22VT05');

-- Nhập Data cho bảng courses
INSERT INTO courses (course_id, course_name, credit, semester)
VALUES
    ('BAS1150', 'Triết học Mác Lênin', 3, 1),
    ('BAS1201', 'Đại số', 3, 1),
    ('BAS1203', 'Giải tích 1', 3, 1),
    ('INT1154', 'Tin học cơ sở 1', 2, 1),
    ('BAS1151', 'Kinh tế chính trị Mác Lênin', 2, 2),
    ('BAS1204', 'Giải tích 2', 4, 2),
    ('BAS1157', 'Tiếng Anh (Course 1)', 4, 2),
    ('BAS1224', 'Vật lý 1 và thí nghiệm', 4, 2),
    ('BAS1226', 'Xác suất thống kê', 2, 2),
    ('INT1155', 'Tin học cơ sở 2', 2, 2),
    ('BAS1152', 'Chủ nghĩa xã hội khoa học', 2, 3),
    ('BAS1158', 'Tiếng Anh (Course 2)', 4, 3),
    ('BAS1225', 'Vật lý 2 và thí nghiệm', 4, 3),
    ('TEL1368', 'Tín hiệu và Hệ thống', 3, 3),
    ('ELE1318', 'Lý thuyết mạch', 3, 3),
    ('ELE13105', 'Linh kiện và mạch điện tử', 3, 3),
    ('BAS1122', 'Tư tưởng Hồ Chí Minh', 2, 4),
    ('BAS1159', 'Tiếng Anh (Course 3)', 4, 4),
    ('ELE1309', 'Điện tử số', 3, 4),
    ('TEL1344', 'Lý thuyết truyền tin', 3, 4),
    ('ELE13101', ' Xử lý tín hiệu số', 3, 4),
    ('TEL1345', 'Kỹ thuật Siêu cao tần', 3, 4),
    ('BAS1153', 'Lịch sử Đảng cộng sản Việt Nam', 2, 5),
    ('BAS1160', 'Tiếng Anh (Course 3 Plus)', 2, 5),
    ('TEL1421', 'Truyền sóng và Anten', 3, 5),
    ('ELE1317', 'Kỹ thuật Vi xử lý', 3, 5),
    ('TEL1338', 'Kiến trúc máy tính', 2, 5),
    ('TEL1337', 'Toán rời rạc', 3, 5),
    ('TEL1340', 'Kỹ thuật lập trình', 3, 5),
    ('TEL1405', 'Kỹ thuật mạng truyền thông', 3, 6),
    ('TEL1406', 'Kỹ thuật thông tin quang', 3, 6),
    ('TEL1407', 'Kỹ thuật thông tin vô tuyến', 3, 6),
    ('TEL1339', 'Hệ điều hành', 2, 6),
    ('TEL1342', 'Cấu trúc dữ liệu và giải thuật', 3, 6),
    ('TEL1341', 'Công nghệ phần mềm', 3, 6),
    ('TEL1412', 'Mô phỏng hệ thống truyền thông', 2, 6),
    ('TEL1346', 'Mạng truyền thông quang', 3, 7),
    ('TEL1415', 'Thông tin di động', 3, 7),
    ('TEL1469', 'Internet và các giao thức', 3, 7),
    ('TEL1401', 'An toàn mạng thông tin', 3, 7),
    ('TEL1343', 'Cơ sở dữ liệu', 3, 7),
    ('TEL1447', 'Điện toán đám mây', 3, 8),


-- Nhập Data cho bảng môn học tiên quyết
INSERT INTO prerequisite_courses (course_id, prerequisite_course_id)
VALUES 
    ('INT1155', 'INT1154'),
    ('TEL1344', 'BAS1226'),
    ('TEL1344', 'BAS1201'),
    ('TEL1345', 'BAS1224'),
    ('TEL1345', 'BAS1225'),
    ('TEL1421', 'TEL1345'),
    ('TEL1338', 'INT1155'),
    ('TEL1337', 'INT1155'),
    ('TEL1340', 'INT1155'),
    ('TEL1405', 'TEL1344'),
    ('TEL1406', 'BAS1225'),
    ('TEL1406', 'TEL1344'),
    ('TEL1407', 'TEL1344'),
    ('TEL1339', 'INT1155'),
    ('TEL1342', 'TEL1340'),
    ('TEL1341', 'TEL1340'),
    ('TEL1412', 'TEL1368'),
    ('TEL1346', 'TEL1406'),
    ('TEL1415', 'TEL1407'),
    ('TEL1469', 'TEL1405'),
    ('TEL1401', 'TEL1405'),
    ('TEL1343', 'TEL1337'),
    ('TEL1343', 'TEL1342'),
    ('TEL1447', 'TEL1405');


-- Nhập Data cho bảng classes
INSERT INTO classes
VALUES
    ('BAS1153_1','BAS1153','Nhóm 1',3,'202-A2','Thứ 2','7-9h'),
    ('BAS1153_2','BAS1153','Nhóm 2',3,'202-A2','Thứ 2','9-11h'),
    ('BAS1153_3','BAS1153','Nhóm 3',3,'202-A2','Thứ 3','7-9h'),
    ('BAS1153_4','BAS1153','Nhóm 4',3,'202-A2','Thứ 3','9-11h'),
    ('BAS1421_1','BAS1160','Nhóm 1',3,'201-A2','Thứ 2','7-9h'),
    ('BAS1421_2','BAS1160','Nhóm 2',3,'201-A2','Thứ 2','9-11h'),
    ('BAS1421_3','BAS1160','Nhóm 3',3,'201-A2','Thứ 3','7-9h'),
    ('BAS1421_4','BAS1160','Nhóm 4',3,'201-A2','Thứ 3','9-11h'),
    ('TEL1421_1','TEL1421','Nhóm 1',3,'301-A2','Thứ 3','7-9h'),
    ('TEL1421_2','TEL1421','Nhóm 2',3,'301-A2','Thứ 3','9-11h'),
    ('TEL1421_3','TEL1421','Nhóm 3',3,'301-A2','Thứ 4','7-9h'),
    ('TEL1421_4','TEL1421','Nhóm 4',3,'301-A2','Thứ 4','9-11h'),
    ('ELE1317_1','ELE1317','Nhóm 1',3,'303-A2','Thứ 3','7-9h'),
    ('ELE1317_2','ELE1317','Nhóm 2',3,'303-A2','Thứ 3','9-11h'),
    ('ELE1317_3','ELE1317','Nhóm 3',3,'303-A2','Thứ 4','7-9h'),
    ('ELE1317_4','ELE1317','Nhóm 4',3,'303-A2','Thứ 4','9-11h'),
    ('TEL1338_1','TEL1338','Nhóm 1',3,'502-A2','Thứ 4','7-9h'),
    ('TEL1338_2','TEL1338','Nhóm 2',3,'502-A2','Thứ 4','9-11h'),
    ('TEL1338_3','TEL1338','Nhóm 3',3,'502-A2','Thứ 5','7-9h'),
    ('TEL1338_4','TEL1338','Nhóm 4',3,'502-A2','Thứ 5','9-11h'),
    ('TEL1337_1','TEL1337','Nhóm 1',3,'703-A2','Thứ 4','7-9h'),
    ('TEL1337_2','TEL1337','Nhóm 2',3,'703-A2','Thứ 4','9-11h'),
    ('TEL1337_3','TEL1337','Nhóm 3',3,'703-A2','Thứ 5','7-9h'),
    ('TEL1337_4','TEL1337','Nhóm 4',3,'703-A2','Thứ 5','9-11h'),
    ('TEL1340_1','TEL1340','Nhóm 1',3,'503-A2','Thứ 5','7-9h'),
    ('TEL1340_2','TEL1340','Nhóm 2',3,'503-A2','Thứ 5','9-11h'),
    ('TEL1340_3','TEL1340','Nhóm 3',3,'503-A2','Thứ 6','7-9h'),
    ('TEL1340_4','TEL1340','Nhóm 4',3,'503-A2','Thứ 6','9-11h');
  -- Nhập Data cho bảng classes

  --UPDATE TABBLE classes neu gv dki mo lop
  INSERT INTO classes(class_id,course_id)
  VALUES
    ('BAS1150_1','BAS1150'),
    ('BAS1201_1','BAS1201'),
    ('BAS1203_1','BAS1203'),
    ('INT1154_1','INT1154'),
    ('BAS1151_1','BAS1151'),
    ('BAS1157_1','BAS1157'),
    ('BAS1204_1','BAS1204'),
    ('BAS1224_1','BAS1224'),
    ('BAS1226_1','BAS1226'),
    ('INT1155_1','INT1155'),
    ('BAS1152_1','BAS1152'),
    ('BAS1158_1','BAS1158'),
    ('BAS1225_1','BAS1225'),
    ('TEL1368_1','TEL1368'),
    ('ELE1318_1','ELE1318'),
    ('ELE13105_1','ELE13105'),
    ('BAS1122_1','BAS1122'),
    ('BAS1159_1','BAS1159'),
    ('ELE1309_1','ELE1309'),
    ('TEL1344_1','TEL1344'),
    ('ELE13101_1','ELE13101'),
    ('TEL1345_1','TEL1345');
        
-- Nhập Data cho bảng registrations, include final_grade
INSERT INTO registrations(student_id,class_id,grade1,grade1_weight,grade2,grade2_weight,grade3,grade3_weight,final_exam,final_exam_weight)
VALUES
    -- 1 cot ve final
    ('D22VT01','BAS1150_1', 6.5, 10, 7.5, 10, 7, 20, 6.5, 60),
    ('D22VT01','BAS1201_1', 7, 10, 8, 10, 6, 20, 6, 60),
    ('D22VT01','BAS1203_1', 9, 10, 9, 10, 8, 20, 8, 60),
    ('D22VT01','INT1154_1', 6, 10, 4, 10, 5, 20, 9, 60),
    ('D22VT01','BAS1151_1', 9.5, 10, 8, 10, 7, 20, 9.0, 60),
    ('D22VT01','BAS1157_1', 7, 10, 7, 10, 8, 20, 7.5, 60),
    ('D22VT01','BAS1224_1', 8, 10, 7.5, 20, 6, 10, 5.5, 50),
    ('D22VT01','BAS1226_1', 9, 10, 7, 20, 7, 10, 6, 60),
    ('D22VT01','INT1155_1', 7, 10, 7, 20, 8, 20, 7.5, 50),
    ('D22VT01','BAS1152_1', 7, 10, 8, 20, 7.5, 10, 6.8, 60),
    ('D22VT01','BAS1158_1', 7, 10, 7.5, 10, 8.0, 20, 7.5, 50),
    ('D22VT01','BAS1225_1', 9, 10, 7.0, 20, 7, 10, 6.2, 50),
    ('D22VT01','TEL1368_1', 7.5, 10, 8, 20, 6.5, 10, 7.0, 60),
    ('D22VT01','ELE1318_1', 6.5, 10, 8, 20, 8, 10, 7.0, 50),
    ('D22VT01','ELE13105_1', 8, 10, 8.0, 10, 7, 20, 7, 60),
    ('D22VT01','BAS1122_1', 7, 10, 8, 20, 7, 10, 6.4, 50),
    ('D22VT01','BAS1159_1', 8, 10, 7.0, 20, 7, 10, 6, 50),
    ('D22VT01','ELE1309_1', 7.5, 10, 8.0, 20, 6.5, 10, 6.5, 50),
    ('D22VT01','TEL1344_1', 7, 20, 7.5, 10, 7, 10, 7.0, 60),
    ('D22VT01','ELE13101_1', 8, 10, 7.5, 20, 6, 10, 5.5, 50),
    ('D22VT01','TEL1345_1', 7.5, 20, 8.0, 10, 7, 10, 5.8, 50),
    ('D22VT02', 'BAS1150_1', 6.5, 10, 7.0, 10, 7.0, 20, 6.5, 60),
    ('D22VT02', 'BAS1201_1', 7, 10, 8, 10, 6, 20, 6.0, 60),
    ('D22VT02', 'BAS1203_1', 9, 10, 9, 10, 8, 20, 8.0, 60),
    ('D22VT02', 'INT1154_1', 6, 10, 4, 10, 5, 20, 9.0, 60),
    ('D22VT02', 'BAS1151_1', 9, 10, 8, 10, 7, 20, 8.0, 60),
    ('D22VT02', 'BAS1157_1', 7, 10, 7, 10, 8, 20, 7.5, 60),
    ('D22VT02', 'BAS1224_1', 8, 10, 7.0, 20, 6, 10, 5.5, 50),
    ('D22VT02', 'BAS1226_1', 9, 10, 7, 20, 7, 10, 6.0, 60),
    ('D22VT02', 'INT1155_1', 7, 10, 7, 20, 8, 20, 7.5, 50),
    ('D22VT02', 'BAS1152_1', 7, 10, 8, 20, 7, 10, 7.0, 60),
    ('D22VT02', 'BAS1158_1', 7, 10, 7.5, 10, 8, 20, 7.0, 50),
    ('D22VT02', 'BAS1225_1', 9, 10, 7.0, 20, 7, 10, 6.0, 50),
    ('D22VT02', 'TEL1368_1', 7.5, 10, 8, 20, 6.5, 10, 7.0, 60),
    ('D22VT02', 'ELE1318_1', 6.5, 10, 8, 20, 8, 10, 6.5, 50),
    ('D22VT02', 'ELE13105_1', 8, 10, 8.0, 10, 7, 20, 7.0, 60),
    ('D22VT02', 'BAS1122_1', 7, 10, 8, 20, 7, 10, 6.4, 50),
    ('D22VT02', 'BAS1159_1', 8, 10, 7.0, 20, 7, 10, 6.0, 50),
    ('D22VT02', 'ELE1309_1', 7.5, 10, 8.0, 20, 6.5, 10, 6.5, 50),
    ('D22VT02', 'TEL1344_1', 7, 20, 7.5, 10, 7, 10, 7.0, 60),
    ('D22VT02', 'ELE13101_1', 8, 10, 7.5, 20, 6, 10, 5.5, 50),
    ('D22VT02', 'TEL1345_1', 7.5, 20, 8.0, 10, 7, 10, 6.0, 50),
    ('D22VT03', 'BAS1150_1', 6.0, 10, 7.5, 10, 7.5, 20, 6.0, 60),
    ('D22VT03', 'BAS1201_1', 7, 10, 8, 10, 6.5, 20, 6.0, 60),
    ('D22VT03', 'BAS1203_1', 8, 10, 9, 10, 8, 20, 8.0, 60),
    ('D22VT03', 'INT1154_1', 6, 10, 4, 10, 5, 20, 8.0, 60),
    ('D22VT03', 'BAS1151_1', 9, 10, 8, 10, 7, 20, 8.0, 60),
    ('D22VT03', 'BAS1157_1', 7, 10, 7, 10, 8, 20, 7.5, 60),
    ('D22VT03', 'BAS1224_1', 8, 10, 7.5, 20, 6, 10, 5.5, 50),
    ('D22VT03', 'BAS1226_1', 9, 10, 7, 20, 7, 10, 6.0, 60),
    ('D22VT03', 'INT1155_1', 7, 10, 7, 20, 8, 20, 7.5, 50),
    ('D22VT03', 'BAS1152_1', 7, 10, 8, 20, 7, 10, 6.5, 60),
    ('D22VT03', 'BAS1158_1', 7, 10, 7.5, 10, 8.0, 20, 6.5, 50),
    ('D22VT03', 'BAS1225_1', 9, 10, 7.0, 20, 7, 10, 6.5, 50),
    ('D22VT03', 'TEL1368_1', 7.5, 10, 8, 20, 6.5, 10, 7.0, 60),
    ('D22VT03', 'ELE1318_1', 6.5, 10, 8, 20, 8, 10, 7.0, 50),
    ('D22VT03', 'ELE13105_1', 8, 10, 8.0, 10, 7, 20, 7.0, 60),
    ('D22VT03', 'BAS1122_1', 7, 10, 8, 20, 7, 10, 6.5, 50),
    ('D22VT03', 'BAS1159_1', 8, 10, 7.0, 20, 7, 10, 6.5, 50),
    ('D22VT03', 'ELE1309_1', 7.5, 10, 8.0, 20, 6.5, 10, 6.5, 50),
    ('D22VT03', 'TEL1344_1', 7, 20, 7.5, 10, 7, 10, 7.0, 60),
    ('D22VT03', 'ELE13101_1', 8, 10, 7.5, 20, 6, 10, 5.5, 50),
    ('D22VT03', 'TEL1345_1', 7.5, 20, 8.0, 10, 7, 10, 6.5, 50),
    ('D22VT04', 'BAS1150_1', 6.0, 10, 7.5, 10, 7.5, 20, 6.0, 60),
    ('D22VT04', 'BAS1201_1', 7, 10, 8, 10, 6.5, 20, 6.5, 60),
    ('D22VT04', 'BAS1203_1', 9, 10, 9, 10, 8, 20, 8.0, 60),
    ('D22VT04', 'INT1154_1', 6, 10, 4, 10, 5, 20, 8.0, 60),
    ('D22VT04', 'BAS1151_1', 9, 10, 8, 10, 7, 20, 8.0, 60),
    ('D22VT04', 'BAS1157_1', 7, 10, 7, 10, 8, 20, 7.0, 60),
    ('D22VT04', 'BAS1224_1', 8, 10, 7.5, 20, 6, 10, 5.5, 50),
    ('D22VT04', 'BAS1226_1', 9, 10, 7, 20, 7, 10, 6.0, 60),
    ('D22VT04', 'INT1155_1', 7, 10, 7, 20, 8, 20, 7.5, 50),
    ('D22VT04', 'BAS1152_1', 7, 10, 8, 20, 7, 10, 6.5, 60),
    ('D22VT04', 'BAS1158_1', 7, 10, 7.5, 10, 8, 20, 6.5, 50),
    ('D22VT04', 'BAS1225_1', 9, 10, 7.0, 20, 7, 10, 6.0, 50),
    ('D22VT04', 'TEL1368_1', 7.5, 10, 8, 20, 6.5, 10, 7.0, 60),
    ('D22VT04', 'ELE1318_1', 6.5, 10, 8, 20, 8, 10, 7.0, 50),
    ('D22VT04', 'ELE13105_1', 8, 10, 8.0, 10, 7, 20, 7.0, 60),
    ('D22VT04', 'BAS1122_1', 7, 10, 8, 20, 7, 10, 6.5, 50),
    ('D22VT04', 'BAS1159_1', 8, 10, 7.0, 20, 7, 10, 6.5, 50),
    ('D22VT04', 'ELE1309_1', 7.5, 10, 8.0, 20, 6.5, 10, 6.0, 50),
    ('D22VT04', 'TEL1344_1', 7, 20, 7.5, 10, 7, 10, 7.0, 60),
    ('D22VT04', 'ELE13101_1', 8, 10, 7.5, 20, 6, 10, 5.5, 50),
    ('D22VT04', 'TEL1345_1', 7.5, 20, 8.0, 10, 7, 10, 6.5, 50),
    ('D22VT05', 'BAS1150_1', 6.0, 10, 7.0, 10, 7.5, 20, 6.5, 60),
    ('D22VT05', 'BAS1201_1', 7, 10, 8, 10, 6.0, 20, 6.0, 60),
    ('D22VT05', 'BAS1203_1', 8, 10, 9, 10, 8, 20, 8.0, 60),
    ('D22VT05', 'INT1154_1', 6, 10, 4, 10, 5, 20, 8.0, 60),
    ('D22VT05', 'BAS1151_1', 9, 10, 8, 10, 7, 20, 8.0, 60),
    ('D22VT05', 'BAS1157_1', 7, 10, 7, 10, 8, 20, 7.5, 60),
    ('D22VT05', 'BAS1224_1', 8, 10, 7.5, 20, 6, 10, 5.5, 50),
    ('D22VT05', 'BAS1226_1', 9, 10, 7, 20, 7, 10, 6.0, 60),
    ('D22VT05', 'INT1155_1', 7, 10, 7, 20, 8, 20, 7.5, 50),
    ('D22VT05', 'BAS1152_1', 7, 10, 8, 20, 7, 10, 6.5, 60),
    ('D22VT05', 'BAS1158_1', 7, 10, 7.5, 10, 8, 20, 6.5, 50),
    ('D22VT05', 'BAS1225_1', 9, 10, 7.0, 20, 7, 10, 6.0, 50),
    ('D22VT05', 'TEL1368_1', 7.5, 10, 8, 20, 6.5, 10, 7.0, 60),
    ('D22VT05', 'ELE1318_1', 6.5, 10, 8, 20, 8, 10, 7.0, 50),
    ('D22VT05', 'ELE13105_1', 8, 10, 8.0, 10, 7, 20, 7.0, 60),
    ('D22VT05', 'BAS1122_1', 7, 10, 8, 20, 7, 10, 6.5, 50),
    ('D22VT05', 'BAS1159_1', 8, 10, 7.0, 20, 7, 10, 6.5, 50),
    ('D22VT05', 'ELE1309_1', 7.5, 10, 8.0, 20, 6.5, 10, 6.5, 50),
    ('D22VT05', 'TEL1344_1', 7, 20, 7.5, 10, 7, 10, 7.0, 60),
    ('D22VT05', 'ELE13101_1', 8, 10, 7.5, 20, 6, 10, 5.5, 50),
    ('D22VT05', 'TEL1345_1', 7.5, 20, 8.0, 10, 7, 10, 6.0, 50);

UPDATE registrations
SET final_grade= (grade1*grade1_weight+grade2*grade2_weight+grade3*grade3_weight+final_exam*final_exam_weight)/100;

--Thêm cột checkpass
ALTER TABLE registrations
    -- checking result, table name is registrations--
    ADD checkpass BOOLEAN;

--Cập nhật dữ liệu cho checkpass
UPDATE registrations
SET checkpass = CASE WHEN final_grade >= 4.0 THEN TRUE ELSE FALSE END;
-- cout check pass hay fail,
-- if(grade1*grade1_weight + grade2*grade2_weight + grade3*grade3_weight + final_exam*final_exam_weight >= 40) then 'Pass' else 'Fail' end as result
-- checkbool P hoac F
-- neu P thi sv pass, neu F thi hoc lai
