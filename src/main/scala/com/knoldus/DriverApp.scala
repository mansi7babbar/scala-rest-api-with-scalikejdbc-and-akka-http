package com.knoldus

import com.knoldus.application.DisplayUsersOnAPI
import com.knoldus.business.Users
import com.knoldus.infrastructure.{ReadUser, WriteUser}
import com.typesafe.config.{Config, ConfigFactory}

object DriverApp extends App {
  val config: Config = ConfigFactory.load()
  val users = new Users
  val readUser = new ReadUser(config)
  val writeUser = new WriteUser(config)
  val displayUsersOnAPI = new DisplayUsersOnAPI(readUser, config)

  val listOfUsers = users.listOfUsers
  writeUser.insertUsers(listOfUsers)
  displayUsersOnAPI.displayUsers(listOfUsers)
}
