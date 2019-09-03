package design.hamu.bigbag.windows.glfw

import cats.effect.IO
import org.lwjgl.system.MemoryStack
import org.lwjgl.glfw.{GLFW => LWJGLGLFW}

case class Window(id: Long) {
  def size: IO[(Int, Int)] = IO {
    val stack = MemoryStack.stackPush
    val width = stack.mallocInt(1)
    val height = stack.mallocInt(1)
    LWJGLGLFW.glfwGetWindowSize(id, width, height)
    (width.get(0), height.get(0))
  }
  def setPos(x: Int, y: Int): IO[Unit] = IO {
    LWJGLGLFW.glfwSetWindowPos(id, x, y)
  }
}
