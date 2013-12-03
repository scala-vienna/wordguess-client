package clashcode

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MainSuite extends FunSuite {

  test("Answer to the Ultimate Question of Life, The Universe, and Everything") {
    assert(42 === 42)
  }

}
