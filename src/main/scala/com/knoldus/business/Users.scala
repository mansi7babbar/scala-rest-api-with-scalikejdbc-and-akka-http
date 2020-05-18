package com.knoldus.business

import com.knoldus.User
import net.liftweb.json.{DefaultFormats, parse}
import org.apache.commons.io.IOUtils
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClientBuilder
import com.typesafe.scalalogging._

class Users extends LazyLogging {
  def listOfUsers: List[User] = {
    logger.info("Fetching details of users from API and modelling the JSON data into case class object.")
    implicit val formats: DefaultFormats.type = DefaultFormats
    val request = new HttpGet("https://jsonplaceholder.typicode.com/users")
    val client = HttpClientBuilder.create().build()
    val response = client.execute(request)
    val users = IOUtils.toString(response.getEntity.getContent)
    val parsedUsers = parse(users)
    parsedUsers.children map {
      user =>
        user.extract[User]
    }
  }
}
