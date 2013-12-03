package clashcode.wordguess

import com.typesafe.config.ConfigFactory

trait ClientCfg {
  def port: Int
  def hostIp: String
  def playerName: String
}

object ClientCfg {
  def loadDefault(): ClientCfg = {
    val loadedCfg = ConfigFactory.load()
    new ClientCfg {
      val port = loadedCfg.getInt("server.port")
      val hostIp = loadedCfg.getString("server.ip")
      val playerName = loadedCfg.getString("player.name")
    }
  }
}