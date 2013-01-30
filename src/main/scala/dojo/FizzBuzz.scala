package dojo

object FizzBuzz {
  val default = List((3, "Fizz"), (5, "Buzz"), (7, "Wizz"))

  def game(upperBound: Int) = (1 to upperBound) map (fizzbuzz(_))

  def fizzbuzz(num: Int, conditions: List[(Int, String)] = default, acc: List[String] = Nil): String = conditions match {
    case Nil => if (acc.isEmpty) num.toString else acc.reverse.mkString(" ")
    case ((prime, word) :: xy) =>
      val check = if (num % prime == 0 || num.toString.contains(prime.toString)) word :: acc else acc
      fizzbuzz(num, xy, check)
  }
}