-- :name create-table :!

create table if not exists widgets(
title text not null,
created_at timestamp not null)


-- :name reset :!
truncate table widgets;


-- :name add-widget :<! :1
insert into widgets (title, created_at)
values (:title, current_timestamp)
returning *

-- :name find-widgets :?

select * from widgets where created_at >= current_timestamp - interval '1 day';


-- :name find-widgets-broken :?

select * from widgets where created_at >= current_timestamp - interval :added-since::interval
