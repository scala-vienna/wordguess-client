# Quick-start project for Scala Coding Dojos

* Eclipse and IntelliJ IDEA SBT support plugins already configured.
* Uses Scala 2.10.2 -> you will need an IDE that supports it!

## How-to: use this project

1. Install SBT! See [http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html]
1. Clone this repository to your local computer
1. `cd dojo-quickstart`
1. Type `sbt`
1. On the SBT prompt type either `eclipse` or `gen-idea` to generate Eclipse and IntelliJ IDEA project files.
1. Start coding! ;-)

## How-to: create a new repo for a dojo

1. Create a repo for the dojo code on https://github.com/scala-vienna say you call dojo-YYYY-MM
1. `git clone git@github.com:scala-vienna/dojo-YYYY-MM.git`
1. `cd dojo-YYYY-MM`
1. `git remote add quickstart git@github.com:scala-vienna/dojo-quickstart.git`
1. `git pull quickstart master`
1. `git push -u origin master`
1. `git remote rm quickstart`

More info available at http://scala-vienna.org/admin