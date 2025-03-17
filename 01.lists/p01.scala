package p01

import munit.FunSuite
import scala.annotation.tailrec

def lastBuiltin[A](xs: List[A]): A = xs.last

@tailrec def lastRecursive[A](xs: List[A]): A =
  xs match
    case h :: Nil  => h
    case _ :: tail => lastRecursive(tail)
    case _         => throw new NoSuchElementException

class P01Suite extends FunSuite:
  test("Find the last element of a list."):
    List(lastBuiltin, lastRecursive).foreach { last =>
      assertEquals(last(List(1, 1, 2, 3, 5, 8)), 8)
    }
