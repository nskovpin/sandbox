package com.hbc.clazz

trait Go {

  def letsGo(): Int

}

class TestGo1() extends Go{
  override def letsGo(): Int = {
    println("TestGo1")
    1
  }
}

class TestGo2() extends TestGo1 {
  override def letsGo(): Int = {
    println("TestGo2")
    2
  }
}

case object Run{

  def main(args: Array[String]): Unit = {
   val test = new TestGo2()
   val test2 = test.asInstanceOf[TestGo1]

    test2.letsGo()
  }
}