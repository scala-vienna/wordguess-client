package clashcode.wordguess

import akka.actor._

object Main extends App {
  lazy val gameServerPort = 9110
  lazy val gameServerHost = "127.0.0.1"
  lazy val localPlayerName = "playerSen"
  override def main(args: Array[String]) {
    val system = ActorSystem("local")
    val gameServer = system.actorFor(
      s"akka.tcp://cluster@$gameServerHost:$gameServerPort/user/main")
    val playerActor = system.actorOf(Props(
      classOf[WordGuesserClient],
      s"@$localPlayerName",
      gameServer,
      system), s"player-$localPlayerName")
  }
}