(ns hugsql-interval-bug.core-test
  (:require [clojure.test :refer :all]
            [utility-belt.sql.conv]
            [utility-belt.sql.component.connection-pool :as cp]
            [hugsql-interval-bug.core :as core]))

(def cp
  (cp/create {:auto-commit true
              :pool-name "test"
              :adapter "postgresql"
              :username "hug"
              :password "password"
              :server-name "127.0.0.1"
              :port-number 5444
              :maximum-pool-size 2}))

(deftest a-test
  (let [conn  (.start cp)]
    (try
      (core/create-table conn)
      (core/reset conn)
      (core/add-widget conn {:title "test"})
      (core/add-widget conn {:title "test2"})
      (core/add-widget  conn {:title "tes3"})
      (is (= 3  (core/find-widgets conn)))
      (is (= 3 (core/find-widgets-broken conn {:added-since "1 day"})))
      (finally
        (.stop cp)))))
