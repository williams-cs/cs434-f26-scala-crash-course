package tour

/**
 * A guided tour of the Scala you need for this course.  Read it top
 * to bottom, run it with `sbt run`, and match each block of output to
 * the code that printed it.  Change things and rerun -- that is the
 * whole point.
 */
object Main:

  def main(args: Array[String]): Unit =

    /*--------------------------------------------------------------
     * 1. Values.  `val` names a value; it cannot be reassigned.
     *    Types come after the name (`x: Int`) and are usually
     *    inferred, but writing them is good manners on public
     *    functions.
     *-------------------------------------------------------------*/
    val course: String = "CS 434"
    val students = 24                       // type Int is inferred
    println(s"Welcome to $course ($students students)")   // s"..." interpolates

    /*--------------------------------------------------------------
     * 2. Everything is an expression.  `if` produces a value, so
     *    there is no ?: operator -- you just use if/else inline.
     *-------------------------------------------------------------*/
    val size = if students > 20 then "large" else "small"
    println(s"This is a $size class")

    /*--------------------------------------------------------------
     * 3. Methods.  `def name(param: Type): ResultType = body`.
     *    The body is a single expression (possibly a block).
     *-------------------------------------------------------------*/
    def square(x: Int): Int = x * x
    println(s"square(7) = ${square(7)}")

    /*--------------------------------------------------------------
     * 4. Lists.  Immutable, and transformed rather than mutated:
     *    map / filter / mkString build new values.  You will use
     *    these constantly instead of writing loops.  A small
     *    function argument is a lambda, `n => n % 2 == 1`; when its
     *    parameter is used just once, `_` can stand in for it.
     *-------------------------------------------------------------*/
    val nums = List(1, 2, 3, 4, 5)
    println(nums.map(square))               // List(1, 4, 9, 16, 25)
    println(nums.filter(n => n % 2 == 1))   // List(1, 3, 5)
    println(nums.filter(_ % 2 == 1))        // List(1, 3, 5)  -- the same, with _
    println(nums.map(_ * 10))               // List(10, 20, 30, 40, 50)
    println(nums.mkString("[", ", ", "]"))  // [1, 2, 3, 4, 5]

    /*--------------------------------------------------------------
     * 5. Sets and Maps.  Also immutable: `+` and `++` return new
     *    collections.  (Your HW 1 NFA simulator is three lines of
     *    Set operations.)
     *-------------------------------------------------------------*/
    val odds = Set(1, 3, 5)
    println(odds + 7)                       // Set(1, 3, 5, 7)
    val romans = Map(1 -> "I", 2 -> "II", 3 -> "III")
    println(romans(2))                      // II
    println(romans.getOrElse(9, "?"))       // ?  (no exception)

    /*--------------------------------------------------------------
     * 6. Option.  A value that may be absent is Some(x) or None --
     *    never null.  Pattern match to take it apart, or use
     *    getOrElse when the value or a default is all you need.
     *-------------------------------------------------------------*/
    val found: Option[String] = romans.get(3)     // Some("III")
    val missing: Option[String] = romans.get(9)   // None
    def render(o: Option[String]): String = o match
      case Some(text) => s"found $text"
      case None       => "not found"
    println(render(found))
    println(render(missing))
    println(found.getOrElse("?"))                 // III
    println(missing.getOrElse("?"))               // ?  (romans.getOrElse above, in two steps)

    /*--------------------------------------------------------------
     * 7. Classes.  A class bundles state with the methods that use
     *    it.  Constructor parameters go right after the class name,
     *    and `val` makes one a public field.  Inside, `private var`
     *    is hidden, mutable state.  No `new` is needed to make one.
     *    (Your PA 3 code generator hands out labels exactly like this.)
     *-------------------------------------------------------------*/
    class Labels(val prefix: String):
      private var next = 0
      def fresh(): String = 
        val label = s"$prefix$next"
        next += 1
        label
    val labels = Labels("L")
    println(labels.fresh())                     // L0
    println(labels.fresh())                     // L1
    println(labels.prefix)                      // L

    /*--------------------------------------------------------------
     * 8. Case classes and pattern matching.  A case class is a
     *    class with extras: its fields are public, it prints itself,
     *    and `match` takes one apart by shape.  A small hierarchy
     *    of case classes is how every compiler in this course
     *    represents programs -- see Exercises.scala for Expr, and
     *    write eval and show there.
     *-------------------------------------------------------------*/
    import Exercises.*
    val tree = Add(Num(1), Mul(Num(2), Num(3)))   // 1 + 2 * 3, as a tree
    println(s"our first AST: $tree")

    /*--------------------------------------------------------------
     * 9. Recursion over lists.  The classic shape: match Nil or
     *    head :: tail.  You will write sum this way in the
     *    exercises.
     *-------------------------------------------------------------*/
    def count(xs: List[Int]): Int = xs match
      case Nil       => 0
      case _ :: rest => 1 + count(rest)
    println(s"count(nums) = ${count(nums)}")

    println()
    println("Tour complete.  Now run `sbt test` and open Exercises.scala.")
