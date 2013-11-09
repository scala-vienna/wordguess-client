# Quick-start project for Scala Coding Dojos

* Eclipse and IntelliJ IDEA SBT support plugins already configured
* Uses Scala 2.10.2 -> you will need an IDE that supports it!

## How-to: use this project

1. Install SBT! See [http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html](http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html)
1. Clone this repository to your local computer
1. `cd dojo-quickstart`
1. Type `sbt`
1. On the SBT prompt type either `eclipse` or `gen-idea` to generate Eclipse and IntelliJ IDEA project files.
1. Import the project into your IDE.
1. Start coding! ;-)

## Further customization (optional)

If you want to change the generic names of this quick-start project, follow these instructions:

1. Remove the project from the IDE and exit sbt
1. Rename the directory to your liking
1. Go to `build.sbt` and change the `name` of the project
1. Enter `sbt` again and re-generate the IDE project either with `eclipse` or `gen-idea`
1. Import the project into your IDE
1. Change the name of the main classes, packages, etc.

When re-naming packages, make sure that you rename it **both** under "main" and "test".