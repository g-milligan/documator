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

CREATE TABLE IF NOT EXISTS usr (
    usr_id              serial primary key,
    usr_name            varchar(510),
    usr_email           varchar(510) not null,
    usr_secret          varchar(510) not null,
    usr_active          boolean not null default true,
    usr_group           UserGroupEnum not null default 'VIEWER',
    usr_created         timestamp not null default now(),
    usr_modified        timestamp not null default now()
);