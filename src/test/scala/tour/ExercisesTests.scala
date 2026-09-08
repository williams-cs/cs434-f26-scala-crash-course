package tour

import Exercises.*

/**
 * One test per exercise, in the same order as Exercises.scala.  Only
 * the first passes with the starter; work through the rest top to
 * bottom.  Run with `sbt test`, or keep `~test` running inside sbt.
 */
class ExercisesTests extends munit.FunSuite {

  test("double (already done for you)") {
    assertEquals(double(21), 42)
  }

  test("circleArea") {
    assertEqualsDouble(circleArea(1.0), math.Pi, 0.0001)
    assertEqualsDouble(circleArea(2.0), 4 * math.Pi, 0.0001)
  }

  test("maxOf3") {
    assertEquals(maxOf3(1, 2, 3), 3)
    assertEquals(maxOf3(9, 2, 3), 9)
    assertEquals(maxOf3(1, 7, 3), 7)
    assertEquals(maxOf3(5, 5, 5), 5)
  }

  test("factorial") {
    assertEquals(factorial(0), 1)
    assertEquals(factorial(1), 1)
    assertEquals(factorial(5), 120)
    assertEquals(factorial(10), 3628800)
  }

  test("applyTwice") {
    assertEquals(applyTwice(x => x + 3, 10), 16)
    assertEquals(applyTwice(double, 5), 20)
  }

  test("squaresOfEvens") {
    assertEquals(squaresOfEvens(List(1, 2, 3, 4)), List(4, 16))
    assertEquals(squaresOfEvens(List(1, 3, 5)), List())
    assertEquals(squaresOfEvens(List()), List())
  }

  test("sum") {
    assertEquals(sum(List()), 0)
    assertEquals(sum(List(42)), 42)
    assertEquals(sum(List(1, 2, 3, 4, 5)), 15)
  }

  test("describe") {
    assertEquals(describe(None), "nothing")
    assertEquals(describe(Some(7)), "the number 7")
    assertEquals(describe(Some(-1)), "the number -1")
  }

  test("outEdges") {
    val edges = Map(0 -> List(1, 2), 1 -> List(0))
    assertEquals(outEdges(edges, 0), List(1, 2))
    assertEquals(outEdges(edges, 1), List(0))
    assertEquals(outEdges(edges, 2), Nil)              // 2 has no out-edges
  }

  test("successors") {
    val edges = Map(0 -> List(1, 2), 1 -> List(0))
    assertEquals(successors(edges, Set(0)), Set(1, 2))
    assertEquals(successors(edges, Set(0, 1)), Set(0, 1, 2))
    assertEquals(successors(edges, Set(2)), Set())     // 2 has no out-edges
    assertEquals(successors(edges, Set()), Set())
  }

  test("Stack") {
    val s = Stack()
    assertEquals(s.size, 0)
    assertEquals(s.pop(), None)                        // empty: nothing to pop
    s.push(2); s.push(3); s.add()                      // 2 + 3
    assertEquals(s.size, 1)
    s.push(4); s.sub()                                 // (2 + 3) - 4
    assertEquals(s.pop(), Some(1))
    assertEquals(s.pop(), None)
    s.push(5); s.push(3); s.sub()                      // order matters: 5 - 3, not 3 - 5
    assertEquals(s.pop(), Some(2))
    s.push(7); s.add()                                 // too few items: unchanged
    assertEquals(s.size, 1)
    assertEquals(s.pop(), Some(7))
  }

  test("eval") {
    assertEquals(eval(Num(5)), 5)
    assertEquals(eval(Add(Num(1), Num(2))), 3)
    assertEquals(eval(Add(Num(1), Mul(Num(2), Num(3)))), 7)
    assertEquals(eval(Mul(Add(Num(1), Num(2)), Num(3))), 9)
  }

  test("show") {
    assertEquals(show(Num(5)), "5")
    assertEquals(show(Add(Num(1), Num(2))), "(1 + 2)")
    assertEquals(show(Add(Num(1), Mul(Num(2), Num(3)))), "(1 + (2 * 3))")
  }
}
