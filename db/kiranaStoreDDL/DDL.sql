--------------------------------------------------------
--  File created - Saturday-May-13-2017   
--------------------------------------------------------
CREATE SEQUENCE HIBERNATE_SEQUENCE  MINVALUE 1000 INCREMENT BY 1
--------------------------------------------------------
--  DDL for Table ADDRESS
--------------------------------------------------------

  CREATE TABLE ADDRESS (ID NUMBER(19,0), DELETED NUMBER(1,0), CREATED_DATE TIMESTAMP (6), UPDATED_DATE TIMESTAMP (6), COUNTRY VARCHAR2(255 CHAR), LINE1 VARCHAR2(255 CHAR), LINE2 VARCHAR2(255 CHAR), PIN_CODE VARCHAR2(255 CHAR), STATE VARCHAR2(255 CHAR))

--------------------------------------------------------
--  DDL for Table CATEGORY
--------------------------------------------------------

  CREATE TABLE CATEGORY (ID NUMBER(19,0), DELETED NUMBER(1,0), CREATED_DATE TIMESTAMP (6), UPDATED_DATE TIMESTAMP (6), CODE VARCHAR2(255 CHAR), DESCRIPTION VARCHAR2(255 CHAR), DISPLAY_NAME VARCHAR2(255 CHAR), IMAGE_URL VARCHAR2(255 CHAR))
--------------------------------------------------------
--  DDL for Table CUSTOMER
--------------------------------------------------------

  CREATE TABLE CUSTOMER (ID NUMBER(19,0), DELETED NUMBER(1,0), CREATED_DATE TIMESTAMP (6), UPDATED_DATE TIMESTAMP (6), DOB DATE, FIRST_NAME VARCHAR2(255 CHAR), GENDER VARCHAR2(255 CHAR), LAST_NAME VARCHAR2(255 CHAR), MIDDLE_NAME VARCHAR2(255 CHAR), PRIMARY_NUMBER VARCHAR2(255 CHAR), SECONDARY_NUMBER VARCHAR2(255 CHAR))
--------------------------------------------------------
--  DDL for Table DELIVERY_DETAILS
--------------------------------------------------------

  CREATE TABLE DELIVERY_DETAILS (ID NUMBER(19,0), DELETED NUMBER(1,0), CREATED_DATE TIMESTAMP (6), UPDATED_DATE TIMESTAMP (6), DELIVERY_COST FLOAT(126), DELIVERY_DATE TIMESTAMP (6), DELIVERY_OPTION VARCHAR2(255 CHAR), ADDRESS_ID NUMBER(19,0))
--------------------------------------------------------
--  DDL for Table INVOICE
--------------------------------------------------------

  CREATE TABLE INVOICE (ID NUMBER(19,0), DELETED NUMBER(1,0), CREATED_DATE TIMESTAMP (6), UPDATED_DATE TIMESTAMP (6), NET_PAYBLE_PRICE FLOAT(126), TOTAL_ACTAUL_PRICE FLOAT(126), TOTAL_DISCOUNT FLOAT(126), CUSTOMER_ID NUMBER(19,0), DELIVERYDETAILS_ID NUMBER(19,0), ORDER_ID NUMBER(19,0))
--------------------------------------------------------
--  DDL for Table ITEM
--------------------------------------------------------

  CREATE TABLE ITEM (ID NUMBER(19,0), DELETED NUMBER(1,0), CREATED_DATE TIMESTAMP (6), UPDATED_DATE TIMESTAMP (6), CATEGEORY_CODE VARCHAR2(255 CHAR), CODE VARCHAR2(255 CHAR), DISCOUNTCODE VARCHAR2(255 CHAR), ITEM_UNIT_COUNT NUMBER(19,0), MINIIMAGEURL VARCHAR2(255 CHAR), NAME VARCHAR2(255 CHAR), PRICE FLOAT(126), UNITTYPECODE VARCHAR2(255 CHAR))
--------------------------------------------------------
--  DDL for Table ITEM_DETAILS
--------------------------------------------------------

  CREATE TABLE ITEM_DETAILS (ID NUMBER(19,0), DELETED NUMBER(1,0), CREATED_DATE TIMESTAMP (6), UPDATED_DATE TIMESTAMP (6), DESCRIPTION VARCHAR2(255 CHAR), KEY_FEATURES VARCHAR2(255 CHAR), LARGE_IMAGE_URL VARCHAR2(255 CHAR), ITEM_ID NUMBER(19,0))
