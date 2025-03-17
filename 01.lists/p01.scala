package p01

import utils.S99Suite
import scala.annotation.tailrec

def lastBuiltin[A](xs: List[A]): A = xs.last

@tailrec def lastRecursive[A](xs: List[A]): A =
  xs match
    case h :: Nil  => h
    case _ :: tail => lastRecursive(tail)
    case _         => throw new NoSuchElementException

class Find_the_last_element_of_a_list extends S99Suite:
  testMany(
    input = List(1, 1, 2, 3, 5, 8),
    expected = 8,
    cases = List(
      "builtin" -> lastBuiltin,
      "recursive" -> lastRecursive,
    ),
  )
