CREATE TABLE ACCOUNT(
	ID INT AUTO_INCREMENT PRIMARY KEY, 
	NAME VARCHAR(255),
	INSTANCE_ID VARCHAR(255),
	ACCOUNT_TYPE_ID INT,
	BANK_ID INT,
	CURRENCY_ID VARCHAR(255),
	INTERNAL BOOLEAN,
	INITIAL_BALANCE DOUBLE
);



