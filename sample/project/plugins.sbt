resolvers += "sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
lazy val reladomoScalaV = sys.env.get("RELEASE_VERSION").getOrElse("16.6.0-SNAPSHOT")
addSbtPlugin("com.folio-sec" % "sbt-reladomo-plugin" % reladomoScalaV)

addSbtPlugin("com.lucidchart"  % "sbt-scalafmt" % "1.14")
//addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC12-1")
