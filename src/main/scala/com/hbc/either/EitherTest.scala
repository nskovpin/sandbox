package com.hbc.either

object EitherTest {

  def main(args: Array[String]): Unit = {

    val v = generateEither(2)
    v match {
      case Left(exception) =>
        println("Oh, we got error")
      case Right(testClass) =>
        println(testClass)
    }
  }


  def generateEither(i: Int): Either[NullPointerException, TestClass] = {
    i match {
      case 1 =>
        Left(new NullPointerException)
      case 2 =>
        Right(TestClass("kol", 24))
    }
  }


}

case class TestClass(name: String, age: Int)
