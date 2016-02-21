package walfie.tweets.shared.util

import upickle.default._
import upickle.{AttributeTagged, Js}

object SnakePickle extends AttributeTagged {
  protected def camelToSnake(s: String) = {
    s.split("(?=[A-Z])", -1).map(_.toLowerCase).mkString("_")
  }

  override def CaseR[T: this.Reader, V](
    f: T => V,
    names: Array[String],
    defaults: Array[Js.Value]
  ) = super.CaseR[T, V](f, names.map(camelToSnake), defaults)

  override def CaseW[T: this.Writer, V](
    f: V => Option[T],
    names: Array[String],
    defaults: Array[Js.Value]
  ) = super.CaseW[T, V](f, names.map(camelToSnake), defaults)
}

