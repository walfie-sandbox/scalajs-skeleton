package walfie.example

import walfie.example.shared._

object Example {
  def main(args: Array[String]): Unit = {
    val myString: String = ExampleUtils.exampleMethod("jvm")
    println(myString)
  }
}

