INSERT INTO
    students (
        student_id,
        cgpa,
        total_credits,
        domain,
        email,
        first_name,
        graduation_year,
        last_name,
        password,
        photograph_path,
        placement_id,
        roll_number,
        specialisation
    )
VALUES
    (
        1,
        2.8,
        28,
        'CSE',
        'tathagata.talukdar@gmail.com',
        'Tathagata',
        2025,
        'Talukdar',
        'changeme',
        'url/1',
        69,
        189,
        'AIML'
    );

INSERT INTO
    students (
        student_id,
        cgpa,
        total_credits,
        domain,
        email,
        first_name,
        graduation_year,
        last_name,
        password,
        photograph_path,
        placement_id,
        roll_number,
        specialisation
    )
VALUES
    (
        2,
        3.9,
        20,
        'CSE',
        'alex.ayyup@gmail.com',
        'Alex',
        2025,
        'Ayyup',
        'changeme',
        'url/2',
        420,
        179,
        'Networking'
    );

INSERT INTO
    students (
        student_id,
        cgpa,
        total_credits,
        domain,
        email,
        first_name,
        graduation_year,
        last_name,
        password,
        photograph_path,
        placement_id,
        roll_number,
        specialisation
    )
VALUES
    (
        3,
        3.6,
        23,
        'ECE',
        'paul.walker@gmail.com',
        'Paul',
        2025,
        'Walker',
        'changeme',
        'url/3',
        109,
        173,
        'VLSI'
    );

INSERT INTO
    students (
        student_id,
        cgpa,
        total_credits,
        domain,
        email,
        first_name,
        graduation_year,
        last_name,
        password,
        photograph_path,
        placement_id,
        roll_number,
        specialisation
    )
VALUES
    (
        4,
        3.4,
        25,
        'ECE',
        'lionel.messi@gmail.com',
        'Lionel',
        2025,
        'Messi',
        'changeme',
        'url/4',
        110,
        166,
        'VLSI'
    );

INSERT INTO
    students (
        student_id,
        cgpa,
        total_credits,
        domain,
        email,
        first_name,
        graduation_year,
        last_name,
        password,
        photograph_path,
        placement_id,
        roll_number,
        specialisation
    )
VALUES
    (
        5,
        3.1,
        24,
        'ECE',
        'cristiano.ronaldo@gmail.com',
        'Cristiano',
        2025,
        'Ronaldo',
        'changeme',
        'url/5',
        109,
        123,
        'Digital Design'
    );

INSERT INTO
    student_sequence (next_val)
VALUES
    (6);

INSERT INTO
    bills (
        id,
        amount,
        bill_date,
        deadline,
        description,
        student_id,
        paid
    )
VALUES
    (
        1,
        70000,
        '2023-10-28',
        '2023-10-30',
        'Hostel fees',
        1,
        false
    );

INSERT INTO
    bills (
        id,
        amount,
        bill_date,
        deadline,
        description,
        student_id,
        paid
    )
VALUES
    (
        2,
        350000,
        '2023-10-28',
        '2024-03-28',
        'Semester fees',
        1,
        true
    );

INSERT INTO
    bills (
        id,
        amount,
        bill_date,
        deadline,
        description,
        student_id,
        paid
    )
VALUES
    (
        3,
        20000,
        '2023-10-28',
        '2024-03-28',
        'Mess fees',
        1,
        false
    );

INSERT INTO
    bills (
        id,
        amount,
        bill_date,
        deadline,
        description,
        student_id,
        paid
    )
VALUES
    (
        5,
        70000,
        '2023-10-28',
        '2024-10-30',
        'Hostel fees',
        2,
        false
    );

INSERT INTO
    bills (
        id,
        amount,
        bill_date,
        deadline,
        description,
        student_id,
        paid
    )
VALUES
    (
        6,
        350000,
        '2023-10-28',
        '2024-03-28',
        'Semester fees',
        2,
        false
    );

INSERT INTO
    bills (
        id,
        amount,
        bill_date,
        deadline,
        description,
        student_id,
        paid
    )
VALUES
    (
        7,
        20000,
        '2023-10-28',
        '2024-03-28',
        'Mess fees',
        2,
        false
    );

INSERT INTO
    bill_sequence (next_val)
VALUES
    (8);

INSERT INTO
    student_payment (
        id,
        amount,
        description,
        payment_date,
        bill_id,
        student_id
    )
VALUES
    (1, 29000, 'second payment', '2023-10-29', 1, 1);

INSERT INTO
    student_payment (
        id,
        amount,
        description,
        payment_date,
        bill_id,
        student_id
    )
VALUES
    (2, 30000, 'first payment', '2023-10-28', 1, 1);

INSERT INTO
    student_payment (
        id,
        amount,
        description,
        payment_date,
        bill_id,
        student_id
    )
VALUES
    (3, 200000, 'First Payment', '2023-12-20', 2, 1);

INSERT INTO
    student_payment (
        id,
        amount,
        description,
        payment_date,
        bill_id,
        student_id
    )
VALUES
    (4, 150000, 'Second Payment', '2023-12-23', 2, 1);

INSERT INTO
    studentpayment_sequence (next_val)
VALUES
    (3);