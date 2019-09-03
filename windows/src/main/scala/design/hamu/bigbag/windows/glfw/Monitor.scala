package design.hamu.bigbag.windows.glfw

import cats.effect.IO
import org.lwjgl.glfw.{GLFW => LWJGLGLFW}

case class Monitor(id: Long) {
  def resolution: IO[(Int, Int)] = IO {
    val vidmode = LWJGLGLFW.glfwGetVideoMode(id)
    (vidmode.width, vidmode.height)
  }
}

object Monitor {
  def primary: IO[Monitor] = IO {
    Monitor(LWJGLGLFW.glfwGetPrimaryMonitor)
  }
}
