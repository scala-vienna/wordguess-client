name := "dojo-quickstart"

version := "0.1.0"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-cluster"    % "2.2.3",
  "com.typesafe.akka" %% "akka-slf4j"      % "2.2.3",
  "com.typesafe.akka" %% "akka-testkit"    % "2.2.3",
  "ch.qos.logback"    %  "logback-classic" % "1.0.13",
  "junit"             %  "junit"           % "4.11"   % "test",
  "org.scalatest"     %% "scalatest"       % "2.0"    % "test"
)

// SBT-Eclipse settings
EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE17)

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource

EclipseKeys.eclipseOutput := Some(".target")

EclipseKeys.withSource := true
