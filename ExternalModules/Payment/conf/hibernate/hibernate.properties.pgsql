hibernate.connection.driver_class = org.postgresql.Driver
hibernate.connection.url = jdbc:postgresql://localhost:5432/mpg_saintgermain
hibernate.connection.username = capdemat
hibernate.connection.password = capdematpass
hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
hibernate.format_sql = true

hibernate.connection.provider_class = org.hibernate.connection.C3P0ConnectionProvider
hibernate.c3p0.initialPoolSize = 3
hibernate.c3p0.acquire_increment = 1
hibernate.c3p0.min_size = 3
hibernate.c3p0.max_size = 12
hibernate.c3p0.max_statements = 0

hibernate.show_sql = false
#hibernate.hbm2ddl.auto = update

