object ObjectCalculator extends App {

  val test = (a: Int, b: Int) => a * b

  def cubeMethod(x: Int): Int = {
    x * x * x
  }

  def cubeMethod2(a: Int, b: Int)(c: Int):Int = {
    val result = a * b *  c
    result
  }
}
