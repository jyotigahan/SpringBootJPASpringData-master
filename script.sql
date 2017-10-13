
create table BOOKING(
BOOKING_ID number(10) not null,
PSNGR_NAME varchar2(100) not null,
DEPARTURE varchar2(100) not null,
DESTINATION varchar2(100) not null,
TRAVEL_DATE date not null,
constraint BOOKING_PK primary key (BOOKING_ID)
);

CREATE SEQUENCE BOOKINGSEQ INCREMENT BY 1 START WITH 1 MAXVALUE 1000000 MINVALUE 1 CACHE 20;
 