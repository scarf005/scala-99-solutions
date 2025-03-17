package p02

import utils.S99Suite
import scala.annotation.tailrec

def penultimateBuiltin[A](xs: List[A]): A = xs.init.last

@tailrec def penultimateRecursive[A](xs: List[A]): A =
  xs match
    case h :: _ :: Nil => h
    case _ :: tail     => penultimateRecursive(tail)
    case _             => throw new NoSuchElementException

class Find_the_last_but_one_element_of_a_list extends S99Suite:
  testMany(
    input = List(1, 1, 2, 3, 5, 8),
    expected = 5,
    cases = List(
      "builtin" -> penultimateBuiltin,
      "recursive" -> penultimateRecursive,
    ),
  )
