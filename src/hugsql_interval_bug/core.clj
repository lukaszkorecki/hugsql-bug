(ns hugsql-interval-bug.core
  (:require [utility-belt.sql.model :as model]))

(model/load-sql-file "hugsql_interval_bug/test.sql" {:mode :kebab-case})
