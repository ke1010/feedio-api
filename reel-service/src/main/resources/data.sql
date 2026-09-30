INSERT INTO reels_db(id, video_url, likes, comments, caption)
VALUES
    (1, 'https://res.cloudinary.com/dplis0hms/video/upload/v1761305819/indian_thali_ovoola.mp4', 872, 9856, 'Delicciioous'),
    (2, 'https://res.cloudinary.com/dplis0hms/video/upload/v1761305845/pizza_domino_zer84w.mp4', 324, 67, 'Pizza Mania'),
    (3, 'https://res.cloudinary.com/dplis0hms/video/upload/v1761305833/mcd_burger_gxwhhs.mp4', 33, 9, 'Burrrrrgeeerr'),
    (4, 'https://res.cloudinary.com/dplis0hms/video/upload/v1761225573/cake_shake_am66cp.mp4', 897, 3321, 'Cake Shake..');

INSERT INTO like_db(id, userId, reelId)
VALUES
    (1,1, 4),
    (2, 1, 3),
    (3, 2, 3),
    (4, 3,1);


INSERT INTO comment_db(id, userId, reelId, content)
VALUES
    (1,1, 4, ''),
    (2, 1, 3, ''),
    (3, 2, 3, ''),
    (4, 3,1, '');
