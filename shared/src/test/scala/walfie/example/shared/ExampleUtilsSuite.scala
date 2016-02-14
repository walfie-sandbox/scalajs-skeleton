package walfie.example.shared

import utest._
import utest.ExecutionContext.RunNow

object ExampleUtilsSuite extends TestSuite {
  def tests = TestSuite {
    "ExampleUtils" - {
      assert(ExampleUtils.exampleMethod("world") == "Hello world!")
    }
  }
}

