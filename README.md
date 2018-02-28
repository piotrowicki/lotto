# lotto

## Simple JavaEE application based on Tomee+, JSF, Primefaces, MySQL

Collecting lottery draws and generating as charts

* DS tomee.xml resource configuration

```
<Resource id="lottoDS" type="DataSource">
    JdbcDriver = com.mysql.jdbc.Driver
    JdbcUrl = jdbc:mysql://localhost/lotto
    UserName = xxx
    Password = yyy
    JtaManaged = true
    testOnBorrow = true
    validationQuery = SELECT 1
</Resource>
```
