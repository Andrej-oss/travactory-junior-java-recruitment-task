
INSERT INTO customers
  (id, first_name, last_name, email, gender, date_of_birth)
VALUES
  (1, 'John', 'Doe', 'john.doe@gmail.com', 'M', '1989-12-10 00:00:00'),
  (2, 'John', 'Child', 'john.child@gmail.com', 'M', '2012-12-10 00:00:00'),
  (3, 'Jessica', 'Doe', 'jessica.doe@gmail.com', 'F', '1991-12-10 00:00:00');

INSERT INTO bookings
  (id, departure_airport_id, destination_airport_id, departure_date, arrival_date, customer_id, passenger_price, passengers, class_type)
VALUES
  (1, 1, 2, '2018-02-22 08:05:00', '2018-02-22 13:10:00', 1, 123.45, 3, 'F'),
  (2, 1, 3, '2018-02-24 12:30:00', '2018-02-24 14:42:00', 1, 276.12, 2, 'E');

INSERT INTO airports
  (id, code, name, gmt_time_zone_offset)
VALUES
  (1, 'AMS', 'Amsterdam Shiphol', 2),
  (2, 'JFK', 'New York JFK', -4),
  (3, 'BCN', 'Barcelona', 2);

