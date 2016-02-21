package walfie.tweets.js

import org.scalajs.dom.document
import org.scalajs.dom.raw.Element
import scala.scalajs.js.{Dynamic, JSApp}
import walfie.tweets.shared.models._
import walfie.tweets.shared.util.SnakePickle
import upickle.{default => UPickle}
import upickle.json

object Example extends JSApp {
  def main(): Unit = {
    val div: Element = document.createElement("div")
    document.body.appendChild(div)

    try {
      val x = SnakePickle.readJs[Vector[Tweet]](
        json.readJs(
          Dynamic.global.Grailbird.data.tweets_2015_12
        )
      )
      println(x.head)
    } catch {
      case e: upickle.Invalid.Data => println(e.msg)
    }
  }
}

