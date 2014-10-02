crossScalaVersions := Seq("2.10.4", "2.11.2")

lazy val root =
  project.in(file("."))
    .aggregate(runtime, compilerPlugin, integration)

lazy val runtime = project in file("scalapb-runtime")

lazy val compilerPlugin = project in file("compiler-plugin")

lazy val integration = project.in(file("integration"))
  .dependsOn(runtime, compilerPlugin)

lazy val sbtPlugin = project.in(file("sbt-plugin"))
  .dependsOn(compilerPlugin)
