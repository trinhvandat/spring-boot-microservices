create table properties (
    id int primary key auto_increment,
    application varchar(255) not null,
    profile varchar(255) default null,
    label varchar(255) default null,
    `key` varchar(255) not null,
    `value` varchar(255) not null
);

insert into properties(application, profile, `key`, `value`) VALUES
('application', 'default', 'test.message', 'Hello from leonard'),
('application', 'default', 'eureka.client.service-url.default-zone', 'http://localhost:8761');