--------------------------------------------------------
--  DDL for Table OFFER
--------------------------------------------------------

  CREATE TABLE OFFER (ID NUMBER(19,0), DELETED NUMBER(1,0), CREATED_DATE TIMESTAMP (6), UPDATED_DATE TIMESTAMP (6), CODE VARCHAR2(255 CHAR), DESCRIPTION VARCHAR2(255 CHAR), END_DATE TIMESTAMP (6), IS_ACTIVE NUMBER(1,0), OFFER_TYPE VARCHAR2(255 CHAR), START_DATE TIMESTAMP (6))
--------------------------------------------------------
--  DDL for Table ORDERS
--------------------------------------------------------

  CREATE TABLE ORDERS (ID NUMBER(19,0), DELETED NUMBER(1,0), CREATED_DATE TIMESTAMP (6), UPDATED_DATE TIMESTAMP (6), DELIVERY_DETAILS VARCHAR2(255 CHAR), ORDER_CODE VARCHAR2(255 CHAR), ORDER_STATUS VARCHAR2(255 CHAR), CUSTOMER_ID NUMBER(19,0))
--------------------------------------------------------
--  DDL for Table ORDER_ITEM
--------------------------------------------------------

  CREATE TABLE ORDER_ITEM (ID NUMBER(19,0), DELETED NUMBER(1,0), CREATED_DATE TIMESTAMP (6), UPDATED_DATE TIMESTAMP (6), ITEM_ID NUMBER(19,0), ITEM_QUANTITY NUMBER(19,0), ORDER_ID NUMBER(19,0))
--------------------------------------------------------
--  DDL for Table UNIT_TYPE
--------------------------------------------------------

  CREATE TABLE UNIT_TYPE (ID NUMBER(19,0), DELETED NUMBER(1,0))
REM INSERTING into ADDRESS
SET DEFINE OFF;
REM INSERTING into CATEGORY
SET DEFINE OFF;
REM INSERTING into CUSTOMER
SET DEFINE OFF;
REM INSERTING into DELIVERY_DETAILS
SET DEFINE OFF;
REM INSERTING into INVOICE
SET DEFINE OFF;
REM INSERTING into ITEM
SET DEFINE OFF;
REM INSERTING into ITEM_DETAILS
SET DEFINE OFF;
REM INSERTING into OFFER
SET DEFINE OFF;
REM INSERTING into ORDERS
SET DEFINE OFF;
REM INSERTING into ORDER_ITEM
SET DEFINE OFF;
REM INSERTING into UNIT_TYPE
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index UK_ACATPLU22Q5D1ANDQL2JBVJY7
--------------------------------------------------------

  CREATE UNIQUE INDEX UK_CATEGORY_IDX ON CATEGORY (CODE)
--------------------------------------------------------
--  DDL for Index UK_6CGOGDARKQ48DLG1LBNV4Q1OQ
--------------------------------------------------------

  CREATE UNIQUE INDEX UK_ITEM_IDEX ON ITEM (CODE)
--------------------------------------------------------
--  Constraints for Table OFFER
--------------------------------------------------------

  ALTER TABLE OFFER MODIFY (ID NOT NULL ENABLE)
 
  ALTER TABLE OFFER ADD PRIMARY KEY (ID) ENABLE
--------------------------------------------------------
--  Constraints for Table CATEGORY
--------------------------------------------------------

  ALTER TABLE CATEGORY MODIFY (ID NOT NULL ENABLE)
 
  ALTER TABLE CATEGORY MODIFY (CODE NOT NULL ENABLE)
 
  ALTER TABLE CATEGORY ADD PRIMARY KEY (ID) ENABLE
 
  ALTER TABLE CATEGORY ADD CONSTRAINT UK_CATEGORY UNIQUE (CODE) ENABLE

--------------------------------------------------------
--  Constraints for Table ITEM
--------------------------------------------------------

  ALTER TABLE ITEM MODIFY (ID NOT NULL ENABLE)
 
  ALTER TABLE ITEM MODIFY (CODE NOT NULL ENABLE)
 
  ALTER TABLE ITEM ADD PRIMARY KEY (ID) ENABLE
 
  ALTER TABLE ITEM ADD CONSTRAINT UK_ITEM UNIQUE (CODE) ENABLE
