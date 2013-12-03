package clashcode.wordguess

import akka.actor._

object Main extends App {

  override def main(args: Array[String]) {
    val cfg = ClientCfg.loadDefault()
    val system = ActorSystem("local")
    
    val gameServer = system.actorFor(
      s"akka.tcp://cluster@${cfg.hostIp}:${cfg.port}/user/main")
    val actorProperties = Props(classOf[WordGuesserClient], s"@${cfg.playerName}", gameServer)
    val playerActor = system.actorOf(actorProperties, name = s"player-${cfg.playerName}")
  }
}