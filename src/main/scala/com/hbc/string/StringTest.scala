package com.hbc.string

object StringTest {

  def main(args: Array[String]): Unit = {

    val testVal = 6
    val actualVal = 9

    val res =
      s"""$testVal
         |    was different to $actualVal
         |difference ${actualVal - testVal}""".stripMargin
    println(res)

    val res1 =
      s"""$testVal
             was different to $actualVal
         difference ${actualVal - testVal}"""
    println(res1)

  }

}
