import scala.collection.mutable

object Sudoku:

  def isValid(board: Array[Array[Int]]): Boolean =
    board.forall(checkRows) &&
      Range(0, 9).forall { i =>
        checkRows(
          board(0)(i),
          board(1)(i),
          board(2)(i),
          board(3)(i),
          board(4)(i),
          board(5)(i),
          board(6)(i),
          board(7)(i),
          board(8)(i)
        )
      }

  def checkRows(array: Int*): Boolean =
    var v = 0
    val res = array.forall { x =>
      if x == 0 then false
      else if (1 << x & v) == 0 then
        v = (1 << x) | v
        true
      else false
    }
    res && v >>> 1 == 255
