    create table booking (
       id bigint not null auto_increment,
        end_date date not null,
        start_date date not null,
        id_room bigint not null,
        id_user bigint not null,
        primary key (id)
    ) engine=MyISAM;
    
    create table booking_hotel_service (
       id_hotel_service bigint not null,
        id_booking bigint not null
    ) engine=MyISAM;
    
    create table hotel_service (
       id bigint not null auto_increment,
        name varchar(255) not null,
        price decimal(19,2) not null,
        primary key (id)
    ) engine=MyISAM;
    
    create table room (
       id bigint not null auto_increment,
        number varchar(255) not null,
        price decimal(19,2) not null,
        id_room_category bigint not null,
        primary key (id)
    ) engine=MyISAM;
    
    create table room_category (
       id bigint not null auto_increment,
        name varchar(255) not null,
        primary key (id)
    ) engine=MyISAM;
    
    create table user (
       id bigint not null auto_increment,
        first_name varchar(255),
        last_name varchar(255),
        primary key (id)
    ) engine=MyISAM;