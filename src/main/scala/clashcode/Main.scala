package clashcode

import akka.actor._
import akka.event.Logging

//import scala.concurrent.duration.FiniteDuration
//import java.util.concurrent.TimeUnit

import scala.collection.mutable

import wordguess.messages._

object Main extends App {

  var system: ActorSystem = _

  class WordGuesser(playerName: String, gameServer: ActorRef) extends Actor {
    import scala.concurrent.ExecutionContext.Implicits._

    //val letterQueue = mutable.Queue[Char]('o', 'l', 'e', 'r', 'h', 'w', 'd')
    val letterQueue = mutable.Queue[Char]('r', 'y', 'o', 'u', 'p', 'q', 'k')
    
    // def getGuessLetter() = letterQueue.dequeue
    def getGuessLetter():Char = {
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
          if (!letterQueue.isEmpty) {
            val letter = getGuessLetter()
            //println("Making guess: " + letter)
            gameServer ! MakeGuess(letter)
          }
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

  override def main(args: Array[String]) {
    system = ActorSystem("local")
    val gameServer = system.actorFor("akka.tcp://cluster@127.0.0.1:9110/user/main")
    val playerActor = system.actorOf(Props(classOf[WordGuesser], "@playerSen", gameServer), "playerSen")
  }

}