package clashcode.wordguess

import akka.actor._

object Main extends App {
  lazy val localPlayerName = "playerSen"
  override def main(args: Array[String]) {
    val system = ActorSystem("local")
    val gameServer = system.actorFor("akka.tcp://cluster@127.0.0.1:9110/user/main")
    val playerActor = system.actorOf(Props(
      classOf[WordGuesserClient],
      s"@$localPlayerName",
      gameServer,
      system), s"player-$localPlayerName")
  }
}