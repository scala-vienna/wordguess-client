package dojo

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import dojo.FizzBuzz._

@RunWith(classOf[JUnitRunner])
class FizzBuzzSuite extends FunSuite {

  test("1 translates to 1") {
    assert("1" === fizzbuzz(1))
  }
  test("3 translates to Fizz") {
    assert("Fizz" === fizzbuzz(3))
  }
  test("5 translates to Buzz") {
    assert("Buzz" === fizzbuzz(5))
  }
  test("15 translates too Fizz Buzz") {
    assert("Fizz Buzz" === fizzbuzz(15))
  }
  test("6 translates to Fizz") {
    assert("Fizz" === fizzbuzz(6))
  }
  test("10 translates to Buzz") {
    assert("Buzz" === fizzbuzz(10))
  }

  test("30 translates to Fizz Buzz") {
    assert("Fizz Buzz" === fizzbuzz(30))
  }

  test("2 translates to 2") {
    assert("2" === fizzbuzz(2))
  }

  test("game to upper bound 1") {
    assert(game(1) === Seq("1"))
  }

  test("game to upper bound 2") {
    assert(game(2) === Seq("1", "2"))
  }

  test("game to upper bound 3") {
    assert(game(3) === Seq("1", "2", "Fizz"))
  }

  test("game to upper bound 5") {
    assert(game(5) === Seq("1", "2", "Fizz", "4", "Buzz"))
  }

  test("game to upper bound 15") {
    assert(game(15).last === "Fizz Buzz")
    assert(game(15)(14) === "Fizz Buzz")
  }
  test("7 translates to Wizz") {
    assert("Wizz" === fizzbuzz(7))
  }
  test("21 translates to Fizz Wizz") {
    assert(fizzbuzz(21) === "Fizz Wizz")
  }

  test("105 translates to Fizz Buzz Wizz") {
    assert(fizzbuzz(105) === "Fizz Buzz Wizz")
  }

  test("35 translates to Fizz Buzz Wizz") {
    assert(fizzbuzz(35) === "Fizz Buzz Wizz")
  }

  test("13 translates to Fizz") {
    assert(fizzbuzz(13) === "Fizz")
  }

  test("53 translates to Fizz Buzz") {
    assert(fizzbuzz(53) === "Fizz Buzz")
  }

  test("17 translates to Wizz") {
    assert(fizzbuzz(17) === "Wizz")
  }

}
