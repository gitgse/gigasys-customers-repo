DROP DATABASE IF EXISTS gigasys_customers;

CREATE DATABASE gigasys_customers;
GRANT ALL ON DATABASE gigasys_customers TO appli;

\connect gigasys_customers;

CREATE SCHEMA customers;
GRANT ALL ON SCHEMA customers TO appli;

ALTER DEFAULT PRIVILEGES IN SCHEMA customers GRANT ALL ON TABLES TO appli;
ALTER DEFAULT PRIVILEGES IN SCHEMA customers GRANT USAGE, SELECT ON SEQUENCES TO appli;

SET search_path=customers;

CREATE TABLE customers(customer_id SERIAL PRIMARY KEY,
					category CHAR(1) NOT NULL,
					name VARCHAR(255) NOT NULL,
					firstname VARCHAR(255),
					since DATE NOT NULL,
					email VARCHAR(255) NOT NULL,
					phone VARCHAR(16),
					address_number INT NOT NULL,
					address_street VARCHAR(255) NOT NULL,
					address_details VARCHAR(255),
					address_postalcode VARCHAR(10) NOT NULL,
					address_city VARCHAR(255) NOT NULL,
					address_region VARCHAR(255) NOT NULL,
					address_country CHAR(2) NOT NULL,
					password VARCHAR(72) NOT NULL,
					CONSTRAINT category_check CHECK (category IN ('r', 'c', 'p')));

ALTER SEQUENCE customers.customers_customer_id_seq INCREMENT BY 5;
