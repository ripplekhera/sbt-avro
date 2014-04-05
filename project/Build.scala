import sbt._
import Keys._

object build extends Build {
    val sbtAvro = Project(
        id = "sbt-avro",
        base = file("."),
        settings = Defaults.defaultSettings ++ Seq[Project.Setting[_]](
            organization := "com.audaxhealth",
            version := "0.3.4",
            sbtPlugin := true,
            libraryDependencies ++= Seq(
                    "org.apache.avro" % "avro" % "1.7.6",
                    "org.apache.avro" % "avro-compiler" % "1.7.6"
            ),
            scalaVersion := "2.9.2",
            scalacOptions in Compile ++= Seq("-deprecation"),
            crossScalaVersions := Seq("2.10.3"),
            description := "Sbt plugin for compiling Avro sources",

            publishTo := Some(Resolver.url("sbt-plugin-releases", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns)),

            publishMavenStyle := false
        )
    )
}
