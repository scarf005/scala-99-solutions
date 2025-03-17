package p05

import utils.S99Suite
import scala.annotation.tailrec

def reverseBuiltin[A](xs: List[A]): List[A] = xs.reverse

def reverseRecursive[A](xs: List[A]): List[A] =
  @tailrec def go(as: List[A], bs: List[A]): List[A] = as match
    case Nil          => bs
    case head :: tail => go(tail, head :: bs)

  go(xs, Nil)

def reverseFunctional[A](xs: List[A]): List[A] =
  xs.foldLeft(Nil) { (a, b) => b :: a }

class Reverse_a_list extends S99Suite:
  testMany(
    input = List(1, 1, 2, 3, 5, 8),
    expected = List(8, 5, 3, 2, 1, 1),
    cases = List(
      "builtin" -> reverseBuiltin,
      "recursive" -> reverseRecursive,
      "functional" -> reverseFunctional,
    ),
  )
