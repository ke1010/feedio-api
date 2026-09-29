INSERT INTO rest_db (id, name, address, img_url, ratings, latitude, longitude, is_active)
VALUES
    (1, 'Kesar Restaurant', 'Gajraula Chandpur Road', 'https://i.postimg.cc/j5XMVwhq/tandoori-chap.png', 3.9, 28.8486, 78.2383, true),
    (2, 'Moga Punjabi Dhaba', 'Opposite Gajraula Haveli Resort', 'https://i.postimg.cc/QMtBvh2F/Paneer-tikka.png', 4.4, 28.8412, 78.2311, true),
    (3, 'McDonald''s', 'Gajraula Moradabad Road', 'https://i.postimg.cc/kGhKhD45/burger-chicke.png', 4.5, 28.8510, 78.2450, true),
    (4, 'Haldiram', 'Gajraula Moradabad Road', 'https://i.postimg.cc/DZM9vdpm/chole-bhature.png', 4.5, 28.7945, 78.2362, true),
    (5, 'Dominoes', 'Gajraula Moradabad Road', 'https://i.postimg.cc/XYVwjWrC/pizza.png', 4.5, 28.7945, 78.2362, true);

INSERT INTO category_db (id, name, img_url)
VALUES
    (1, 'Burger', 'https://i.postimg.cc/YCT6TtT3/burger-Imge.png'),
    (2, 'Pizza', 'https://i.postimg.cc/x8sH5QKK/pizza-Image.png'),
    (3, 'Noodles', 'https://i.postimg.cc/W36ts9Z5/noodles-Image.png'),
    (4, 'Samosa', 'https://i.postimg.cc/2S4GNY6R/samosa-Image.png'),
    (5, 'Chole Bhature', 'https://i.postimg.cc/s2ph87YD/Chole-Bhature-removebg-preview.png'),
    (6, 'North Indian', 'https://i.postimg.cc/HLW7V1pK/north-indian.png');


INSERT INTO rest_cat_db (rest_id, cat_id)
VALUES
    (1, 1),
    (2, 1),
    (3, 1),
    (3, 2),
    (3, 4),
    (4, 1);



INSERT INTO menu_db (id, name, description, img_url, price, ratings, is_veg, rest_id, cat_id)
VALUES
    (1, 'Chole Bhature', 'Authentic Punjabi style chole with 2 fluffy bhatures', 'https://i.postimg.cc/DZM9vdpm/chole-bhature.png', 140.0, 4.0, true, 1, 5),
    (2, 'Farmhouse Pizza', 'Deluxe veggie pizza topped with capsicum, onion & mushroom', 'https://i.postimg.cc/XYVwjWrC/pizza.png', 399.0, 4.5, true, 5, 2),
    (3, 'McAloo Tikki Burger', 'Crispy potato patty with special mayo sauce', 'https://i.postimg.cc/kGhKhD45/burger-chicke.png', 65.0, 4.5, true, 3, 1),
    (4, 'Paneer Tikka', 'Charcoal grilled cottage cheese marinated in spices', 'https://i.postimg.cc/QMtBvh2F/Paneer-tikka.png', 260.0, 3.8, true, 1, 6);