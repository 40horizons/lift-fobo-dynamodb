name := "lift-fobo-dynamodb"

version := "0.1-SNAPSHOT"

scalaVersion := "2.9.1"

seq(webSettings :_*)

// If using JRebel
//scanDirectories in Compile := Nil

logLevel := Level.Info

EclipseKeys.withSource := true

transitiveClassifiers := Seq("sources")

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

resolvers += "Sonatype Repository" at "https://oss.sonatype.org/content/repositories/releases/"

resolvers += "antelink.com" at "http://maven.antelink.com/content/repositories/central/"

resolvers += "uk.maven.org" at "http://uk.maven.org/maven2/"

resolvers += "ibiblio.org" at "http://mirrors.ibiblio.org/pub/mirrors/maven2/"

//"net.liftmodules" %% "fobo" % (liftVersion+"-0.4.1-SNAPSHOT") withSources()

libraryDependencies ++= {
  val liftVersion = "2.4" // Put the current/latest lift version here
  Seq(
    "net.liftweb" %% "lift-webkit" % liftVersion % "compile->default" withSources(),
    "net.liftweb" %% "lift-mapper" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-squeryl-record" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-wizard" % liftVersion % "compile->default",
    "net.liftweb" %% "lift-testkit" % liftVersion % "compile->default",
    "net.liftmodules" %% "fobo" % (liftVersion+"-0.5.0-SNAPSHOT") withSources()
    )
}

// Customize any further dependencies as desired
libraryDependencies ++= Seq(
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.4.v20111024" % "container",
  //"org.mortbay.jetty" % "jetty" % "6.1.22" % "container", // For Jetty 7
  "org.codehaus.jackson" % "jackson-core-asl" % "1.9.8" % "compile->default",
  "org.codehaus.jackson" % "jackson-mapper-asl" % "1.9.8" % "compile->default",
  "com.amazonaws" % "aws-java-sdk" % "1.3.12" % "compile->default",
  "com.jolbox" % "bonecp" % "0.7.1.RELEASE" % "compile->default",
  "javax.servlet" % "servlet-api" % "2.5" % "provided->default",
  "org.slf4j" % "slf4j-log4j12" % "1.6.1" % "compile->default", // Logging
  "junit" % "junit" % "4.8" % "test->default", // For JUnit 4 testing
  "org.scala-tools.testing" %% "specs" % "1.6.9" % "test",
  "org.specs2" %% "specs2" % "1.6.1" % "test"
)

//seq(lessSettings:_*)

//(sourceDirectory in (Compile, LessKeys.less)) <<= (sourceDirectory in Compile)(_ / "resources" / "toserve" / "less" / "bootstrap" / "2.0.0")

//(resourceManaged in (Compile, LessKeys.less)) <<= (crossTarget in Compile)(_ / "classes" / "toserve" / "fobo" / "bootstrap" / "2.0.0" / "css" )

//(LessKeys.filter in (Compile, LessKeys.less)) := "bootstrap.less"
