import sbt._
import sbt.Keys._
import org.scalajs.sbtplugin._
import ScalaJSPlugin.autoImport._

object Settings {
  lazy val shared = Seq(
    scalacOptions ++= Seq("-feature","-deprecation", "-unchecked", "-Xlint"),
    testFrameworks += new TestFramework("utest.runner.Framework"),
    Dependencies.shared
  )

  lazy val jvm = Seq(
    Dependencies.jvm
  )

  lazy val js = Seq(
    scalaJSStage in Global := FastOptStage,
    scalaJSUseRhino in Global := false,
    skip in packageJSDependencies := false,
    persistLauncher in Compile := true,
    persistLauncher in Test := false,
    Dependencies.js,
    Dependencies.jsNative
  )
}

