# PostgreSQL Setup (macOS)

To start PostgreSQL 14 as a background service and enable restart at login:

```sh
brew services start postgresql@14
```

If you do not need a background service, you can run PostgreSQL directly:

```sh
/opt/homebrew/opt/postgresql@14/bin/postgres -D /opt/homebrew/var/postgresql@14
```

# To stop the PostgreSQL service:

```sh
brew services stop postgresql@14
```

# To connect to PostgreSQL:

```sh
psql -U <username> -d <database_name>   
``` 
# Create a new Role and Database with all privileges 
```sh
psql postgres
"CREATE ROLE postgres WITH LOGIN PASSWORD 'yourpassword';
CREATE DATABASE taskflow_ai WITH OWNER postgres;
GRANT ALL PRIVILEGES ON DATABASE taskflow_ai TO postgres;
```

# Spring Boot PostgreSQL Configuration
# Update your `application.properties` (or `application.yml`) with PostgreSQL credentials:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/taskflow_ai
spring.datasource.username=postgres
spring.datasource.password=yourpassword
```
Some other important postgres related properties you might consider:

```properties
# tells Hibernate to automatically update the database schema to match your JPA entity
spring.jpa.hibernate.ddl-auto=update
# Enable SQL logging
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true 
# Connection pool settings
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-idle=5
spring.datasource.hikari.idle-timeout=30000
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.max-lifetime=60000
# Enable caching
spring.cache.type=simple
spring.cache.cache-names=users,tasks,categories
```

             