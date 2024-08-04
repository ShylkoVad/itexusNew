CREATE TABLE IF NOT EXISTS itexusnew.users (
    id              INT             NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name      VARCHAR(50)     NOT NULL,
    last_name       VARCHAR(50)     NOT NULL,
    email           VARCHAR(100)    NOT NULL UNIQUE,
    phone_number_1  VARCHAR(15)     NOT NULL,
    phone_number_2  VARCHAR(15),
    phone_number_3  VARCHAR(15),
    role_user_1     VARCHAR(15)     NOT NULL CHECK (role_user_1 IN ('ADMIN', 'USER', 'GUEST')),
    role_user_2     VARCHAR(15)              CHECK (role_user_2 IN ('ADMIN', 'USER', 'GUEST')),
    role_user_3     VARCHAR(15)              CHECK (role_user_3 IN ('ADMIN', 'USER', 'GUEST')),

    UNIQUE INDEX IDX_USERS_USER_ID_UNIQUE (id ASC),
    UNIQUE INDEX IDX_USERS_EMAIL_UNIQUE (email ASC),
    UNIQUE INDEX IDX_USERS_PHONE_NUMBER_1_UNIQUE (phone_number_1 ASC),
    UNIQUE INDEX IDX_USERS_PHONE_NUMBER_2_UNIQUE (phone_number_2 ASC),
    UNIQUE INDEX IDX_USERS_PHONE_NUMBER_3_UNIQUE (phone_number_3 ASC)
    );

INSERT INTO itexusnew.users (first_name, last_name, email, phone_number_1, phone_number_2, phone_number_3,
                             role_user_1, role_user_2, role_user_3)
VALUES ('Вадим', 'Шилько', 'shilko_vad@mail.ru', '375297191205', '375290000000',
        null, 'USER', 'ADMIN', null);

INSERT INTO itexusnew.users (first_name, last_name, email, phone_number_1, phone_number_2, phone_number_3,
                             role_user_1, role_user_2, role_user_3)
VALUES ('Даша', 'Шилько', 'dasha@mail.ru', '375291111111', null,
        null, 'USER', null, null);