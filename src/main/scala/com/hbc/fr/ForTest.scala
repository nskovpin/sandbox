package com.hbc.fr

import scala.util.Try

object ForTest {

  def main(args: Array[String]): Unit = {

    def getTest(int: Int): Option[TestFor] ={
      int match {
        case 1 => Some(TestFor(12))
        case 2 => None
      }
    }

    def getTry: Try[TestFor] ={
      Try{
        TestFor(30)
      }
    }

    val ts = getTest(2)
    val ta = getTry

    val test = for{
      firstValue  <- getTry
      secondValue  <- getTry
      thridValue  <- Try{"LoL"}
      fourthValue  <- Try{"LoL"}
    } yield thridValue



//
//   val result = for {
//      firstValue <- ts
//      kek <- Try{ TestFor(3)}
//      tryValue <- ta
//      secondValue = TestFor(firstValue.sd + 10 + tryValue.sd)
//    } yield Result(secondValue)
//
//   println(result)
  }




  case class TestFor(sd: Int)
  case class Result(tf: TestFor)

}
