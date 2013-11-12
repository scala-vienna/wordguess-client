name := "dojo-quickstart"

version := "0.1.0"
 
scalaVersion := "2.10.2"

// SBT-Eclipse settings
EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE17)

EclipseKeys.withSource := true
  
libraryDependencies ++= Seq(
  "junit" % "junit" % "4.11" % "test",
  "org.scalatest" %% "scalatest" % "2.0" % "test->default",
  "com.typesafe.akka" % "akka-remote_2.10" % "2.2.3" // depends on akka-actor
)