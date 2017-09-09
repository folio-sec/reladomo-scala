import sbt._

object Publishing {
  lazy val theGitRepositoryName = "reladomo-scala"
  lazy val theScalaOptions     = Seq("-unchecked", "-deprecation", "-feature")
  lazy val thePomExtra =
    <url>https://github.com/folio-sec/{theGitRepositoryName}</url>
      <licenses>
        <license>
          <name>Apache License, Version 2.0</name>
          <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
          <distribution>repo</distribution>
        </license>
      </licenses>
      <scm>
        <url>git@github.com:folio-sec/{theGitRepositoryName}.git</url>
        <connection>scm:git:git@github.com:folio-sec/{theGitRepositoryName}.git</connection>
      </scm>
      <developers>
        <developer>
          <id>seratch</id>
          <name>Kazuhiro Sera</name>
          <url>https://git.io/sera</url>
        </developer>
        <developer>
          <id>matsu-chara</id>
          <name>matsu-chara</name>
          <url>https://github.com/matsu-chara</url>
        </developer>
        <developer>
          <id>komsit37</id>
          <name>komsit37</name>
          <url>https://github.com/komsit37</url>
        </developer>
        <developer>
          <id>itohiro73</id>
          <name>Hiroshi Ito</name>
          <url>https://github.com/itohiro73</url>
        </developer>
      </developers>

  def doPublishTo(v: String) = {
    val nexus = "https://oss.sonatype.org/"
    if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
    else Some("releases" at nexus + "service/local/staging/deploy/maven2")
  }
}
