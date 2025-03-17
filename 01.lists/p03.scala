package p03

import utils.S99Suite
import scala.annotation.tailrec

def nthBuiltin[A](n: Int, xs: List[A]): A = xs(n)

@tailrec def nthRecursive[A](n: Int, xs: List[A]): A = (n, xs) match
  case (0, h :: _)    => h
  case (n, _ :: tail) => nthRecursive(n - 1, tail)
  case (_, Nil)       => throw new NoSuchElementException

class Find_the_nth_element_of_a_list extends S99Suite:
  val n = 2
  val list = List(1, 1, 2, 3, 5, 8)

  testMany(
    input = list,
    expected = 2,
    cases = List(
      "builtin" -> (xs => nthBuiltin(n, xs)),
      "recursive" -> (xs => nthRecursive(n, xs)),
    ),
  )
