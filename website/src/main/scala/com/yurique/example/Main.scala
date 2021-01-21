package com.yurique.example

import io.frontroute._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("stylesheets/main.css", JSImport.Namespace)
object Css extends js.Object

object Main {

  val css: Css.type = Css

  def main(args: Array[String]): Unit = {
    LinkHandler.install()
    Routes.start()
  }

}
