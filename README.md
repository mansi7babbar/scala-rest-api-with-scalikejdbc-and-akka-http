# Scala Rest API with ScalikeJDBC and Akka HTTP

- This project will help you to build Rest API using Akka HTTP. It will also help you to perform database operations using ScalikeJDBC.
- ScalikeJDBC is a SQL-based DB access library for Scala developers. This library naturally wraps JDBC APIs and provides you easy-to-use APIs. It allows writing SQL queries and mapping java.sql.ResultSet objects to Scala values.
- In this project, Connection Pooling approach is used for DB connection management.
- In this project, Akka HTTP is used which provides high-level routing APIs via a DSL to create and define the HTTP routes and how they should be handled. Each route is composed of one or more Directives in a nested fashion that defines how the request and response should be handled.

## Prerequisites

- Scala Build Tool(SBT), version 1.3.8
- Scala, version 2.12.6
- Postgres, version 9.6

## Project Repository

https://github.com/mansi7babbar/scala-rest-api-with-scalikejdbc-and-akka-http

## Steps for project execution

#### Create database schema in Postgres environment
- sudo su postgres
- psql
- \i ./scala-rest-api-with-scalikejdbc-and-akka-http/src/main/resources/dml.sql

#### Export environment variables
export URL=jdbc:postgresql://localhost/users_database

export DRIVER=org.postgresql.Driver

export USERNAME=postgres

export PASSWORD=knoldus

export PORT=8081

export INTERFACE=localhost

#### Enter command
- sbt run

#### Hit API at endpoint with specified port and interface
- http://your_interface:your_port/users
- example: http://localhost:8081/users
