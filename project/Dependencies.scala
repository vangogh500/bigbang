import sbt._

object Dependencies {
  object CatsEffect {
    private val version = "1.3.1"
    val catsEffect =  "org.typelevel" %% "cats-effect" % version
  }
  object LWJGL {
    private val version = "3.2.3"
    val core = "org.lwjgl" % "lwjgl" % version
    val glfw = "org.lwjgl" % "lwjgl-glfw" % version
  }
}
