package main

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import main.DeepThought._

@RunWith(classOf[JUnitRunner])
class MainSuite extends FunSuite {

  test("Answer to the Ultimate Question of Life, The Universe, and Everything") {
    assert(42 === 42)
  }

}
