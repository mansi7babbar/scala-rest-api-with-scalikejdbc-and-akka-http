package com.knoldus.infrastructure

import java.sql.Connection

import com.knoldus.{DatabaseConnection, User}
import com.typesafe.config.Config
import scalikejdbc.{DB, DBSession, SQL}
import com.typesafe.scalalogging._

class ReadUser(config: Config) extends LazyLogging {
  implicit val connection: Connection = DatabaseConnection.connection(config)
  implicit val session: DBSession = DB.readOnlySession()

  def fetchUsers: List[User] = {
    logger.info("Fetching details of users from users table.")
    SQL("SELECT * FROM users")
      .map(result => User(result.string("name"), result.string("username"),
        result.string("email")))
      .list.apply
  }
}
