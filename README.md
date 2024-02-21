# Poker texas hold`em

RESTFul services for Poker Texas Hold`em game, from 1 to up to 8 players.

A native application was deployed inside a container and is available at: https://quarkus-texas-hold-em-eacb70241382.herokuapp.com/

This project uses Quarkus, the Supersonic Subatomic Java Framework, Redis for fast response, H2 database (Secondary), JPA entity and Hibernate ORM with Panache.

## Running the application in dev mode

```shell script
./mvnw compile quarkus:dev
```

## Related Guides

- JDBC Driver - H2 ([guide](https://quarkus.io/guides/datasource)): Connect to the H2 database via JDBC
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
