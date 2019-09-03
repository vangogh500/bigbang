package design.hamu.bigbag.windows

import design.hamu.bigbag.windows.glfw.GLFW

object Main extends App {
  val game = for {
    _ <- GLFW.init(System.err)
    window <- GLFW.createWindow(500, 500, "Bigbang")
  } yield window
  game.unsafeRunSync
}
