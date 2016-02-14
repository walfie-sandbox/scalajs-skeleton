package walfie.example

import org.scalajs.dom.document
import org.scalajs.dom.raw.Element
import scala.scalajs.js.JSApp
import walfie.example.shared._

object Example extends JSApp {
  def main(): Unit = {
    val div: Element = document.createElement("div")
    div.innerHTML = ExampleUtils.exampleMethod("js") // from shared

    document.body.appendChild(div)
  }
}

