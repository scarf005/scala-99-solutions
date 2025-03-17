package p04

import utils.S99Suite
import scala.annotation.tailrec

def lengthBuiltin[A](xs: List[A]): Int = xs.size

def lengthRecursive[A](xs: List[A]): Int =
  @tailrec def go(xs: List[A], n: Int = 0): Int = xs match
    case Nil       => n
    case _ :: tail => go(tail, n + 1)

  go(xs)

def lengthFunctional[A](xs: List[A]): Int =
  xs.foldLeft(0) { (c, _) => c + 1 }

class Find_the_number_of_elements_of_a_list extends S99Suite:
  testMany(
    input = List(1, 1, 2, 3, 5, 8),
    expected = 6,
    cases = List(
      "builtin" -> lengthBuiltin,
      "recursive" -> lengthRecursive,
      "functional" -> lengthFunctional,
    ),
  )
