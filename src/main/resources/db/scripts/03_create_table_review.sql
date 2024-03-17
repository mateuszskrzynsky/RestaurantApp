CREATE TABLE IF NOT EXISTS review
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    author      NOT NULL,
    comment     NOT NULL,
    rating      NOT NULL,

);