package P04

import munit.FunSuite
import scala.annotation.tailrec

def lengthBuiltin[A](xs: List[A]): Int = xs.size

def lengthRecursive[A](xs: List[A]): Int =
  @tailrec def go(xs: List[A], n: Int = 0): Int = xs match
    case Nil       => n
    case _ :: tail => go(tail, n + 1)

  go(xs)

def lengthFunctional[A](xs: List[A]): Int =
  xs.foldLeft(0) { (c, _) => c + 1 }

class P04Suite extends FunSuite:
  test("Find the number of elements of a list."):
    List(lengthBuiltin, lengthRecursive, lengthFunctional).foreach { length =>
      assertEquals(length(List(1, 1, 2, 3, 5, 8)), 6)
    }
