-- Create databases
CREATE DATABASE IF NOT EXISTS clients_db;
CREATE DATABASE IF NOT EXISTS cars_db;

-- Create user and grant privileges
CREATE USER IF NOT EXISTS 'user'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON clients_db.* TO 'user'@'%';
GRANT ALL PRIVILEGES ON cars_db.* TO 'user'@'%';

-- Apply changes
FLUSH PRIVILEGES;