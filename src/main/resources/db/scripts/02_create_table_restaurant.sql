CREATE TABLE IF NOT EXISTS restaurant
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        NOT NULL,
    address     NOT NULL,
    kitchenType,
    openingHours,
    tables,
    reservation
);