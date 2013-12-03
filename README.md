# WordGuess Client

This is the Akka client for the word-guess game for this coding-dojo of the Scala Vienna User Group:

http://www.meetup.com/scala-vienna/events/122006312/

## Requirements:

- SBT 0.13.0
- An IDE (Eclipse, IntelliJ) with Scala support

If you use **SBT 0.12.x** you have to edit `project/plugins.sbt`. Follow instructions there.

## Configuration

Unless stated otherwise by the Dojo facilitator, follow these instructions.

### Changes to `application.conf`

Gather information:

- Find out the **IP address** of your *local* machine
- Ask the facilitator the **IP address** and PORT of the *server*

Edit the client settings:

- Edit `src/main/resources/application.conf`
- Enter the server port in `server.port`
- Enter the server IP address in `server.ip`
- Enter your IP address in `local.ip`
- Enter an original, but short, **player-name** for `local.player` (e.g. "HomerSimpson")

IMPORTANT: IP-addresses have to be put in double-quotes. Otherwise the configuration lib tries to parse it as a float.

## Procedure

Follow the instructions in `WordGuesserClient` and from the facilitator.

Remember: the goal is not to finish but to learn and have fun!

Enjoy the dojo!