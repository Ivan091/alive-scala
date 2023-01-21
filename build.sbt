ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"
libraryDependencies += "org.scalatestplus" %% "scalacheck-1-17" % "3.2.15.0" % "test"

scalacOptions := List("-encoding", "utf8", "-Xfatal-warnings", "-deprecation", "-unchecked")

lazy val root = (project in file("."))
  .settings(
    name := "codewars"
  )