--------------------------------------------------------
--  Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE ORDERS MODIFY (ID NOT NULL ENABLE)
 
  ALTER TABLE ORDERS ADD PRIMARY KEY (ID) ENABLE
--------------------------------------------------------
--  Constraints for Table CUSTOMER
--------------------------------------------------------

  ALTER TABLE CUSTOMER MODIFY (ID NOT NULL ENABLE)
 
  ALTER TABLE CUSTOMER ADD PRIMARY KEY (ID) ENABLE
--------------------------------------------------------
--  Constraints for Table INVOICE
--------------------------------------------------------

  ALTER TABLE INVOICE MODIFY (ID NOT NULL ENABLE)
 
  ALTER TABLE INVOICE ADD PRIMARY KEY (ID) ENABLE
--------------------------------------------------------
--  Constraints for Table DELIVERY_DETAILS
--------------------------------------------------------

  ALTER TABLE DELIVERY_DETAILS MODIFY (ID NOT NULL ENABLE)
 
  ALTER TABLE DELIVERY_DETAILS ADD PRIMARY KEY (ID) ENABLE
--------------------------------------------------------
--  Constraints for Table ITEM_DETAILS
--------------------------------------------------------

  ALTER TABLE ITEM_DETAILS MODIFY (ID NOT NULL ENABLE)
 
  ALTER TABLE ITEM_DETAILS ADD PRIMARY KEY (ID) ENABLE
--------------------------------------------------------
--  Constraints for Table ORDER_ITEM
--------------------------------------------------------

  ALTER TABLE ORDER_ITEM MODIFY (ID NOT NULL ENABLE)
 
  ALTER TABLE ORDER_ITEM ADD PRIMARY KEY (ID) ENABLE
--------------------------------------------------------
--  Constraints for Table ADDRESS
--------------------------------------------------------

  ALTER TABLE ADDRESS MODIFY (ID NOT NULL ENABLE)
 
  ALTER TABLE ADDRESS ADD PRIMARY KEY (ID) ENABLE
--------------------------------------------------------
--  Constraints for Table UNIT_TYPE
--------------------------------------------------------

  ALTER TABLE UNIT_TYPE MODIFY (ID NOT NULL ENABLE)
 
  ALTER TABLE UNIT_TYPE ADD PRIMARY KEY (ID) ENABLE
--------------------------------------------------------
--  Ref Constraints for Table DELIVERY_DETAILS
--------------------------------------------------------

  ALTER TABLE DELIVERY_DETAILS ADD CONSTRAINT FK_DD_ADDR FOREIGN KEY (ADDRESS_ID) REFERENCES ADDRESS (ID) ENABLE
--------------------------------------------------------
--  Ref Constraints for Table INVOICE
--------------------------------------------------------

  ALTER TABLE INVOICE ADD CONSTRAINT FK_INVOICE FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (ID) ENABLE
 
  ALTER TABLE INVOICE ADD CONSTRAINT FK_INVOICE_DD FOREIGN KEY (DELIVERYDETAILS_ID) REFERENCES DELIVERY_DETAILS (ID) ENABLE
 
  ALTER TABLE INVOICE ADD CONSTRAINT FK_INVOICE_ODR FOREIGN KEY (ORDER_ID) REFERENCES ORDERS (ID) ENABLE
--------------------------------------------------------
--  Ref Constraints for Table ITEM_DETAILS
--------------------------------------------------------

  ALTER TABLE ITEM_DETAILS ADD CONSTRAINT FK_ID_ITEM FOREIGN KEY (ITEM_ID) REFERENCES ITEM (ID) ENABLE
--------------------------------------------------------
--  Ref Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE ORDERS ADD CONSTRAINT FK_ORDERS_CUST FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (ID) ENABLE
--------------------------------------------------------
--  Ref Constraints for Table ORDER_ITEM
--------------------------------------------------------

  ALTER TABLE ORDER_ITEM ADD CONSTRAINT FK_OI_ODR FOREIGN KEY (ORDER_ID) REFERENCES ORDERS (ID) ENABLE
