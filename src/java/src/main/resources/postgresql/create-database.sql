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

CREATE TYPE UserGroupEnum AS ENUM (
    'VIEWER', 
    'EDITOR', 
    'ADMIN');

CREATE TABLE IF NOT EXISTS user (
    user_id              serial primary key,
    user_name            varchar(510),
    user_email           varchar(510) not null,
    user_secret          varchar(510) not null,
    user_active          boolean not null default true,
    user_group           UserGroupEnum not null default 'VIEWER',
    user_created         timestamp not null default now(),
    user_modified        timestamp not null default now()
);