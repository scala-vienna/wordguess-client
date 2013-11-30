package clashcode

import akka.actor._
import akka.event.Logging
import scala.concurrent.duration.FiniteDuration
import java.util.concurrent.TimeUnit

import wordguess.messages._

object Main extends App {

  class WordGuesser(name: String, gameServer: ActorRef) extends Actor {
    import scala.concurrent.ExecutionContext.Implicits._

    //    context.system.scheduler.schedule(FiniteDuration(10, TimeUnit.SECONDS), FiniteDuration(1, TimeUnit.SECONDS)) {
    //      introduceYourself
    //    }

    gameServer ! RequestGame(playerName = name)

    def receive = {
      case status:GameStatus => {
        println("Got game status: " + status)
      }
    }

  }

  override def main(args: Array[String]) {
    val system = ActorSystem("local")
    val gameServer = system.actorFor("akka.tcp://cluster@127.0.0.1:9110/user/main")
    val playerActor = system.actorOf(Props(classOf[WordGuesser], "@playerSen", gameServer), "playerSen")
  }

}