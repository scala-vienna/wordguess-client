package clashcode.wordguess.messages

/**
 * Messages sent to the server
 */

// Request to participate in a game
// the name is descriptive, it is not an unique-id
case class RequestGame(playerName: String)

// Sent to the server to make a guess in the current game
case class MakeGuess(letter: Char)

// Used to send a message to all other players
case class SendToAll(msg: String)