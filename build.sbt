name := "bigbang"
organization := "design.hamu"
version := "0.1.0-SNAPSHOT"

lazy val common = Seq(
  scalacOptions += "-Ypartial-unification"
)

lazy val core = project
  .in(file("core"))
  .settings(
    name := "core",
    common,
    libraryDependencies ++= Seq(
      Dependencies.CatsEffect.catsEffect
    )
  )

lazy val windows = project
  .in(file("windows"))
  .dependsOn(core)
  .settings(
    name := "windows",
    libraryDependencies ++= Seq(
      Dependencies.LWJGL.lwjgl
    )
  )