package com.hbc.opt

object OptionTest {

  def main(args: Array[String]): Unit = {

    val opt = generateOpt(0)

    f("")

    val v = opt.fold("tresh")(x=>"asfsdf")
    println(v)

  }

  def generateOpt(i: Int): Option[String] ={
    i match {
      case 0 => Some("Text")
      case _ => None
    }
  }


  def f(ifEmpty: => String): Unit=> String ={
    println(ifEmpty)
    Unit => "sd"
  }

}
