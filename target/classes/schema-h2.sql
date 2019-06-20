CREATE TABLE USER
        (
        id NUMBER(10) NOT NULL,
        balance VARCHAR2(50),
        email VARCHAR2(50),
        name VARCHAR2(50),
        password VARCHAR2(50),
        penalty VARCHAR2(50),
        surname VARCHAR2(50),
        username VARCHAR2(50)
        );
        
CREATE TABLE ITEM
        (
        id NUMBER(10) NOT NULL,
        buyer_id VARCHAR2(50),
        description VARCHAR2(50),
        end_date VARCHAR2(50),
        name VARCHAR2(50),
        price VARCHAR2(50),
        seller_id VARCHAR2(50),
        topic VARCHAR2(50)
        );
        
CREATE TABLE PURCHASE
        (
        id NUMBER(10) NOT NULL,
        buyer_id VARCHAR2(50),
        description VARCHAR2(50),
        end_date VARCHAR2(50),
        name VARCHAR2(50),
        price VARCHAR2(50),
        purchase_date VARCHAR2(50),
        seller_id VARCHAR2(50),
        status VARCHAR2(50),
        topic VARCHAR2(50)
        );
        
CREATE TABLE RESULT
        (
        id NUMBER(10) NOT NULL,
        date_time VARCHAR2(50),
        description VARCHAR2(50),
        from_whom_id VARCHAR2(50),
        to_whom_id VARCHAR2(50),
        );       