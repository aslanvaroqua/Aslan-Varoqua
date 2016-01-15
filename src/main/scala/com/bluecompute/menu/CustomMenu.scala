package com.bluecompute.menu
import scala.collection.JavaConversions._


object CustomMenu {

  def getMenu:TopMenu = {

    val l = List(Menu("Home","/home"), Menu("About","/about"), Menu("Contact","/contact"))
    val m = new TopMenu(l)
    println(m)
    m
  }

  def main(args: Array[String]) {
    getMenu
  }

}
