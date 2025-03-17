package utils

import munit.FunSuite

class S99Suite extends FunSuite:
  def testMany[A, B](
    input: A,
    expected: B,
    cases: List[(String, A => B)],
    title: String = "",
  ) =
    cases.foreach((name, reverse) =>
      test(s"$name $title") { assertEquals(reverse(input), expected) },
    )
