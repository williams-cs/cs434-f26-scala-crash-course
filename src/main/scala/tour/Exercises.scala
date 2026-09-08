package tour

/**
 * The lab exercises.  Each function below is a stub: `???` compiles
 * but throws when called, so the starter builds cleanly and the tests
 * fail until you fill the stubs in.  Work top to bottom -- the tests
 * in ExercisesTests.scala are in the same order -- and keep
 *
 *   sbt> ~test
 *
 * running so every save reruns the tests.
 */
object Exercises:

  /** A completed example, so the first test is green already. */
  def double(x: Int): Int = 2 * x

  /*----------------------- functions and if -------------------------*/

  /** The area of a circle: pi r^2.  The value of pi is the constant
    * math.Pi -- no import needed, just write math.Pi. */
  def circleArea(radius: Double): Double =
    ???

  /** The largest of three numbers.  Remember: `if` is an expression. */
  def maxOf3(a: Int, b: Int, c: Int): Int =
    ???

  /*----------------------------- recursion --------------------------*/

  /** n! = 1 * 2 * ... * n, with 0! = 1.  Write it recursively. */
  def factorial(n: Int): Int =
    ???

  /*------------------------ first-class functions --------------------*/

  /** Apply f to x, then apply f to the result: f(f(x)). */
  def applyTwice(f: Int => Int, x: Int): Int =
    ???

  /*------------------------------ lists ------------------------------*/

  /** The squares of the even numbers in xs, in order.
    * squaresOfEvens(List(1,2,3,4)) == List(4, 16).
    * Use filter and map -- no recursion needed. */
  def squaresOfEvens(xs: List[Int]): List[Int] =
    ???

  /** The sum of xs.  The standard library has .sum -- do NOT use it.
    * Pattern match on Nil / x :: rest, like count in Main.scala. */
  def sum(xs: List[Int]): Int =
    ???

  /*------------------------------ Option -----------------------------*/

  /** "nothing" for None, and "the number 7" (etc.) for Some(7). */
  def describe(o: Option[Int]): String =
    ???

  /*--------------------------- Sets and Maps -------------------------*/

  /** The out-edges of one state, looked up in the edges map.  A state
    * with no entry has no out-edges, so the answer is Nil (the empty
    * list).  Look up with a default, like romans.getOrElse in the tour.
    *
    *   outEdges(Map(0 -> List(1, 2), 1 -> List(0)), 0) == List(1, 2)
    *   outEdges(Map(0 -> List(1, 2), 1 -> List(0)), 7) == Nil */
  def outEdges(edges: Map[Int, List[Int]], state: Int): List[Int] =
    ???

  /** Every state reachable in ONE step from any state in `from`,
    * following the edges map: the union of outEdges over `from`.
    *
    *   successors(Map(0 -> List(1, 2), 1 -> List(0)), Set(0, 1))
    *     == Set(0, 1, 2)
    *
    * Hint: map vs. flatMap.  Mapping outEdges over `from` would give a
    * Set of Lists, one list per state; flatMap splices those lists
    * together into the single flat Set you want.
    * (This is the heart of the NFA simulator you write in HW 1.) */
  def successors(edges: Map[Int, List[Int]], from: Set[Int]): Set[Int] =
    ???

  /*------------------------------ classes ----------------------------*/

  /** A stack of Ints that does arithmetic on its top two items: a tiny
    * stack machine.  (The JVM running this very program evaluates
    * arithmetic on exactly such a stack.)  It starts empty.
    *
    *   push(x)   x becomes the top
    *   pop()     removes and returns the top; None if the stack is empty
    *   add()     pops b (the top), then a, and pushes a + b
    *   sub()     pops b (the top), then a, and pushes a - b:
    *             push(5); push(3); sub() leaves 2 on top
    *   size      the number of items
    *
    * add and sub leave the stack unchanged when it holds fewer than
    * two items.  Keep the items in the private `items`, a List whose
    * head is the top.  Lists are immutable, so each method that
    * changes the stack replaces `items` with a new list; for add and
    * sub, match items against the shape b :: a :: rest. */
  class Stack:
    private var items: List[Int] = Nil
    def push(x: Int): Unit =
      ???
    def pop(): Option[Int] =
      ???
    def add(): Unit =
      ???
    def sub(): Unit =
      ???
    def size: Int =
      ???

  /*------------------- case classes: your first AST ------------------*/

  /** Arithmetic expressions as trees: 1 + 2 * 3 is
    * Add(Num(1), Mul(Num(2), Num(3))).  Every compiler in this course
    * represents programs this way. */
  sealed trait Expr
  case class Num(value: Int) extends Expr
  case class Add(left: Expr, right: Expr) extends Expr
  case class Mul(left: Expr, right: Expr) extends Expr

  /** The value of e:  eval(Add(Num(1), Mul(Num(2), Num(3)))) == 7. */
  def eval(e: Expr): Int =
    ???

  /** e as a fully parenthesized string:
    * show(Add(Num(1), Mul(Num(2), Num(3)))) == "(1 + (2 * 3))". */
  def show(e: Expr): String =
    ???
