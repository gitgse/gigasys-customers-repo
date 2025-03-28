DROP DATABASE IF EXISTS gigasys_products;

CREATE DATABASE gigasys_products;

\connect gigasys_products;

CREATE SCHEMA jobrepository;
CREATE SCHEMA products;

GRANT ALL ON SCHEMA jobrepository TO appli;
GRANT ALL ON SCHEMA products TO appli;

ALTER DEFAULT PRIVILEGES IN SCHEMA jobrepository GRANT ALL ON TABLES TO appli;
ALTER DEFAULT PRIVILEGES IN SCHEMA products GRANT ALL ON TABLES TO appli;

ALTER DEFAULT PRIVILEGES IN SCHEMA jobrepository GRANT USAGE, SELECT ON SEQUENCES TO appli;
ALTER DEFAULT PRIVILEGES IN SCHEMA products GRANT USAGE, SELECT ON SEQUENCES TO appli;

SET search_path=products,jobrepository;

CREATE TABLE products.category(category_id SERIAL PRIMARY KEY, name VARCHAR(100) NOT NULL);
CREATE TABLE products.products(product_id SERIAL PRIMARY KEY,
					category_id INT NOT NULL,
					name VARCHAR(100) NOT NULL,
					stock INT NOT NULL,
					price INT NOT NULL,
					warranty_years INT NOT NULL,
					CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES products.category(category_id));
CREATE TABLE products.orders(order_id SERIAL PRIMARY KEY,
					customer_id INT NOT NULL,
					date DATE NOT NULL,
					fullfilled_date DATE);
CREATE TABLE products.products_orders(
					order_id INT NOT NULL,
					product_id INT NOT NULL,
					quantity INT NOT NULL,
					price INT NOT NULL,
					PRIMARY KEY (order_id, product_id),
					CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES products.orders(order_id),
					CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES products.products(product_id));
CREATE TABLE products.inventory(serial_id SERIAL PRIMARY KEY,
					product_id INT NOT NULL,
					order_id INT,
					former_owner_id INT,
					owner_id INT,
					retailer_id INT,
					owner_email VARCHAR(255),
					CONSTRAINT check_owner_or_retailer CHECK (owner_id IS NULL OR retailer_id IS NULL),
					CONSTRAINT check_former_and_current_owner CHECK (owner_id IS NOT NULL OR former_owner_id IS NULL),
					CONSTRAINT fk_product_id FOREIGN KEY (product_id) REFERENCES products.products(product_id));

CREATE TABLE products.listing_requests(listing_request_id SERIAL PRIMARY KEY,
					customer_id INT NOT NULL,
					filename VARCHAR(100) NOT NULL,
					path VARCHAR(255) NOT NULL,
					date DATE NOT NULL,
					listing_type CHAR(1) NOT NULL,
					fullfilled_date DATE,
					status CHAR(1) NOT NULL,
					CONSTRAINT check_status CHECK (status in ('f', 'p', 'c')),
					CONSTRAINT check_listing_ype CHECK (listing_type in ('l', 'o', 't')));

