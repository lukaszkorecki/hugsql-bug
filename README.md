Repro for https://github.com/layerware/hugsql/issues/35

To run:


```
./script/ps # starts postgresql
lein test # runs tests
```

# what happens?

Second query throws an error:

```
ERROR in (a-test) (QueryExecutorImpl.java:2505)
expected: (= 3 (core/find-widgets-broken conn {:added-since "1 day"}))
  actual: org.postgresql.util.PSQLException: ERROR: syntax error at or near "$1"
  Position: 72
 at org.postgresql.core.v3.QueryExecutorImpl.receiveErrorResponse (QueryExecutorImpl.java:2505)
    org.postgresql.core.v3.QueryExecutorImpl.processResults (QueryExecutorImpl.java:2241)
    org.postgresql.core.v3.QueryExecutorImpl.execute (QueryExecutorImpl.java:310)
    org.postgresql.jdbc.PgStatement.executeInternal (PgStatement.java:447)
    org.postgresql.jdbc.PgStatement.execute (PgStatement.java:368)
    org.postgresql.jdbc.PgPreparedStatement.executeWithFlags (PgPreparedStatement.java:158)
    org.postgresql.jdbc.PgPreparedStatement.execute (PgPreparedStatement.java:147)
    com.zaxxer.hikari.pool.ProxyPreparedStatement.execute (ProxyPreparedStatement.java:44)
    com.zaxxer.hikari.pool.HikariProxyPreparedStatement.execute (HikariProxyPreparedStatement.java:-1)
    next.jdbc.result_set$stmt__GT_result_set.invokeStatic (result_set.clj:509)
    next.jdbc.result_set$stmt__GT_result_set.invoke (result_set.clj:504)
    next.jdbc.result_set$eval1575$fn__1583.invoke (result_set.clj:628)
    next.jdbc.protocols$eval1003$fn__1034$G__994__1043.invoke (protocols.clj:33)
    next.jdbc.result_set$eval1611$fn__1616.invoke (result_set.clj:688)
    next.jdbc.protocols$eval1003$fn__1034$G__994__1043.invoke (protocols.clj:33)
    next.jdbc$execute_BANG_.invokeStatic (jdbc.clj:202)
    next.jdbc$execute_BANG_.invoke (jdbc.clj:189)
    hugsql.adapter.next_jdbc.HugsqlAdapterNextJdbc.query (next_jdbc.clj:20)
    hugsql.adapter$eval5276$fn__5339$G__5258__5344.invoke (adapter.clj:3)
    hugsql.adapter$eval5276$fn__5339$G__5257__5350.invoke (adapter.clj:3)
    clojure.lang.Var.invoke (Var.java:399)
    hugsql.core$db_fn_STAR_$y__6727.doInvoke (core.clj:458)
    clojure.lang.RestFn.invoke (RestFn.java:445)
    hugsql.core$db_fn_STAR_$y__6727.invoke (core.clj:448)
    hugsql_interval_bug.core_test$fn__6984.invokeStatic (core_test.clj:26)
    hugsql_interval_bug.core_test/fn (core_test.clj:17)
    clojure.test$test_var$fn__9707.invoke (test.clj:717)
    clojure.test$test_var.invokeStatic (test.clj:717)

```
