package com.knoldus.infrastructure

import java.sql.Connection

import com.knoldus.{DatabaseConnection, User}
import com.typesafe.config.Config
import com.typesafe.scalalogging._
import scalikejdbc.{DB, DBSession, SQL}

class WriteUser(config: Config) extends LazyLogging {
  implicit val connection: Connection = DatabaseConnection.connection(config)
  implicit val session: DBSession = DB.autoCommitSession()

  def insertUsers(listOfUsers: List[User]): List[Int] = {
    logger.info("Inserting details of users into users table.")
    listOfUsers.map {
      user =>
        SQL("INSERT INTO users(name, username, email) VALUES(?, ?, ?)")
          .bind(user.name, user.username, user.email)
          .update.apply
    }
  }
}
