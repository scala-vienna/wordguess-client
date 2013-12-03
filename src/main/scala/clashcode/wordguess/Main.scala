package clashcode.wordguess

import akka.actor._

object Main extends App {

  override def main(args: Array[String]) {
    val cfg = ClientCfg.loadDefault()

    val system = ActorSystem("local")
    val gameServer = system.actorFor(
      s"akka.tcp://cluster@${cfg.host}:${cfg.port}/user/main")
    val playerActor = system.actorOf(Props(
      classOf[WordGuesserClient],
      s"@${cfg.playerName}",
      gameServer,
      system), s"player-${cfg.playerName}")
  }
}