import play.Project._

name := "project-proposals"

version := "0.1"

libraryDependencies ++= Seq(
  javaJdbc, 
  javaJpa, 
  "org.hibernate" % "hibernate-entitymanager" % "4.2.4.Final"
  )

playJavaSettings
