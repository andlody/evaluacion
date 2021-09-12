INSERT INTO users (name, email, password,created,last_login,is_active) VALUES
  ('Andree Ochoa', 'andlody@gmail.com', 'Abc123',NOW(),NOW(),true);

INSERT INTO phones (user_id, number, citycode, contrycode) VALUES
  (1, '966833833', '66', '51');