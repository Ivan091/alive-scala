libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % "test"
libraryDependencies += "org.scalatestplus" %% "scalacheck-1-17" % "3.2.15.0" % "test"

Global / cancelable := true
Global / fork := true
Test / logBuffered := false

scalacOptions := List("-encoding", "utf8", "-Xfatal-warnings", "-deprecation", "-unchecked")

lazy val root = (project in file("."))
  .settings(
    name := "codewars",
    version := "1.0.0",
    scalaVersion := "3.2.1"
  )
