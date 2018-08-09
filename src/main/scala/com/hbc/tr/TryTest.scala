package com.hbc.tr

import scala.util.{Failure, Success, Try}

object TryTest {


  def main(args: Array[String]): Unit = {

    val v = generateTry(2)
    v match {
      case Success(obj) =>
        println(obj)
      case Failure(exception) =>
        throw exception
    }
  }

  private def generateTry(i :Int):Try[Producer]= {
    i match {
      case 1 => Success(Producer("KEK"))
      case 2 => Failure(new RuntimeException)
    }
  }

  private def generateTryOneMore(): Unit ={
    Try{
      throw new RuntimeException("")
    }
  }

}

case class Producer(v: String)
