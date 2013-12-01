package clashcode.wordguess.messages

// =============
// Messages broadcast to all players

class BroadcastMessage

case class GameStarted(gameId: String) extends BroadcastMessage
case class SuccessfulGuess(
  gameId: String,
  letter: Char,
  word: Seq[Option[Char]]) extends BroadcastMessage
