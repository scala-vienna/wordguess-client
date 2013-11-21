package clashcode

/**
 * Akka Workshop:
 * Contains all the Akka Messages sent between Actors.
 * Needs to be in the clashcode package.
 */

/** [Investigator] Ask prisoners name */
case object NameRequest

/** [Prisoner] Tell investigator your name (max 12 chars) */
case class Hello(name: String)

/** [Investigator] Tells the name of other prisoner, asks: do you cooperate or defect? */
case class PrisonerRequest(name: String)

/** [Prisoner] Answer to PrisonerRequest: cooperate or defect. */
case class PrisonerResponse(cooperate: Boolean)

