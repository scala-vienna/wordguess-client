package dojo

import scala.collection.immutable.SortedMap

object FizzBuzz {

  val conditions = Map(
    { i => isFizz(i) } -> "Fizz",
    { i => isBuzz(i) } -> "Buzz",
    { i => isWizz(i) } -> "Wizz")

  def game(upperBound: Int): List[String] =
    (1 to upperBound).toList map (fizzbuzz(_))

  def fizzbuzz(i: Int) = {
    val res = conditions.foldLeft("") {
      case (s, (cond, word)) if (cond(i)) => (s + word + " ")
      case (s, _) => s
    }.trim match {
      case "" => i.toString
      case s => s
    }
    res
  }

  def isFizz(i: Int) = isDivisibleOrContains(i, 3)
  def isBuzz(i: Int) = isDivisibleOrContains(i, 5)
  def isWizz(i: Int) = isDivisibleOrContains(i, 7)
  
  def isDivisibleOrContains(num:Int, other:Int) = {
    num % other == 0 || num.toString.contains(other.toString)
  }

}