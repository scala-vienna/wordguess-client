package clashcode.wordguess

import akka.actor._
import akka.event.Logging
import scala.collection.mutable

import messages._

class WordGuesserClient(playerName: String,
  gameServer: ActorRef, system: ActorSystem) extends Actor {

  // IMPORTANT: start by requesting a game to the server
  // (see methods below)
  
  // Incoming messages from the server are handled here
  override def receive = {
    // When a game was accepted or after a guess was made
    case status: GameStatus => {}
    // When the game was won
    case GameWon(status) => {}
    // When the game was lost
    case GameLost(status) => {}
    // If there are no available games (rare)
    case NoAvailableGames() => {}
    // If the client has no active game, but a guess was made
    case NotPlayingError() => {}
    // When an incoming message arrives (ignore this for now)
    case MsgToAll(msg) => {}
  }

  // Request a game from the server; start by doing this
  def requestGameFor(playerName: String) {
    gameServer ! RequestGame(playerName)
  }
  // You try to guess the word by making guesses
  def makeGuess(letter: Char) {
    gameServer ! MakeGuess(letter)
  }
  // You can stop your local app with this (shutdown the actor-system)
  def stopApplication() {
    system.shutdown()
  }
  // Ignore this for now
  def broadCastMsg(msg: String) {
    gameServer ! SendToAll(msg)
  }

}