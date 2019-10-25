name := "drools-skeleton-scala"
version := "1"
scalaVersion := "2.13.1"

lazy val versions = new {
  val drools = "7.27.0.Final"
  val logback = "1.2.3"
  val scalatest = "3.0.8"
}

libraryDependencies ++= Seq(
  "drools-compiler",
  "drools-core",
  "drools-templates",
  "drools-decisiontables",
).map("org.drools" % _ % versions.drools)

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % versions.logback,
  "org.scalatest" %% "scalatest" % versions.scalatest % "test"
)
