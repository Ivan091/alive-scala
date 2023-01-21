import scala.util.Random
import org.scalacheck.{Gen, Properties}
import org.scalacheck.Arbitrary.*
import org.scalacheck.Gen
import org.scalacheck.Gen.{gen, R}
import org.scalacheck.Gen.const
import org.scalatest.*
import org.scalatest.flatspec.*
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks

class SudokuSpec extends AnyFlatSpec with ScalaCheckPropertyChecks with Matchers:
  "isValid" should "pass basic tests" ignore {
    val testCases = List[(Array[Array[Int]], Boolean)]( // board, expected
      (
        Array(
          Array(5, 3, 4, 6, 7, 8, 9, 1, 2),
          Array(6, 7, 2, 1, 9, 5, 3, 4, 8),
          Array(1, 9, 8, 3, 4, 2, 5, 6, 7),
          Array(8, 5, 9, 7, 6, 1, 4, 2, 3),
          Array(4, 2, 6, 8, 5, 3, 7, 9, 1),
          Array(7, 1, 3, 9, 2, 4, 8, 5, 6),
          Array(9, 6, 1, 5, 3, 7, 2, 8, 4),
          Array(2, 8, 7, 4, 1, 9, 6, 3, 5),
          Array(3, 4, 5, 2, 8, 6, 1, 7, 9)
        ),
        true
      ),
      (
        Array(
          Array(5, 3, 4, 6, 7, 8, 9, 1, 2),
          Array(6, 7, 2, 1, 9, 0, 3, 4, 9),
          Array(1, 0, 0, 3, 4, 2, 5, 6, 0),
          Array(8, 5, 9, 7, 6, 1, 0, 2, 0),
          Array(4, 2, 6, 8, 5, 3, 7, 9, 1),
          Array(7, 1, 3, 9, 2, 4, 8, 5, 6),
          Array(9, 0, 1, 5, 3, 7, 2, 1, 4),
          Array(2, 8, 7, 4, 1, 9, 6, 3, 5),
          Array(3, 0, 0, 4, 8, 1, 1, 7, 9)
        ),
        false
      )
    )

    testCases.foreach {
      case (board, expected) =>
        assertResult(expected)(Sudoku.isValid(board))
    }
  }

  val rows =
    val gens = Gen.chooseNum(1, 2, 3, 4, 5, 6)

    Gen.nonEmptyListOf(gens)

  "t" should "t" in {
    forAll(rows) { n =>
      println(n)
      Sudoku.checkRows(n.toArray*) shouldBe true
    }
  }
