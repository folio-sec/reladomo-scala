libraryDependencies += "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value

//addSbtPlugin("io.get-coursier"   % "sbt-coursier"    % "1.0.2")
addSbtPlugin("com.lucidchart"    % "sbt-scalafmt"    % "1.15")
addSbtPlugin("com.typesafe"      % "sbt-mima-plugin" % "0.1.18")
addSbtPlugin("com.timushev.sbt"  % "sbt-updates"     % "0.3.3")
addSbtPlugin("net.virtual-void"  % "sbt-dependency-graph" % "0.9.0")
addSbtPlugin("com.jsuereth"      % "sbt-pgp"         % "1.1.0")
addSbtPlugin("org.xerial.sbt"    % "sbt-sonatype"    % "2.2")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")
