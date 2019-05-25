package example

object Main extends App {

  val ages = Seq(42, 61, 29, 64)
  println(s"The oldest person is ${ages.max}")

  val matchTest = (x: Int) => x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }
  println(matchTest(3))
}
