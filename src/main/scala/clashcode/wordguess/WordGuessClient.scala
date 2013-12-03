package clashcode.wordguess

import akka.actor._
import akka.event.Logging
import scala.collection.mutable

import messages._

class WordGuesserClient(playerName: String, gameServer: ActorRef) extends Actor {
      
  // IMPORTANT: 
  // 1) start by requesting a game to the server
  // 2) the workflow is ASYNCHRONOUS; so don't participate in a game
  // until you know you are in one.

  // Main methods at your disposal:
  // requestGame()
  // makeGuess('a')
  
  // Incoming messages from the server are handled here
  override def receive = {
    // When a game was accepted or after a guess was made
    case status: GameStatus => {}
    // When the game was won
    case GameWon(status) => {}
    // When the game was lost
    case GameLost(status) => {}
    // If there are no more available games (rare, but could happen)
    case NoAvailableGames() => {}
    // If the client (you) made a guess although no game was requested (or is over)
    case NotPlayingError() => {}
    // When an incoming message arrives (ignore this for now)
    case MsgToAll(msg) => {}
  }

  // Request a game from the server; start by doing this
  def requestGame() {
    gameServer ! RequestGame(playerName)
  }
  // You try to guess the word by making guesses
  def makeGuess(letter: Char) {
    gameServer ! MakeGuess(letter)
  }
  // You can stop your local app with this (shutdown the actor-system)
  def stopApplication() {
    context.system.shutdown()
  }
  // Ignore this for now
  def broadCastMsg(msg: String) {
    gameServer ! SendToAll(msg)
  }

}