import scala.annotation.nowarn
import scala.util.Random

import org.scalacheck.{Gen, Properties}
import org.scalacheck.Arbitrary.*
import org.scalacheck.Gen
import org.scalacheck.Gen.{gen, R}
import org.scalacheck.Gen.const
import org.scalacheck.Prop.{forAll, forAllNoShrink}
import org.scalacheck.Prop.forAllNoShrink
import org.scalacheck.Shrink
import org.scalatest.*
import org.scalatest.flatspec.*
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.Checkers.check
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

object Shrinking:
  @nowarn
  given noShrink[T]: Shrink[T] = Shrink[T](_ => Stream.empty)
