-- This script updates the database to support Exam Scheduling instead of Exam Results.
-- Please run this on your `ims` database.

-- Drop the old 'exam' table if it exists
DROP TABLE IF EXISTS `exam`;

-- Create the new 'scheduled_exam' table
CREATE TABLE `scheduled_exam` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `course_id` int(11) NOT NULL,
  `exam_date` date NOT NULL,
  `exam_time` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_scheduled_exam_course_idx` (`course_id`),
  CONSTRAINT `fk_scheduled_exam_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
