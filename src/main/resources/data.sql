INSERT INTO users (id, active, email, first_name, last_name, password)
VALUES (1, 1, 'admin@example.com', 'Admin', 'Adminov',
        '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151'),
       (2, 1, 'user@example.com', 'User', 'Userov',
        '95c1933b8ffe84f085f2839899d1673260be58dbd9c2c787ac35515805502c996417596dae9a92880aaa50a046fc7151');


INSERT INTO user_roles (`id`, `role`)
VALUES (1, 'ADMIN'),
       (2, 'USER');

INSERT INTO users_roles(`user_id`, `role_id`)
VALUES (1, 1),
       (1, 2),
       (2, 2);



insert into brands (id, name)
values (1, 'Toyota'),
       (2, 'Ford'),
       (3, 'Jeep');

insert into models (id, category, brand_id, name)
values (1, 'CAR', 1, 'Camry'),
       (2, 'CAR', 1, 'Corolla'),
       (3, 'CAR', 2, 'Focus'),
       (4, 'CAR', 2, 'Fiesta'),
       (5, 'CAR', 3, 'Grand Cherokee');

INSERT INTO offers (`id`, `description`, `engine`, `image_url`, `mileage`, `price`, `transmission`, `uuid`, `year`,
                    `model_id`)
VALUES (1, '4.7 V8 Quadra-Drivev', 'PETROL',
        'https://upload.wikimedia.org/wikipedia/commons/c/c7/Jeep_Grand_Cherokee_WJ_34h.jpg', 80000, 10000.00, 'AUTOMATIC',
        '53006e77-1dd2-4d96-ad84-f6a71ccc3d92', 2002, 5),
       (2, 'New Trash', 'ELECTRIC',
        'https://media.ed.edmunds-media.com/toyota/camry-hybrid/2023/oem/2023_toyota_camry-hybrid_sedan_se-nightshade_fq_oem_1_1280.jpg',
        2345, 20000.00, 'AUTOMATIC', '3ed5a989-62d0-4347-9b78-9f5af6b95287', 2023, 1),
       (3, '5.7 hemi monster', 'PETROL',
        'https://www.thedrive.com/uploads/2022/12/19/JP023_013GCbn5od164ctlln5cknkq4i6gl2h.jpg?auto=webp', 250,
        100000.00, 'AUTOMATIC', '3b07d6b7-c97e-4f3b-99d7-a8332f79d3ae', 2023, 5);


