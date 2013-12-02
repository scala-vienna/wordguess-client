package clashcode.wordguess

import akka.actor._
import akka.event.Logging
import scala.collection.mutable

import messages._

class WordGuesserClient(playerName: String,
  gameServer: ActorRef, system: ActorSystem) extends Actor {

  def getGuessLetter(): Char = {
    print("Letter to guess: ")
    Console.readChar
  }

  gameServer ! RequestGame(playerName)

  def receive = {
    case status: GameStatus => {
      val wordRepresentation = status.word.map(optC => optC.getOrElse('_')).mkString
      println("Word: " + wordRepresentation)
      println("Remaining tries: " + status.remainingTries)
      if (status.remainingTries > 0) {
        val letter = getGuessLetter()
        gameServer ! MakeGuess(letter)
      }
    }
    case NoAvailableGames() => {
      println("No more games to play - Bye")
      system.shutdown()
    }
    case NotPlayingError() => {
      println("We are not playing")
      system.shutdown()
    }
    case GameWon(status) => {
      println("We won the game!")
      println("The word was: " + status.word.map(_.getOrElse('?')).mkString)
      system.shutdown()
    }
    case GameLost(status) => {
      println("We lost the game :-(")
      println("Remaining word: " + status.word.map(_.getOrElse('_')).mkString)
      system.shutdown()
    }
  }

}