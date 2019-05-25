import org.scalatest.FunSuite

class CubeCalculatorTest extends FunSuite {

  test(testName = "CubeCalculator.cubeMethod") {
    assert(ObjectCalculator.cubeMethod(3) === 27)
  }

  test(testName = "CubeCalculator.cubeMethod2") {
    assert(ObjectCalculator.cubeMethod2(1, 2)(3) === 6)
  }
}
