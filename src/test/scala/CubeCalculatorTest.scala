import org.scalatest.FunSuite

class CubeCalculatorTest extends FunSuite {

  test(testName="CubeCalculator.cube") {
    assert(CubeCalculator.cube(3) === 27)
  }

}
