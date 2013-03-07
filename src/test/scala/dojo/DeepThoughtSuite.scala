package dojo

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import dojo.DeepThought._

@RunWith(classOf[JUnitRunner])
class DeepThoughtSuite extends FunSuite {

  test("Answer to the Ultimate Question of Life, The Universe, and Everything") {
    assert(42 === compute("foo"))
  }
}
