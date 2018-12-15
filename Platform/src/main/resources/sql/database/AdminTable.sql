create TABLE admin (
cnp varchar(11) not null,
name varchar(30),
surname varchar(30),
    pass varchar(30),
    external_email varchar(30),
    internal_email varchar(30),
    PRIMARY KEY (cnp)
);