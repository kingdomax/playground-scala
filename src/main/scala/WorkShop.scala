import scala.util.Try

object WorkShop {

  // pure function
  def pureFunction():Int = 42
  pureFunction() + pureFunction()

  // scala can do sideeffect function
  def notPureFunction():Int = {
    println("do something")
    42
  }

  def func(param: Int) = {
    Try {
      assert(param > 0)
      param
    }
  }

  // lambda function
  val lambdaFunc: Int => Int = x => x +1
  lambdaFunc(1)

  // Pass function inside function
  def anotherFunction(template: Int => Int) = {
    println(2)
    template
  }
  anotherFunction(lambdaFunc)(2)

  // Define nullable type
  val iMaybeNull: Option[String] = Some("42")
  iMaybeNull.getOrElse(0)
  iMaybeNull.foreach { x => println(x) }
  iMaybeNull.map(x => x.toLowerCase)

  // Sum type
  sealed trait Bool
  case object False extends Bool
  case object True extends Bool

  // Normal vs Case class
  class MyClass(a: Int, b: String)
  val a = new MyClass(1, "")
  val b = new MyClass(1, "")
  a != b
  case class MyBetterClass(a: Int, b: String = "")
  val c = MyBetterClass(1, "c")
  val d = MyBetterClass(1, "d")
  c == d

  // Algebra
  sealed abstract class Option[A]
  final case class Some[A](value: A) extends Option[A]
  case object None extends Option[Nothing]

  // Companion object
  object TestClass {
    def apply(): MyClass = {
      new MyClass(5, "test")
    }

    private def staticMethod(): Int = 42
  }
  class TestClass(a: Int, b: String)
  val testClass = TestClass()

  // List operation
  val list1 = List(1, 2, 3)
  val list2 = List(-1, -2, -3)
  list1 ++ list2
  list1.zip(list2)
    .map { case(x1, x2) => x1+x2 }
    .filter(x => x>0)

  // Better way to iterate through 2 lists
  val opt1 = Some(42)
  val opt2 = Some(10)
  opt1.flatMap { elem1 =>
    opt2.map { elem2 =>
      elem1 + elem2
    }
  }
  for {
    elem1 <- opt1
    elem2 <- opt2
  } yield elem1 + elem2

  // trait same as abstraction
  trait inter1 {
    def method1(x: Int): Int = x
  }
  trait inter2 {
    def method2(x: Int): Double = x.toDouble
  }
  trait inter3 {
    self: inter1 with inter2
  }
  case class Implementation() extends inter1 with inter2 {
    method(1)
  }

  // abstract vs trait
  // - a class can extend only one abstract, but many trait
  // - abstract has constructor parameters
  // - abstract can bridge to java

  // lazy
  object MySingleton  {
    val x = ""
    lazy val y = {// lazy will initiate once it get called
      Thread.sleep(100000)
      println("Y is initializing")
      42
    }
  }
  MySingleton.x
  MySingleton.y

  // Pattern matching (like switch case)
  val xx1: Option[String] = Some("abcd")
  val result = xx1 match {
    case Some("abc") => "ABC"
    case Some("abcd")=> "A"
    case _ => "x"
  }
}
