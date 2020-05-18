package com.knoldus.application

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives
import com.knoldus.User
import com.knoldus.infrastructure.ReadUser
import com.typesafe.config.Config
import net.liftweb.json.Extraction.decompose
import net.liftweb.json.{DefaultFormats, compactRender}
import com.typesafe.scalalogging._

import scala.concurrent.{ExecutionContextExecutor, Future}

class DisplayUsersOnAPI(readUser: ReadUser, config: Config) extends Directives with LazyLogging {
  implicit val system: ActorSystem = ActorSystem()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher
  implicit val formats: DefaultFormats.type = net.liftweb.json.DefaultFormats

  def displayUsers(listOfUsers: List[User]): Future[Http.ServerBinding] = {
    logger.info("Displaying details of users on API.")
    val route = {
      path("users") {
        get {
          complete(HttpEntity(ContentTypes.`application/json`,
            compactRender(decompose(readUser.fetchUsers))))
        }
      }
    }
    Http().bindAndHandle(route, config.getString("interface"), config.getInt("port"))
  }
}
