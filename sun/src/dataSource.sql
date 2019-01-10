// 菜单管理表
// id: 菜单id(主键,自增),menu_name:菜单名,up_id:上级菜单id
create table menu(id int auto_increment primary key,menu_name varchar(20),up_id);

// 初始化菜单表
insert into menu values(null,'系统菜单',null);
insert into menu values(null,'管理菜单',1);

// 角色表
// id: 角色id(主键,自增),role_name:角色名,menu_id:菜单id(外键,menu.id)
create table role(id int auto_increment primary key,role_name varchar(10),menu_id int);

// 初始化角色表
insert into role values(null,'超级管理员',2);
insert into role values(null,'管理员',2);
insert into role values(null,'用户',3);

// 用户表
// id:用户id(主键,自增),username:账号,password:密码,role_id:角色id(外键,role.id)
create table user(id int auto_increment primary key,username varchar(20),password varchar(20), role_id int);

// 初始化用户表
insert into user values(null,'admin','root',1);