package p03

import munit.FunSuite
import scala.annotation.tailrec

def nthBuiltin[A](n: Int, xs: List[A]): A = xs(n)

@tailrec def nthRecursive[A](n: Int, xs: List[A]): A = (n, xs) match
  case (0, h :: _)    => h
  case (n, _ :: tail) => nthRecursive(n - 1, tail)
  case (_, Nil)       => throw new NoSuchElementException

class P03Suite extends FunSuite:
  test("Find the Kth element of a list."):
    List(nthBuiltin, nthRecursive).foreach { nth =>
      assertEquals(nth(2, List(1, 1, 2, 3, 5, 8)), 2)
    }
