name := "dojo-quickstart"

version := "0.1.0"
 
scalaVersion := "2.10.0"

// SBT-Eclipse settings
EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE17)

EclipseKeys.withSource := true
  
libraryDependencies ++= Seq(
  "junit" % "junit" % "4.10" % "test",
  "org.scalatest" %% "scalatest" % "1.9.1" % "test->default"
)