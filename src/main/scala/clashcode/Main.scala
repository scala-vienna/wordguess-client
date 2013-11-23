package clashcode

import akka.actor._
import akka.event.Logging
import scala.concurrent.duration.FiniteDuration
import java.util.concurrent.TimeUnit

object Main extends App {

  
  class Investigator(name: String, prisonerA: ActorRef, prisonerB: ActorRef, onCompletion: (() => Unit)) extends Actor {

    var names: Map[ActorRef, String] = Map()
    var cooperates: Map[ActorRef, Boolean] = Map()

    prisonerA ! NameRequest
    prisonerB ! NameRequest

    def done() = {
      names.map(p => println(p._2 + " cooperates " + cooperates(p._1)))
      onCompletion()
    }

    def receive = {
      case x: PrisonerResponse => {
        cooperates = cooperates + (sender -> x.cooperate)
        if (cooperates.size == 2) done()
      }
      case h: Hello => {
        names = names + (sender -> h.name)
        sender match {
          case `prisonerA` => prisonerB ! PrisonerRequest(h.name)
          case `prisonerB` => prisonerA ! PrisonerRequest(h.name)
        }
      }
    }

  }

  class Prisoner(name: String, investigator: ActorRef) extends Actor {
    import scala.concurrent.ExecutionContext.Implicits._

    var cooperates: Map[String, Boolean] = Map()

    var count = 0
    var beNice = false;
    val alternate = true
    

    introduceYourself
    context.system.scheduler.schedule(FiniteDuration(10, TimeUnit.SECONDS), FiniteDuration(1, TimeUnit.SECONDS)) {
      introduceYourself
    }
    
    def introduceYourself = {
      println("sending HELLO")
      investigator ! Hello(name)
    }

    def receive = {
      case r: PrisonerResult => {
        cooperates = cooperates + (r.name -> r.cooperate)
      }
      case x: PrisonerRequest => {
        count = count + 1
        if (beNice) {
          val willCooperate = cooperates.getOrElse(x.name, math.random > 0.5);
          println("#" + count + " received request to cooperate with: " + x.name + " will respond with " + willCooperate)
          sender ! PrisonerResponse(willCooperate)
        } else {
          println("#" + count + " EVIL TWIN will not cooperate with: " + x.name)
          sender ! PrisonerResponse(false)
        }

        if (alternate && count % 50 == 0) {
          beNice = !beNice
        }

      }
      case NameRequest => {
        println("Sending my name")
        sender ! Hello(name)

      }
    }

  }

  override def main(args: Array[String]) {

    val system = ActorSystem("local")
    val investigator = system.actorFor("akka.tcp://cluster@192.168.3.72:110/user/main")
    val prisoner = system.actorOf(Props(classOf[Prisoner], "@p_brc", investigator), "prisonerPbrc")
  }

}