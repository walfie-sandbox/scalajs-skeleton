package walfie.tweets.js

import org.scalajs.dom.document
import org.scalajs.dom.raw.Element
import scala.scalajs.js
import upickle.json
import upickle.{default => UPickle}
import walfie.tweets.js.models._

object Example extends js.JSApp {
  def main(): Unit = {
    val div: Element = document.createElement("div")
    document.body.appendChild(div)

    val data = js.Dynamic.global.Grailbird.data.asInstanceOf[js.Dictionary[js.Array[Tweet]]]

    val dataForMonth = data.getOrElse("tweets_2015_12", js.Array())
    println(dataForMonth(0).inReplyToStatusId)
  }
}

