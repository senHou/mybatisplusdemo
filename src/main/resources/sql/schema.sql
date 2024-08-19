create table user_info
(
    user_id     varchar(64)          not null primary key,
    username    varchar(100)         null ,
    age         int(3)               null ,
    gender      varchar(1)           null ,
    remark      varchar(255)         null ,
    create_time datetime             null ,
    create_id   varchar(64)          null ,
    update_time datetime             null ,
    update_id   varchar(64)          null ,
    enabled     tinyint(1) default 1 null
);