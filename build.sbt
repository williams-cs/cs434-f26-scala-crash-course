name := "scala-crash-course"

scalaVersion := "3.3.6"

libraryDependencies += "org.scalameta" %% "munit" % "1.1.1" % Test

Compile / run / mainClass := Some("tour.Main")
