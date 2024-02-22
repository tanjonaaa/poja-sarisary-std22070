create table if not exists "file_processing" (
    id text primary key,
    transformation_timestamp timestamp not null default (strftime('%Y-%m-%d %H:%M:%S', 'now'))
);