package design.hamu.bigbag.windows.glfw

import cats.effect.IO
import org.lwjgl.glfw.{GLFWErrorCallback, GLFW => LWJGLGLFW}
import org.lwjgl.system.MemoryUtil.NULL

object GLFW {
  def setPrintStream(stream: java.io.PrintStream): IO[Unit] = IO {
    GLFWErrorCallback.createPrint(stream).set
  }
  def init(stream: java.io.PrintStream): IO[Unit] =
    for {
      _ <- setPrintStream(stream)
    } yield if (!LWJGLGLFW.glfwInit()) {
      throw new IllegalStateException("Unable to initialize GLFW")
    }
  def createWindow(width: Int, height: Int, title: String): IO[Window] = IO {
    LWJGLGLFW.glfwCreateWindow(width, height, title, NULL, NULL) match {
      case NULL => throw new RuntimeException("Failed to create the GLFW window")
      case id => Window(id)
    }
  }
}
