create table student(
    id int(3) auto_increment primary key ,
    name varchar(30) not null ,
    age int(3) not null ,
    tid int(3),
    constraint fk_tid foreign key(tid) references teacher(id)
);
create table teacher(
    id int(3) primary key auto_increment,
    name varchar(30) not null ,
    subject varchar(50) not null
);

insert into teacher values (default,'张老师','语文');
insert into teacher values (default,'李老师','数学');
insert into teacher values (default,'王老师','外语');
insert into teacher values (default,'赵老师','化学');

insert into student values (default,'同学1',18,1);
insert into student values (default,'同学2',18,1);
insert into student values (default,'同学3',18,1);
insert into student values (default,'同学4',18,2);
insert into student values (default,'同学5',18,3);
insert into student values (default,'同学6',18,4);