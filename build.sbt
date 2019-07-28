name := "filecrypto4s"

version := "0.1"

organization := "com.snapptrip"
scalaVersion := "2.12.8"
libraryDependencies++=Seq(
  "com.lightbend.akka" %% "akka-stream-alpakka-csv" % "1.1.0" ,
  "commons-codec" % "commons-codec" % "1.6",
  "org.apache.poi" % "poi" % "4.1.0",
  "org.apache.poi" % "poi-ooxml" % "4.1.0",
  "com.github.scopt" %% "scopt" % "4.0.0-RC2",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)