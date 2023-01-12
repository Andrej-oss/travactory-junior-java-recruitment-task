
CREATE TABLE customers (
  id INT PRIMARY KEY auto_increment,
  first_name VARCHAR(256),
  last_name VARCHAR(256),
  email VARCHAR(256),
  gender  VARCHAR(1),
  date_of_birth TIMESTAMP
);

CREATE TABLE bookings (
  id INT PRIMARY KEY auto_increment,
  departure_airport_id INT,
  destination_airport_id INT,
  departure_date TIMESTAMP,
  arrival_date TIMESTAMP,
  customer_id INT,
  passenger_price DECIMAL(10, 2),
  passengers INT,
  class_type VARCHAR(1)
);

CREATE TABLE airports (
  id INT PRIMARY KEY auto_increment,
  code VARCHAR(256),
  name VARCHAR(256),
  gmt_time_zone_offset INT
);

