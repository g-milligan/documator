\c example_tasks_db;

INSERT INTO task(
    task_summary
)
VALUES 
( 'Wake Up' ),
( 'Fold Clothes' ),
( 'Apply to Jobs' ),
( 'Practice Programming' ),
( 'All Fly' );

INSERT INTO usr(
    usr_name, usr_email, usr_secret, usr_group
)
VALUES 
( 'My Admin', 'milligangregg@gmail.com', '1234', 'ADMIN' ),
( 'My Editor', 'milligangregg@gmail.com', '123', 'EDITOR' ),
( 'My Viewer', 'tyleralias@hotmail.com', '12', 'VIEWER' );