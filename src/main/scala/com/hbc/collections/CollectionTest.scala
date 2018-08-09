package com.hbc.collections

object CollectionTest {

  def main(args: Array[String]): Unit = {
    val listString = List("hello", "my", "friends", "dear")
    val listInt = List(3,10,7)

    val result1 = listString.fold("Empty")((x, y)=> x + y)
    val result2 = listString.foldLeft(5){(x, y)=>  x + y.length}

    println(result1)
    println(result2)

    val list1: List[Integer] = List.tabulate(3)(x => x)
    val list2: List[String] = List.tabulate(4)(x => s">$x<")
    (list1 zip list2)
      .foreach(println(_))

    val list = List("hello", "nikolay", "sergeevich", "sd")

    list match{
      case first::second::tail =>
        println("First:" + first)
        println("Second:"+ second)
    }

  }

}
