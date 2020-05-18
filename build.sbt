name := "scala-rest-api-with-scalikejdbc-and-akka-http"

version := "0.1"

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(
  "org.scalikejdbc" %% "scalikejdbc" % "3.4.1",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe" % "config" % "1.3.0",
  "net.liftweb" %% "lift-json" % "3.4.0",
  "org.apache.httpcomponents" % "httpclient" % "4.5.11",
  "org.apache.commons" % "commons-io" % "1.3.2",
  "org.postgresql" % "postgresql" % "42.2.11",
  "com.typesafe.akka" %% "akka-http" % "10.1.11",
  "com.typesafe.akka" %% "akka-actor" % "2.5.13",
  "com.typesafe.akka" %% "akka-stream" % "2.6.1"
)
