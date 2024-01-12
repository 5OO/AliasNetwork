CREATE TABLE contacts (
                          id SERIAL PRIMARY KEY,
                          first_name VARCHAR(100) NOT NULL,
                          last_name VARCHAR(100) NOT NULL,
                          code_name VARCHAR(100) NOT NULL,
                          phone_number VARCHAR(20) NOT NULL,
                          created_at TIMESTAMP NOT NULL DEFAULT NOW(),
                          updated_at TIMESTAMP,
                          deleted_at TIMESTAMP
);