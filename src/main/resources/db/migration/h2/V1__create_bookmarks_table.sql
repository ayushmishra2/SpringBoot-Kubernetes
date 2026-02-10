create sequence bm_id_seq start with 1 increment by 50;
create table bookmarks (
    id bigint default nextval('bm_id_seq'),
    url varchar(2048) not null,
    title varchar(512) not null,
    created_at timestamp,
    primary key (id)
);