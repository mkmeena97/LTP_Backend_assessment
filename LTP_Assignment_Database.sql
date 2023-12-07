-- -----------------------------------------------------
-- Schema ltp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ltp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ltp` ;

-- -----------------------------------------------------
-- Table `ltp`.`consultant`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ltp`.`consultant` (
  `consultant_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `consultant_name` VARCHAR(255) NOT NULL,
  `consultant_email` VARCHAR(255) NOT NULL,
  `consultant_phone` VARCHAR(20) NULL DEFAULT NULL
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `ltp`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ltp`.`client` (
  `client_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `client_name` VARCHAR(255) NOT NULL,
  `client_email` VARCHAR(255) NOT NULL,
  `client_phone` VARCHAR(20) NULL DEFAULT NULL
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `ltp`.`slot`
-- -----------------------------------------------------
CREATE TABLE `ltp`.`slot` (
  `slot_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `consultant_id` INT,
  `client_id` INT,
  `start_time` DATETIME,
  `end_time` DATETIME,
  `is_booked` BOOLEAN DEFAULT false,
  CONSTRAINT fk_consultant FOREIGN KEY (`consultant_id`) REFERENCES `ltp`.`consultant` (`consultant_id`),
  CONSTRAINT fk_client FOREIGN KEY (`client_id`) REFERENCES `ltp`.`client` (`client_id`)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------
-- Trigger
-- -----------------------------------------------------

DELIMITER //
CREATE TRIGGER after_slot_update
AFTER UPDATE ON `ltp`.`slot`
FOR EACH ROW
BEGIN
  IF NEW.is_booked = true AND OLD.is_booked = false THEN
    INSERT INTO `ltp`.`booking` (`consultant_id`, `client_id`, `slot_id`, `booking_date`, `booking_time`)
    VALUES (NEW.consultant_id, NEW.client_id, NEW.slot_id, NOW(), NOW());
  END IF;
END;
//
DELIMITER ;


-- -----------------------------------------------------
-- Table `ltp`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ltp`.`booking` (
  `booking_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `consultant_id` INT NULL DEFAULT NULL,
  `client_id` INT NULL DEFAULT NULL,
  `slot_id` INT NULL DEFAULT NULL,
  `booking_date` DATETIME(6) NULL DEFAULT NULL,
  `booking_time` TIME NOT NULL,
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`consultant_id`) REFERENCES `ltp`.`consultant` (`consultant_id`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`client_id`) REFERENCES `ltp`.`client` (`client_id`),
  CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`slot_id`) REFERENCES `ltp`.`slot` (`slot_id`)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `ltp`.`document`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ltp`.`document` (
  `document_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `document_name` VARCHAR(255) NOT NULL
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `ltp`.`sessionhistory`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ltp`.`sessionhistory` (
  `session_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `consultant_id` INT NULL DEFAULT NULL,
  `client_id` INT NULL DEFAULT NULL,
  `session_date` DATE NOT NULL,
  `session_time` TIME NOT NULL,
  CONSTRAINT `sessionhistory_ibfk_1` FOREIGN KEY (`consultant_id`) REFERENCES `ltp`.`consultant` (`consultant_id`),
  CONSTRAINT `sessionhistory_ibfk_2` FOREIGN KEY (`client_id`) REFERENCES `ltp`.`client` (`client_id`)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `ltp`.`feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ltp`.`feedback` (
  `feedback_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `consultant_id` INT NULL DEFAULT NULL,
  `client_id` INT NULL DEFAULT NULL,
  `session_id` INT NULL DEFAULT NULL,
  `feedback_text` TEXT NULL DEFAULT NULL,
  `rating` INT NULL DEFAULT NULL,
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`consultant_id`) REFERENCES `ltp`.`consultant` (`consultant_id`),
  CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`client_id`) REFERENCES `ltp`.`client` (`client_id`),
  CONSTRAINT `feedback_ibfk_3` FOREIGN KEY (`session_id`) REFERENCES `ltp`.`sessionhistory` (`session_id`)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `ltp`.`sessiondocument`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ltp`.`sessiondocument` (
  `session_id` INT NOT NULL,
  `document_id` INT NOT NULL,
  PRIMARY KEY (`session_id`, `document_id`),
  CONSTRAINT `sessiondocument_ibfk_1` FOREIGN KEY (`session_id`) REFERENCES `ltp`.`sessionhistory` (`session_id`),
  CONSTRAINT `sessiondocument_ibfk_2` FOREIGN KEY (`document_id`) REFERENCES `ltp`.`document` (`document_id`)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
