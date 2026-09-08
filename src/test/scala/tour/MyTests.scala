package tour

import Exercises.*

/**
 * Your own tests.  ExercisesTests.scala belongs to the course -- the
 * autograder swaps in its own copy -- but this file is yours, and the
 * autograder runs it as you wrote it, alongside the official suite.
 *
 * Part 5 of the handout asks for at least two tests of your Stack
 * that the official suite does not already make.  A test is a claim
 * about behavior: set something up, then assert what must be true
 * afterwards.  The example below is complete; add yours after it,
 * and keep
 *
 *   sbt> ~test
 *
 * running so every save reruns both suites.
 */
class MyTests extends munit.FunSuite {

  test("double doubles (an example to copy)") {
    assertEquals(double(0), 0)
    assertEquals(double(-4), -8)
  }

  // TODO: your Stack tests go here.  Some claims worth checking:
  // pushes and pops interleaved come back in the right order; sub on
  // an empty or a one-item stack changes nothing; two adds in a row,
  // or a longer expression such as (1 + 2) - (3 + 4), leave exactly
  // one item, and the right one.
}
