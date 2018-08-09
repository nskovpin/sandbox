package com.hbc.curring

object CurringTest {

  def main(args: Array[String]): Unit = {

    val result = curringFunctionRight(9)("")
    println(result)

    curringFunctionWrong(resultInt(4), "")
    curringFunctionRight(resultInt(4))("")

    val list = List(4,3,1,5,3,9)

    println(list.map(x=> m(x)(5)))
    println(list.map(m(4)))


  }


  def curringFunctionWrong(x: Int, y: String): String = {
    x + y
  }

  def curringFunctionRight(x: Int)(y: String): String = {
    x + y
  }

  def resultInt(x: Int): Int ={
    x + 10
  }

  def m(first: Double)(second: Int): Int ={
    (first * second).toInt

  }

  def m1(first: Double)(second: Int): Int ={
    (first * second).toInt

  }

  def process[A](filter:A=>Boolean)(list:List[A]):List[A] = {
    lazy val recurse = process(filter) _

    list match {
      case head::tail => if (filter(head)) {
        head::recurse(tail)
      } else {
        recurse(tail)
      }

      case Nil => Nil
    }
  }

}
