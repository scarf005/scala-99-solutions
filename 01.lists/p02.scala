package p02

import munit.FunSuite
import scala.annotation.tailrec

def penultimateBuiltin[A](xs: List[A]): A = xs.init.last

@tailrec def penultimateRecursive[A](xs: List[A]): A =
  xs match
    case h :: _ :: Nil => h
    case _ :: tail     => penultimateRecursive(tail)
    case _             => throw new NoSuchElementException

class P02Suite extends FunSuite:
  test("Find the last but one element of a list."):
    List(penultimateBuiltin, penultimateRecursive).foreach { penultimate =>
      assertEquals(penultimate(List(1, 1, 2, 3, 5, 8)), 5)
    }
