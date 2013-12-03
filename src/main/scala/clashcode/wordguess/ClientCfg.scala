package clashcode.wordguess

import com.typesafe.config.ConfigFactory

trait ClientCfg {
  def port: Int
  def host: String
  def playerName: String
}

object ClientCfg {
  def loadDefault(): ClientCfg = {
    val loadedCfg = ConfigFactory.load()
    new ClientCfg {
      val port = loadedCfg.getInt("server.port")
      val host = loadedCfg.getString("server.host")
      val playerName = loadedCfg.getString("player.name")
    }
  }
}