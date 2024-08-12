create database example_tasks_db;

\c example_tasks_db;

CREATE TYPE TaskStatusEnum AS ENUM (
    'NOT_STARTED', 
    'IN_PROGRESS', 
    'PAUSED', 
    'BLOCKED',
    'DONE');

CREATE TABLE IF NOT EXISTS task (
    task_id              serial primary key,
    task_summary         varchar(765),
    task_active          boolean not null default true, 
    task_status          TaskStatusEnum not null default 'NOT_STARTED',
    task_created         timestamp not null default now(),
    task_modified        timestamp not null default now()
);

